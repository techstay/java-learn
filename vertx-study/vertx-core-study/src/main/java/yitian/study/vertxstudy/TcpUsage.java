package yitian.study.vertxstudy;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.net.NetSocket;

import java.time.LocalDateTime;

public class TcpUsage {
    public static void tcpServer() {
        Vertx vertx = Vertx.vertx();
        NetServer server1 = vertx.createNetServer();

        NetServerOptions options = new NetServerOptions();
        options.setPort(1234);
        NetServer server2 = vertx.createNetServer(options);

        server1.close();
        server2.close();
    }

    public static void tcpConnection() {
        Vertx vertx = Vertx.vertx();
        //创建服务器
        NetServer server = vertx.createNetServer();
        //设置发送数据监听器
        server.connectHandler(handler -> {
            handler.write("当前时间是:" + LocalDateTime.now());
        });
        //监听随机端口号
        server.listen(0, "localhost", res -> {
            if (res.succeeded()) {
                System.out.println("服务器监听成功，端口号是:" + server.actualPort());
            } else {
                System.out.println("服务器监听失败，原因是:" + res.cause());
            }
        });


        //创建客户端
        NetClient client = vertx.createNetClient();
        client.connect(server.actualPort(), "localhost", handler -> {
            if (handler.succeeded()) {
                System.out.println("与服务器连接成功");
                //连接成功，获取数据
                NetSocket socket = handler.result();
                socket.handler(buffer -> {
                    System.out.println(buffer.getString(0, buffer.length()));
                });
            } else {
                System.out.println("与服务器连接失败，原因是:" + handler.cause());
            }
        });

        //关闭客户端
        client.close();
        System.out.println("客户端已关闭");

        server.close(res -> {
            if (res.succeeded()) {
                System.out.println("服务器已成功关闭");
            } else {
                System.out.println("服务器关闭失败，原因:" + res.cause());
            }
        });
    }
}

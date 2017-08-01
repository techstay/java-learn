package yitian.study.vertxstudy;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpServer;

public class HttpUsage {
    public static void startHttpServer() {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(request -> {
            request.response().setChunked(true).write("Hello, Vertx!").end();
        });

        server.listen(8080, "localhost", res -> {
            if (res.succeeded()) {
                System.out.println("成功监听请求:" + res.result());
            }
        });
    }

    public static void httpClient() {
        Vertx vertx = Vertx.vertx();
        HttpClient client = vertx.createHttpClient();
        client.getNow("httpbin.org", "/get", response -> {
            response.bodyHandler(System.out::println);
        });
    }

}

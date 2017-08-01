package yitian.study.vertxstudy;

import io.vertx.core.buffer.Buffer;

public class BufferUsage {
    public static void createBuffer() {
        //创建空Buffer
        Buffer buffer1 = Buffer.buffer();
        Buffer buffer2 = Buffer.buffer(new byte[]{1, 2, 3, 4, 5});
        Buffer buffer3 = Buffer.buffer("abcde");
        Buffer buffer4 = Buffer.buffer("一二三四五", "utf-8");
        //创建带初始大小的Buffer
        Buffer buffer5 = Buffer.buffer(1024);
    }

    public static void writeAndReadBuffer() {
        Buffer buffer = Buffer.buffer();
        //追加写入方式
        buffer.appendString("some text");

        //随机写入方式
        buffer.setString(9, "abcde\n");

        //读取数据
        for (int i = 0; i < buffer.length(); ++i) {
            System.out.print(buffer.getShort(i));
        }
    }
}

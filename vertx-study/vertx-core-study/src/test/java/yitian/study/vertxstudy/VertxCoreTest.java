package yitian.study.vertxstudy;

import org.junit.Test;

public class VertxCoreTest {
    @Test
    public void testVertxObject() {
        StartUsage.createVerxObject();
    }

    @Test
    public void testJson() {
        JsonUsage.jsonObject();
        JsonUsage.jsonArray();
    }

    @Test
    public void testBuffer() {
        BufferUsage.createBuffer();
        BufferUsage.writeAndReadBuffer();
    }

    @Test
    public void testTcp() {
        TcpUsage.tcpServer();
        TcpUsage.tcpConnection();
    }

    @Test
    public void testHttp() {
        HttpUsage.httpClient();
    }
}

package yitian.study.vertxwebclientstudy;

import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.ext.web.codec.BodyCodec;

public class WebClientUsage {
    private WebClient webClient;

    public void createWebClient() {
        Vertx vertx = Vertx.vertx();
        webClient = WebClient.create(vertx, new WebClientOptions());

    }

    public void makeRequests() {
        //无请求体的请求
        webClient.get("www.baidu.com", "/")
                .send(ar -> {
                    if (ar.succeeded()) {
                        HttpResponse<Buffer> response = ar.result();
                        System.out.println(response.body());
                    } else {
                        System.out.println(ar.cause());
                    }
                });

        //带请求体的请求
        webClient.post("httpbin.org", "/post")
                .sendBuffer(Buffer.buffer("name=yitian&age=25"), ar -> {
                    if (ar.succeeded()) {
                        HttpResponse<Buffer> response = ar.result();
                        System.out.println(response.body());
                    }
                });
        //发送表单
        MultiMap multiMap = MultiMap.caseInsensitiveMultiMap();
        multiMap.add("name", "yitian");
        multiMap.add("age", "25");
        webClient.post("httpbin.org", "/post")
                .sendForm(multiMap, ar -> {
                    if (ar.succeeded()) {
                        HttpResponse<Buffer> response = ar.result();
                        System.out.println(response.body());
                    }
                });
    }

    public void handleResponse() {
        //转化为JsonObject
        webClient.post("httpbin.org", "/post")
                .as(BodyCodec.jsonObject())
                .sendBuffer(Buffer.buffer("name=yitian&age=25"), ar -> {
                    if (ar.succeeded()) {
                        HttpResponse<JsonObject> response = ar.result();
                        System.out.println(response.body());
                    }
                });
    }

    public static void main(String[] args) {
        WebClientUsage webClientUsage = new WebClientUsage();
        webClientUsage.createWebClient();
        webClientUsage.makeRequests();
        webClientUsage.handleResponse();
    }
}

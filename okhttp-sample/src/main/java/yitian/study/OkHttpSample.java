package yitian.study;

import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

class OkHttpSample {
    static void getWebContent() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String baidu_url = "https://www.baidu.com";
        Request request = new Request.Builder()
                .url(baidu_url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            Headers headers = response.headers();
            String body = response.body().string();
            System.out.println("--------headers--------\n" + headers);
            System.out.println("--------body--------\n" + body);
        }

    }

    static void postForm() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "http://httpbin.org/post";
        RequestBody requestBody = new FormBody.Builder().add("name", "yitian")
                .add("age", "25")
                .build();

        // 等价方法
//        requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf8"),
//                "name=yitian&age=25");
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        String body = client.newCall(request).execute().body().string();
        System.out.println("---------post form---------");
        System.out.println(body);
    }

    static void getWebContentAsync() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String baidu_url = "https://www.baidu.com";
        Request request = new Request.Builder()
                .url(baidu_url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers = response.headers();
                String body = response.body().string();
                System.out.println("--------headers--------\n" + headers);
                System.out.println("--------body--------\n" + body);
            }
        });
    }

    static void downloadImage() {
        String img_url = "http://imgsrc.baidu.com/forum/pic/item/887018fa828ba61e7e0990be4a34970a314e5905.jpg";

        Request request = new Request.Builder().url(img_url).build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (InputStream input = response.body().byteStream()) {
                    File image = new File("src/main/resources/img.jpg");
                    Files.copy(input, image.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        });
    }

    static void uploadFile() throws IOException {
        String url = "http://httpbin.org/post";
        File file = new File("src/main/resources/hello.txt");
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), requestBody)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                System.out.println(body);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        // 获取网页内容
        getWebContent();
        // 异步方式获取网页内容
        getWebContentAsync();
        // POST方式发送表单
        postForm();
        // 下载文件
        System.out.println("-------下载文件--------");
        downloadImage();
        // 上传文件
        System.out.println("-------上传文件--------");
        uploadFile();
    }
}
package co.edu.escuelaing.sparkdockerdemolive;

import java.io.IOException;

import okhttp3.*;

public class HttpClient {
    private OkHttpClient httpClient;
    private String baseUrl="";
    private String[] ports={":35001",":35002",":35003"};
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private int serverNumber=0;


    public HttpClient() {
        httpClient=new OkHttpClient();
    }


    public String getMessages(String path) throws IOException {
        Request request = request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .get()
                .build();
        System.out.println("sendig request to"+baseUrl+ports[serverNumber]+path);
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public String postMessage( String message,String path) throws IOException {
        RequestBody body = RequestBody.create(message,JSON);
        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .post(body)
                .build();
        System.out.println("sendig request to"+baseUrl+ports[serverNumber]+path);
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public void wordRound(){

        this.serverNumber=(this.serverNumber+1)% ports.length;
    }
}

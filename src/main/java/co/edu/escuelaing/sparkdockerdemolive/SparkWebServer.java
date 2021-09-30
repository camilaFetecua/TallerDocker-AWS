package co.edu.escuelaing.sparkdockerdemolive;



import java.awt.*;

import static spark.Spark.*;


/**
 * Hello world!
 *
 */
public class SparkWebServer {

    private static HttpClient client = new HttpClient();

    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        get("/hello", (req,res) -> "Hello Docker!");
        get("/word", (req,res) -> {
            System.out.println("BODY");
            System.out.println(req.body());
            String response = client.getMessages("/word");
            client.wordRound();
            return response;
        });
        post("/add", (req, res) -> {
            System.out.println("BODY");
            System.out.println(req.body());
            String response = client.postMessage(req.body(), "/add");
            client.wordRound();
            return response;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}

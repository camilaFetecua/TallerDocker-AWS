package co.edu.escuelaing.Docker;


import static spark.Spark.*;

public class SparkDocker {
    public static void main(String... args) {
        MongoServer database = new MongoServer();
        port(getPort());
        get("/hello", (req,res) -> "Hello Docker!");
        get("/words", (req,res) -> {
            System.out.println(database.getWord());
            return database.getWord();
        });
        post("/add", (request, response) -> {
            String req = request.body();
            database.addWord(req);
            return "{\"confirm\":" + "ok" + "}";
        });
    }
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}

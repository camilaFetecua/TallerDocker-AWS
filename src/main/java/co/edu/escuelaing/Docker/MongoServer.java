package co.edu.escuelaing.Docker;

import java.util.Date;
import java.util.HashMap;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoServer {
    private MongoCollection<org.bson.Document> colum;

    public MongoServer() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://camilafetecua:camila9803@0.0.0.0:27017/?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=docker&authMechanism=SCRAM-SHA-1&3t.uriVersion=3");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("docker");
        colum = database.getCollection("word");
    }

    public String getWord() {
        String words = "[";
        Word word;
        for (Document d : colum.find()) {
            word = new Word(d.get("word").toString(), d.get("fecha").toString());
            words += word.toString() + ",";
        }

        if (colum.count() == 0) words = "[ ";
        words = words.substring(0, words.length() - 1);
        words += "]";
        return words;
    }

    public void addWord(String word) {
        Word word1 = this.toWord(word);
        HashMap<String, Object> hashmap = new HashMap<>();
        String words = word1.getWord();
        String date = word1.getDate();
        hashmap.put("word", word);
        Date newdate = new Date();
        String datenew = newdate.toString();
        hashmap.put("date", datenew);
        Document newWord = new Document(hashmap);
        colum.insertOne(newWord);
    }

    public Word toWord(String string) {

        String json = string.substring(1, string.length() - 1);
        json = json.replace("\"", "");
        String[] json1 = json.split(",");
        HashMap<String, String> data = new HashMap<>();

        for (String value: json1) {
            String[] dic = value.split(":");
            data.put(dic[0].trim(), dic[1].trim());
        }

        Word word = new Word(data.get("word"),data.get("date"));

        return word;
    }
}

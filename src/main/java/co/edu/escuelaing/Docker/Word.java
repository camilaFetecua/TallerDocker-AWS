package co.edu.escuelaing.Docker;

public class Word{

    private String word;
    private String date;
    public Word(String word, String date) {
        this.word = word;
        this.date = date;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return "{\"Date\": " + "\"" + date +  "\"" + ", \"Word\": " + "\"" + word + "\"" + "}";
    }

}

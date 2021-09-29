package co.edu.escuelaing.arep;

public class Wol{

    private String palabra;
    private String date;
    public Palabra(String palabra, String date) {
        this.palabra = palabra;
        this.date = date;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return "{\"date\": " + "\"" + date +  "\"" + ", \"descripcion\": " + "\"" + descripcion + "\"" + "}";
    }

}

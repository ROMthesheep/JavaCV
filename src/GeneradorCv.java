import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GeneradorCv {
    public static void GeneradorCv(ArrayList<String> formacion, ArrayList<String> experiencia, String nombre, String telefono, String correo, BufferedWriter bww){
        try{
        bww.write("<!DOCTYPE html><html lang=\"en\"><head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n" +
                "<title>Curiculum vitae</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "  <div class=\"jumbotron container-xl\">\n" +
                "    <h1 class=\"display-4\">"+ nombre +"</h1>\n" +
                "    <h5 class=\"lead\">Bienvenido a mi Curiculum vitae</h5>\n" +
                "    <hr class=\"my-4\">\n" +
                "    <p>Telefono: "+telefono+"</p>\n" +
                "    <p>correo: "+ correo +"</p>\n" +
                "    <p>CV generado por codigo como actividad para a asignatira de programamcion.</p>\n" +
                "  </div>\n" +
                "  <article class=\"card container-xl\">\n" +
                "    <section>" +
                "<h1>Formacion: </h1>");
            formacion.forEach(n -> {
                try {
                    bww.write("<p>"+n+"</p>");
                } catch (IOException e) {
                    System.out.println("error");
                }
            });
            bww.write("<hr>" +
                    "    </section>\n" +
                    "    <section>\n" +
                    "      <h1>Experencia laboral: </h1>");
            experiencia.forEach(n -> {
                try {
                    bww.write("<p>"+n+"</p>");
                } catch (IOException e) {
                    System.out.println("error");
                }
            });
        }
        catch (IOException ioe){
            System.out.println("error");}
    }
    }


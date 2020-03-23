import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Datos {
    public static void main(String[] args) {
        try {
            //variables de sistema
            Scanner s = new Scanner(System.in);
            BufferedWriter bw = new BufferedWriter(new FileWriter("CV.html"));
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            //datos
            ArrayList<String> formacion = new ArrayList<String>();
            ArrayList<String> experiencia = new ArrayList<String>();
            String nombre = new String();
            String telefono = new String();
            String correo = new String();
            //utilitarios
            boolean run=true;
            String aux = "";
            int fase=0;

            /* RUINAS DE LA ANTIGUA OBTENCION DE DATOS | F
            System.out.println("Bienvenido al generador de CV");
            System.out.print("Introduce tu nombre: ");
            nombre = s.nextLine();
            System.out.print("Introduce tu correo: ");
            correo = s.nextLine();
            System.out.print("Introduce tu telefono: ");
            telefono = s.nextLine();
            System.out.println("Introduce tu formacion, introduce una linea en blanco para terminar de introducir valores");
            do{
                aux=s.nextLine();
                if (aux.isEmpty()){
                    run=false;
                }
                else {
                    formacion.add(aux);
                }
            }while(run);
            run=true;
            System.out.println("Introduce tu expriencia laboral, introduce una linea en blanco para terminar de introducir valores");
            do{
                aux=s.nextLine();
                if (aux.isEmpty()){
                    run=false;
                }
                else {
                    experiencia.add(aux);
                }
            }while(run);
                */
            do { // tomamos por sentado que el usuario ha creado en el orden correcto el CV
                aux=br.readLine();
                if (!(aux != null && !aux.isEmpty())){ //Deteccion EOF, expresada con doble negacion ya que java no permite comprara positivamente al conjunto vacio y una cadena
                    run=false;
                }else if (aux.substring(0,3).equals(">>>")){ //Deteccion de apartados
                   fase++;
                }
                else{
                    switch (fase){ // asignacion de datos segun fase de documento
                        case 1:
                            nombre=aux;
                            break;
                        case 2:
                            telefono=aux;
                            break;
                        case 3:
                            correo=aux;
                            break;
                        case 4:
                            formacion.add(aux);
                            break;
                        case 5:
                            experiencia.add(aux);
                            break;
                    }
                }
            }
            while (run);

            GeneradorCv.GeneradorCv(formacion,experiencia,nombre,telefono,correo,bw); //Generacion del CV
            bw.close();
        }
        catch (IOException ioe){
            System.out.println("error al crear el fichero.");
        }
    }
}

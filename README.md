# JavaCV

Programa en Java que transforma informacion de un archivo de texto en una pagina html, en este caso, un curiculum vitae.
La Informacion debe estar formateada de la siguiente forma:

```
>>>nombre
Nombre del sujeto
>>>telefono
Telefono del sujeto
>>>correo
Correo del sujeto
>>>formacion
Formacion del sujeto
>>>experiencialaboral
Experiencia del sujeto
```

El programa usa las ```>>>``` como señal de cambio de tipo de dato, por lo que debe respetarse el orden de los datos.

La logica del programa es la siguiente:

```java
String aux = "";
int fase=0;
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
```

package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Examen {
    static Scanner scn = new Scanner(System.in).useLocale(Locale.US);//useLocale(Locale.US) es para evitar un error de formato a la hora de poner decimales
    public static void ejercicio1() {
        System.out.println("Introduce un número: ");
        int num = getInt();
        if (num < 0){
            num *= -1;
        }

        System.out.println("El valor absoluto del número es " + num);
    }
    public static void ejercicio2() {
        System.out.println("Introduce tu nombre: ");
        String nombre = scn.nextLine(); //Si no llamamos a la "nextLine" el siguiente getFloat() cogerá el valor del nombre  y hará una primera iteración :D
        System.out.println("La obra de "+nombre);


        System.out.println("Introduce el ancho de la pared...");
        float anchoPared = positiveFloat(); //Llamamos a la función descrita abajo
        System.out.println("Introduce el altura de la pared...");
        float alturaPared = positiveFloat();
        System.out.println("Introduce el ancho del azulejo...");
        float anchoAzulejo = positiveFloat();
        System.out.println("Introduce el altura del azulejo...");
        float alturaAzulejo = positiveFloat();

        float m2pared; //Necesitaremos almacenar los metros cuadrados que ocupa la pared
        float m2azulejo; //También los m2 del azulejo

        if (anchoAzulejo == alturaAzulejo){ //Con un simple sistema de if es más que suficiente para estas comprobaciones. Si ambos lados del azulejo son iguales, saldremos del sistema de "ifs"
            System.out.println("El azulejo no puede ser cuadrado");
        } else if ((anchoPared < anchoAzulejo) && (alturaPared < alturaAzulejo)){ //Aquí comprobaremos que el alto y al ancho son menores quel de la pared
            System.out.println("El azulejo no puede ser más grande que la pared");
        } else {
            m2pared = anchoPared * alturaPared;
            m2azulejo = anchoAzulejo * alturaAzulejo;

            System.out.println("Se necesitan " + (m2pared/m2azulejo)); //Como es un calculo muy sencillo no necesitamos una variable
        }

    }

    public static int getInt(){ //Le indicamos a la función que vamos a extraer un integer
        int result = 0; //Declaramos una variable para sacar el resultado
        boolean valid = false; //Le damos el valor por defecto en false para que repita el bucle si sale el error al intentar parsear
        do {
            try {
                String value = scn.nextLine(); //Leeremos la siguiente "Linea" para que sea necesario esperar al Enter
                result = Integer.parseInt(value); //Ahora intentamos parsear el String "value" a integer
                valid = true; //Si no ha salido error, cambiaremos valid a true haciendo que se rompa el bucle while.

            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido."); //Si el numero no ha podido ser parseado, le informaremos y pediremos que lo intente de nuevo
            }
        } while (!valid);

        return result; //Aquí devolveremos el resultado como int para cuando sea pedido
    }

    public static float getFloat(){ //Lo mismo que en el apartado anterior pero ahora con un valor Float (en vez de Double para que no ocupe tanta memoria)
        float result = 0;
        boolean valid = false;
        do {
            try {
                String value = scn.nextLine();
                result = Float.parseFloat(value);

                valid = true;

            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        } while (!valid);

        return result;
    }

    public static float positiveFloat() {
        boolean positive = false;
        float value = 0f;
        do {
            value = getFloat(); //Llamamos a la función que estrae el float
            if (value > 0) {
                positive = true; //Si es positivo salimos del bucle
            } else {
                System.out.println("Introduce un valor positivo."); //Si no lo es, saca el mensaje de error
            }
        }
        while (!positive);
        return value;
    }
}

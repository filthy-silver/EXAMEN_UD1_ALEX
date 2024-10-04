package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {

        System.out.println("Para [Ejercicio 1] pulsa 1\nPara [Ejercicio 2] pulsa 1");

        Integer ejercicioN = null;

        try {
            ;
            ejercicioN = Examen.getInt();
        }
        catch (NumberFormatException | InputMismatchException e) {

            System.out.println("Introduce un número válido.\n");
            scn.nextLine();
        }

        if (ejercicioN == 1) {
            Examen.ejercicio1();
        } else if (ejercicioN == 2) {
            Examen.ejercicio2();
        }

        else {
            System.out.println("Ejercicio no encontrado.");
        }
    }
}
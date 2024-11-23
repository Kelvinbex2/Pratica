package es.etg.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dam2 {
    private static final String[] COMMANDO = { "java", "es.etg.psp.Daw1" };
    public static void main(String[] args) {
        

        try {
            System.out.println("Soy de Dam2");
            App.ejecutar(COMMANDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

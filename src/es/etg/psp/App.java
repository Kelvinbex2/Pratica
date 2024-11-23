package es.etg.psp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static final String[] COMMANDO = { "java", "es.etg.psp.Dam1" };
   
    public static void main(String[] args) throws Exception {

        int exitVal = 0;
        StringBuilder outBuilder = new StringBuilder();
        String line;
        try {
            Process proc = Runtime.getRuntime().exec(COMMANDO);
            BufferedReader out = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((line = out.readLine()) != null) {
                outBuilder.append(line).append(System.lineSeparator());
            }

            exitVal = proc.waitFor();
            if (exitVal == 0) {
                System.out.println(Entrada.ERR_BUENO);
                System.out.println(outBuilder);
            } else {
                System.out.println(Entrada.ERR_MALO);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    
}

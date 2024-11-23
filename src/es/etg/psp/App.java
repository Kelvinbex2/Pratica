package es.etg.psp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static final String[] COMMANDO = { "java", "es.etg.psp.Dam1" };
   
    public static void main(String[] args) throws Exception {

        try {
            System.out.println(Entrada.MSG_PADRE);
            ejecutar(COMMANDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    public static int ejecutar(String [] comando){
        int exitVal = 0;
        StringBuilder outBuilder = new StringBuilder();
        String line;
        try {
            Process proc = Runtime.getRuntime().exec(comando);
            BufferedReader out = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((line = out.readLine()) != null) {
                outBuilder.append(line).append(System.lineSeparator());
            }

            exitVal = proc.waitFor();
            if (exitVal == 0) {
                //System.out.println(Entrada.ERR_BUENO);
                System.out.println(outBuilder);
            } else {
                System.out.println(Entrada.ERR_MALO);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        return   exitVal;
    }

    
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.StandardOpenOption;


public class SensorTelecom {
    private String tipo;
    private double frequencia;
    private boolean sinalEstavel;

    public SensorTelecom() {
        // Construtor padrão vazio
    }


    Path arquivo = Paths.get("Relatório.txt");

    public SensorTelecom(String tipo, double frequencia, boolean sinalEstavel) {
        this.tipo = tipo;
        this.frequencia = frequencia;
        this.sinalEstavel = sinalEstavel;
    }


    public void enviarSinal() {

        try{
            Files.writeString(arquivo, "[Sensor] Enviando sinal de " + tipo + " (" + frequencia + " MHz)..." + System.lineSeparator(), StandardOpenOption.APPEND);

        }
        catch(IOException e){e.printStackTrace();}


        System.out.println("[Sensor] Enviando sinal de " + tipo + " (" + frequencia + " MHz)...");
    }

    public boolean isSinalEstavel() { return sinalEstavel; }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public void  setSinalEstavel(boolean sinalEstavel) {
        this.sinalEstavel = sinalEstavel;
    }
}

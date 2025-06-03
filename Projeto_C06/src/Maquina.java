public class Maquina {


    private String nome;
    private boolean disponivel = true;
    private SensorTelecom sensor;

    public Maquina(String nome, SensorTelecom sensor) {
        this.nome = nome;
        this.sensor = sensor;
    }

    public void ocupar() { disponivel = false; }
    public void liberar() { disponivel = true; }

    public boolean isDisponivel() {return disponivel;}
    public String getNome() { return nome; }
    public SensorTelecom getSensor() { return sensor; }
}

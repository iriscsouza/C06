import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.StandardOpenOption;


public class OrdemProducao implements Gerenciavel {

    //agregração
    private Produto produto;
    private Maquina maquina;
    private Operador operador;
    private String status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    Path arquivo = Paths.get("Relatório.txt");

    //contrutor, recebe os 3 objetos principais
    public OrdemProducao(Produto produto, Maquina maquina, Operador operador) {

        this.produto = produto;
        this.maquina = maquina;
        this.operador = operador;
        this.status = "Pendente"; //status inicial
    }


     //Inicia a ordem de produção, validando:
      //Se a máquina está disponível (senão lança exceção checada)
     //Se o sinal do sensor está estável (senão lança exceção não checada)
      //Depois disso, ocupa a máquina, registra data/hora, e executa o operador


    public void iniciarProducao() throws MaquinaIndisponivelException {
        if (!maquina.isDisponivel()) {
            throw new MaquinaIndisponivelException("Máquina " + maquina.getNome() + " está ocupada.");
        }

        if (!maquina.getSensor().isSinalEstavel()) {
            throw new SinalInstavelException("Sinal do sensor está instável. Produção não pode iniciar.");
        }

        this.status = "Em produção";
        this.dataInicio = LocalDateTime.now();
        maquina.ocupar();
        operador.executarTarefa();
        maquina.getSensor().enviarSinal();
        System.out.println("Produção iniciada.");
    }

    //libera a máquina e registra a hora final
    public void finalizarProducao() {
        this.status = "Finalizada";
        this.dataFim = LocalDateTime.now();
        maquina.liberar();

        try{
            Files.writeString(arquivo, "Produção finalizada." + System.lineSeparator(), StandardOpenOption.APPEND);

        }
        catch(IOException e){e.printStackTrace();}


        System.out.println("Produção finalizada.");
    }


    //sobreescrevendo gerenciavel, usando polimorfismo
    @Override
    public void gerarRelatorio() {

        try{
            Files.writeString(arquivo, "--- Relatório da Ordem ---" + System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(arquivo, "Produto: " + produto.getNome()+ System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(arquivo, "Operador: " + operador.getNome() + System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(arquivo, "Máquina: " + maquina.getNome() + System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(arquivo, "Sinal estável: " + maquina.getSensor().isSinalEstavel() + System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(arquivo, "Status: " + status + System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(arquivo, "Início: " + dataInicio + System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(arquivo, "Fim: " + dataFim + System.lineSeparator(), StandardOpenOption.APPEND);

        }
        catch(IOException e){e.printStackTrace();}


        System.out.println("--- Relatório da Ordem ---");
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Operador: " + operador.getNome());
        System.out.println("Máquina: " + maquina.getNome());
        System.out.println("Sinal estável: " + maquina.getSensor().isSinalEstavel());
        System.out.println("Status: " + status);
        System.out.println("Início: " + dataInicio);
        System.out.println("Fim: " + dataFim);
    }

    public Produto getProduto() {
        return produto;
    }

    public String getStatus() {
        return status;
    }




}


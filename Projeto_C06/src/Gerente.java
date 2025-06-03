import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;




// herda de Funcionario e implementa a interface Gerenciavel
public class Gerente extends Funcionario implements Gerenciavel {

    private String departamento;

    Path arquivo = Paths.get("Relatório.txt");

    // Lista de ordens que o gerente está supervisionando
    private List<OrdemProducao> ordensGerenciadas = new ArrayList<>();

    public Gerente(String nome, int matricula, String turno, String departamento) {
        super(nome, matricula, turno);
        this.departamento = departamento;
    }

    // Adiciona uma nova ordem à lista
    public void adicionarOrdem(OrdemProducao ordem) {
        ordensGerenciadas.add(ordem);
    }



    // Sobrescreve o método abstrato da classe Funcionario
    @Override
    public void executarTarefa() {

        try{
            Files.writeString(arquivo, "Gerente " + nome + " está supervisionando a produção." + System.lineSeparator(), StandardOpenOption.APPEND);

        }
        catch(IOException e){e.printStackTrace();}

        System.out.println("Gerente " + nome + " está supervisionando a produção.");
    }

    // Sobrescreve o metodo da interface Gerenciavel
    @Override
    public void gerarRelatorio() {

        try{
            Files.writeString(arquivo, "Gerente gerando relatório do setor " + departamento + "..." + System.lineSeparator(), StandardOpenOption.APPEND );
            Files.writeString(arquivo, "Total de ordens gerenciadas: " + ordensGerenciadas.size() + System.lineSeparator(), StandardOpenOption.APPEND ) ;

            for (OrdemProducao ordem : ordensGerenciadas) {
                Files.writeString(arquivo,"- Produto: " + ordem.getProduto().getNome() + " | Status: " + ordem.getStatus() + System.lineSeparator(), StandardOpenOption.APPEND);
            }
        }
        catch(IOException e){e.printStackTrace();}


        System.out.println("Gerente gerando relatório do setor " + departamento + "...");
        System.out.println("Total de ordens gerenciadas: " + ordensGerenciadas.size());
        for (OrdemProducao ordem : ordensGerenciadas) {
            System.out.println("- Produto: " + ordem.getProduto().getNome() + " | Status: " + ordem.getStatus());
        }
    }

    public void enviarComando(Operador op, String mensagem, OrdemProducao ordem) {

        try{
            Files.writeString(arquivo, "[Comando para " + op.getNome() + "]: " + mensagem + System.lineSeparator(), StandardOpenOption.APPEND);

        }
        catch(IOException e){e.printStackTrace();}

        System.out.println("[Comando para " + op.getNome() + "]: " + mensagem);
        try {
            ordem.iniciarProducao();
        } catch (SinalInstavelException e) {
            System.out.println(e.getMessage());
        }
    }
}

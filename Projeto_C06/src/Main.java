import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Placa de circuito", 120, 50.0);
        Produto produto2 = new Produto("Sensor IoT", 90, 30.0);

        SensorTelecom sensor = new SensorTelecom();


        Path arquivo = Paths.get("Sensor.txt");

        try{
            List<String> conteudostring = Files.readAllLines(arquivo);
            conteudostring.forEach((linha) ->{
              String[] split = linha.split(";");
              String tipo = split[0];
              double frequencia = Double.parseDouble(split[1]);
              boolean sinalEstavel = Boolean.parseBoolean(split[2]);

              sensor.setTipo(tipo);
              sensor.setFrequencia(frequencia);
              sensor.setSinalEstavel(sinalEstavel);


            });
        }
        catch(IOException e){
             e.printStackTrace();
        }


        Maquina maquina1 = new Maquina("Máquina A", sensor);
        Maquina maquina2 = new Maquina("Máquina B", sensor);

        Operador operador1 = new Operador("Gabriel", 9740, "Manhã");
        Operador operador2 = new Operador("Henrique", 137, "Tarde");

        Gerente gerente = new Gerente("Iris", 134, "Integral", "Produção");

        OrdemProducao ordem1 = new OrdemProducao(produto1, maquina1, operador1);
        OrdemProducao ordem2 = new OrdemProducao(produto2, maquina2, operador2);

        // adicionando as ordens à lista do gerente

        gerente.adicionarOrdem(ordem1);
        gerente.adicionarOrdem(ordem2);

        try {
            gerente.enviarComando(operador1, "Mensagem teste 1", ordem1);
           // ordem1.iniciarProducao();
        } catch (MaquinaIndisponivelException e) {
            System.out.println("Erro ao iniciar produção 1: " + e.getMessage());
        }

        ordem1.finalizarProducao();

        try {
            gerente.enviarComando(operador2, "Mensagem teste 2", ordem2);
            //ordem2.iniciarProducao();
        } catch (MaquinaIndisponivelException e) {
            System.out.println("Erro ao iniciar produção 2: " + e.getMessage());
        }

        ordem2.finalizarProducao();

        // gerente gera relatório com todas as ordens supervisionadas
        gerente.gerarRelatorio();
    }
}

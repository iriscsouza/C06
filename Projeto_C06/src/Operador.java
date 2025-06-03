import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.StandardOpenOption;

//representa quem executa a produção
//herda de funcionário

public class Operador extends Funcionario {
    public Operador(String nome, int matricula, String turno) {
        super(nome, matricula, turno);
    }

    Path arquivo = Paths.get("Relatório.txt");

    @Override
    public void executarTarefa()

    {
        try{
            Files.writeString(arquivo, "Operador " + nome + " está operando a máquina." + System.lineSeparator(), StandardOpenOption.APPEND);

        }
        catch(IOException e){e.printStackTrace();}

        System.out.println("Operador " + nome + " está operando a máquina.");
    }
}
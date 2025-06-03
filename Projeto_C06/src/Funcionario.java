//classe abstrata serve como base para as outras, não pode ser instanciada,  força as subclasses implentem outros comportamentos



 public abstract class Funcionario {

    //protected permite que as subclasses acessem, mas as outras não
    protected String nome;
    protected int matricula;
    protected String turno;

    public Funcionario(String nome, int matricula, String turno) {
        this.nome = nome;
        this.matricula = matricula;
        this.turno = turno;
    }

    public abstract void executarTarefa();

    public String getNome() { return nome; }
}
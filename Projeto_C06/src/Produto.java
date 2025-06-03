public class Produto {

    //atributos
    //private permite o acesso apenas dentro da propria classe

    private String nome;
    private int tempoProducao; //em minutos
    private double custoEstimado;

    //construtor, define valores iniciais
    public Produto(String nome, int tempoProducao, double custoEstimado) {
        this.nome = nome;
        this.tempoProducao = tempoProducao;
        this.custoEstimado = custoEstimado;
    }

     //getters, usados para acessar o nome, tempo e custo
    public String getNome() { return nome; }
    public int getTempoProducao() { return tempoProducao; }
    public double getCustoEstimado() { return custoEstimado; }
}


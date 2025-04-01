public class Cliente {


     public String nome;
    public long cpf;
    Computador [] computadores = new Computador[3];

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void addComputador(Computador computador){

        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] == null){
                computadores[i] = computador;

                break;
            }
        }
    }

    public float calculaTotalCompra(){

        float total = 0;

      for (int i = 0; i < computadores.length; i++) {
          if (computadores[i] != null)
             total += computadores[i].preco;

      }
    return total;
    }

}

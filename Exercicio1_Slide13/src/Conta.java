import java.util.HashSet;
import java.util.Set;

public class Conta {

    private double saldo;
    private double limite;
    private Set<Cliente> listaClientes;

    public Conta(double saldo, double limite) {
        this.saldo = saldo;
        this.limite = limite;
        this.listaClientes = new HashSet<>();
    }

    public void adicionarCliente(Cliente c) {
        listaClientes.add(c);
    }

    public void mostrarInfo() {
        System.out.println("- Dados da Conta -");
        System.out.println("Saldo: R$" + saldo);
        System.out.println("Limite: R$" + limite);

        System.out.println("- Clientes - ");
        for (Cliente c : listaClientes) {
            try
            {
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
            }
            catch (NullPointerException e) {
                System.out.println("Cliente nulo encontrado.");
            }
        }
    }
}

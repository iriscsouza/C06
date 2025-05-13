public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Iris", 123456789);
        Cliente cliente2 = new Cliente("Flávio", 987654321);
        Cliente clientenulo = null;

        Conta conta = new Conta(2000, 1000);

        conta.adicionarCliente(cliente1);
        conta.adicionarCliente(cliente2);
        conta.adicionarCliente(clientenulo);

        conta.mostrarInfo();

        System.out.println("Programa finalizado com sucesso!");


    }
}

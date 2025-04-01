import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Promoção 1

        Computador c1 = new Computador();
        c1.marca = "Apple ";
        c1.preco = 134;

        MemoriaUSB m1 = new MemoriaUSB();
        m1.nome = "Pen-Drive ";
        m1.capacidade = 16;


        c1.s1.nome = "Linux Ubuntu ";
        c1.s1.tipo = 32;

        HardwareBasico h1 = new HardwareBasico();
        h1.nome = "Pentium Core i3 ";
        h1.capacidade = 2200;

        HardwareBasico h2 = new HardwareBasico();
        h2.nome = "Memória Ram ";
        h2.capacidade = 8;

        HardwareBasico h3 = new HardwareBasico();
        h3.nome = "HD ";
        h3.capacidade = 500;

        //add no vetor
        c1.hardwares[0] = h1;
        c1.hardwares[1] = h2;
        c1.hardwares[2] = h3;




        //Promoção 2

        Computador c2 = new Computador();
        c2.marca = "Samsung ";
        c2.preco = 1368;

        MemoriaUSB m2 = new MemoriaUSB();
        m2.nome = "Pen-Drive ";
        m2.capacidade = 32;


        c2.s1.nome = "Windows 8 ";
        c2.s1.tipo = 64;

        HardwareBasico h4 = new HardwareBasico();
        h4.nome = "Pentium Core i5 ";
        h4.capacidade = 3370;

        HardwareBasico h5 = new HardwareBasico();
        h5.nome = "Memória Ram ";
        h5.capacidade = 16;

        HardwareBasico h6 = new HardwareBasico();
        h6.nome = "HD ";
        h6.capacidade = 1;

        //add no vetor
        c2.hardwares[0] = h4;
        c2.hardwares[1] = h5;
        c2.hardwares[2] = h6;



        //Promoção 3

        Computador c3 = new Computador();
        c3.marca = "Dell ";
        c3.preco = 5812;

        MemoriaUSB m3 = new MemoriaUSB();
        m3.nome = "HD Externo ";
        m3.capacidade = 1;

        c3.s1.nome = "Windows 10 ";
        c3.s1.tipo = 64;

        HardwareBasico h7 = new HardwareBasico();
        h7.nome = "Pentium Core i7 ";
        h7.capacidade = 4500;

        HardwareBasico h8 = new HardwareBasico();
        h8.nome = "Memória Ram ";
        h8.capacidade = 32;

        HardwareBasico h9 = new HardwareBasico();
        h9.nome = "HD ";
        h9.capacidade = 2;

        //add no vetor
        c3.hardwares[0] = h7;
        c3.hardwares[1] = h2;
        c3.hardwares[2] = h9;



        //Cliente

        Cliente cliente = new Cliente("Iris Souza", 123456789);
            int x;
            Scanner sc = new Scanner(System.in);
            int y;


        System.out.println("Bem vindo à PC Mania!");
        System.out.println("Estas são nossas promoções disponíveis: \n");
        System.out.println("Promoção 1:");
        c1.mostraPCConfigs();
        System.out.println("Promoção 2:");
        c2.mostraPCConfigs();
        System.out.println("Promoção 3:");
        c3.mostraPCConfigs();


        do {

            System.out.println("Escolha qual PC você quer comprar \n 1 - PC 1 \n 2 - PC 2 \n 3 - PC 3 \n 0 - Sair");
             x= sc.nextInt();

            if (x == 1){
                System.out.println("Quer adicionar memória USB? 0 - Não 1- Sim");
                y = sc.nextInt();
                if (y==1)
                    c1.addMemoriaUSB(m1);

                cliente.addComputador(c1);
            }

            else if (x == 2){
                System.out.println("Quer adicionar memória USB? 0 - Não 1- Sim");
                y = sc.nextInt();
                if (y==1)
                    c2.addMemoriaUSB(m2);

                cliente.addComputador(c2);
            }
            else if (x == 3){
                System.out.println("Quer adicionar memória USB? 0 - Não 1- Sim");
                y = sc.nextInt();
                if (y==1)
                    c3.addMemoriaUSB(m3);

                cliente.addComputador(c3);
            }

            else if (x == 0){
                System.out.println("Agradecemos pela compra!");
            }


        }while (x != 0);
        System.out.println("Total da compra do cliente " + cliente.nome + " CPF n° " + cliente.cpf + " é de: R$ " +  cliente.calculaTotalCompra() );

        System.out.println("As configurações dos PCs comprados são: ");
        for (int i = 0; i < cliente.computadores.length; i++) {
            if (cliente.computadores[i] != null) {
                cliente.computadores[i].mostraPCConfigs();
            }
        }



    }
}
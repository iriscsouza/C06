public class Computador {

    public  String marca;
    public float preco;
    public  SistemaOperacional s1 = new SistemaOperacional();
    public MemoriaUSB m1;
    public HardwareBasico [] hardwares = new HardwareBasico[3];



    public void mostraPCConfigs(){

        System.out.println("Marca: " + marca);
        System.out.println("Preco: " + preco);
        System.out.println("Sistema Operacional: " + s1.nome  + s1.tipo);
        if (m1 != null)
            System.out.println("Memória USB" + m1.capacidade + m1.nome);
        for (int i = 0; i < hardwares.length; i++) {
            System.out.println("Hardware: " + hardwares[i].nome + " " + hardwares[i].capacidade);
        }
        System.out.println("\n");


    }
    public void addMemoriaUSB (MemoriaUSB musb){

      m1 = musb;


    }

}

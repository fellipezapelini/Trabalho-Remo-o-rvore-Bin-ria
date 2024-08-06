public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.adicionar(10);
        arvoreBinaria.adicionar(8);
        arvoreBinaria.adicionar(5);
        arvoreBinaria.adicionar(9);
        arvoreBinaria.adicionar(7);
        arvoreBinaria.adicionar(18);
        arvoreBinaria.adicionar(13);
        arvoreBinaria.adicionar(20);
        //System.out.println("Pré-ordem: ");
        //arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println("Em ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        //System.out.println("Pós ordem: ");
        //arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
        arvoreBinaria.remover(8);
        System.out.println("Em ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
    }
}
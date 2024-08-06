public class ArvoreBinaria {

    private No raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void adicionar(int valor){
        No novoNo = new No(valor);
        if (raiz == null){
            this.raiz = novoNo;
        }else{
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = true;
            while (atual != null) {
                pai = atual;
                if (novoNo.getValor() < atual.getValor()) {
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if (esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public No getRaiz() {
        return raiz;
    }

    public void emOrdem(No atual){
        if (atual != null){
            emOrdem(atual.getEsq());
            System.out.println(atual.getValor());
            emOrdem(atual.getDir());
        }
    }

    public void preOrdem(No atual){
        if (atual != null){
            System.out.println(atual.getValor());
            preOrdem(atual.getEsq());
            preOrdem(atual.getDir());
        }
    }

    public void posOrdem(No atual){
        if (atual != null){
            posOrdem(atual.getEsq());
            posOrdem(atual.getDir());
            System.out.println(atual.getValor());
        }
    }

    public boolean remover(int valor){
        No atual = this.raiz;
        No paiAtual = null;
        while(atual != null){
            if (atual.getValor() == valor){
                break;
            }else if (valor < atual.getValor()){ //valor procurado é menor que o atual
                paiAtual = atual;
                atual = atual.getEsq();
            }else{
                paiAtual = atual;
                atual = atual.getDir();
            }
        }
        if (atual != null){
            if (atual.getDir() != null){
                No substituto = atual.getDir();
                No paiSubstituto = atual;
                while(substituto.getEsq() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsq();
                }
                substituto.setEsq(atual.getEsq());
                if (paiAtual != null){
                    if (atual.getValor() < paiAtual.getValor()){
                        paiAtual.setEsq(substituto);
                    }else{
                        paiAtual.setDir(substituto);
                    }
                }else{ //se não tem paiAtual, então é a raiz
                    this.raiz = substituto;
                    paiSubstituto.setEsq(null);
                    this.raiz.setDir(paiSubstituto);
                    this.raiz.setEsq(atual.getEsq());
                }
                if (substituto.getValor() < paiSubstituto.getValor()){
                    paiSubstituto.setEsq(null);
                }else{
                    paiSubstituto.setDir(null);
                }
            }else if (atual.getEsq() != null){ //tem filho só à esquerda
                No substituto = atual.getEsq();
                No paiSubstituto = atual;
                while(substituto.getDir() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDir();
                }
                if (paiAtual != null){
                    if (atual.getValor() < paiAtual.getValor()){
                        paiAtual.setEsq(substituto);
                    }else{
                        paiAtual.setDir(substituto);
                    }
                }else{ //se for a raiz
                    this.raiz = substituto;
                }
                if (substituto.getValor() < paiSubstituto.getValor()){
                    paiSubstituto.setEsq(null);
                }else{
                    paiSubstituto.setDir(null);
                }
            }else{ //não tem filho
                if (paiAtual != null){
                    if (atual.getValor() < paiAtual.getValor()){
                        paiAtual.setEsq(null);
                    }else{
                        paiAtual.setDir(null);
                    }
                }else{ //é a raiz
                    this.raiz = null;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}

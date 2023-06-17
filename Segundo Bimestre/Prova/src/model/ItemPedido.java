package model;

import repository.ExibirInterface;

public class ItemPedido implements ExibirInterface {

    public ItemPedido(String peca, String modelo, String tamanho, double valor) {
        id = idBase++;
        this.peca = peca;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    private static long idBase;
    private long id;
    String peca;
    String modelo;
    String tamanho;
    double valor;

    @Override
    public void exibir(boolean completa) {
        if (completa){
            System.out.println("Item do pedido: " + id);
            System.out.println("- Peça: " + peca);
            System.out.println("- Modelo: " + modelo);
            System.out.println("- Tamanho: " + tamanho);
            System.out.println("- Valor: R$" + valor);
        }
        else{
            System.out.printf("- %s, %s, %s, R$%f", peca, modelo, tamanho, valor);

        }
        System.out.println();
    }
}

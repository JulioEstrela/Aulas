package model;

import java.util.List;

/*
TODO A classe Pedido deve permitir que o pedido seja alterado para entregue tornando o atributo entregue para verdadeiro.
*/

public class Pedido extends Orcamento{


    public Pedido(String dataEntrega) {
        this.dataEntrega = dataEntrega;
        entregue = false;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    String dataEntrega;
    public boolean entregue;

    public Pedido() {

    }

    public void entregar() throws Exception{
        if(entregue)
            throw new Exception("O pedido já foi entregue!");

        entregue = true;
    }


    @Override
    public void exibir(boolean completa) {
        String entregueString;
        if(entregue)
            entregueString = "Entregue";
        else
            entregueString = "Não Entregue";

        if (completa){
            System.out.println("Pedido: " + id);
            System.out.println("Itens: ");
            for (ItemPedido item : itens) {
                System.out.printf("- %s, %s, %s, R$%f", item.peca, item.modelo, item.tamanho, item.valor);
            }
            System.out.println("Data de entrega: " + dataEntrega);


            System.out.println("Situação: " + entregueString);
            System.out.println("Valor Total: " + valorTotal);

        }
        else{
            System.out.printf("%d, %s, %s, R$%f", id, dataEntrega, entregueString, valorTotal);
        }
        System.out.println();
    }
}

package model;

import repository.ExibirInterface;

import java.util.ArrayList;
import java.util.List;

//TODO Não esqueça de tratar a exceção e exibir a mensagem na tela.

public class Orcamento implements ExibirInterface {
    public Orcamento() {
        id = idBase++;
    }

    public static long getIdBase() {
        return idBase;
    }

    public long getId() {
        return id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    static long idBase = 0;
    long id;
    List<ItemPedido> itens = new ArrayList<>();
    double valorTotal;

    public void addItem(ItemPedido itemPedido)
    {
        itens.add(itemPedido);
        valorTotal += itemPedido.valor;
    }

    public void removerItem(ItemPedido itemPedido, long idPedido) throws RuntimeException{
        if(!itens.contains(idPedido))
            throw new RuntimeException("O item não foi encontrado!");

        itens.remove(idPedido);
        valorTotal -= itemPedido.valor;
    }

    @Override
    public void exibir(boolean completa) {
        if (completa){
            System.out.println("Orcamento: " + id);
            System.out.println("Itens:");
            for (ItemPedido item : itens) {
                System.out.printf("- %s, %s, %s, R$%f", item.peca, item.modelo, item.tamanho, item.valor);
            }
            System.out.println("Valor Total: R$" + valorTotal);
        }
        else{
            System.out.printf("%d, R$%f", id, valorTotal);
        }
        System.out.println();
    }
}

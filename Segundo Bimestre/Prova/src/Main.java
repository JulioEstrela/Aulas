import model.ItemPedido;
import model.Orcamento;
import model.Pedido;

public class Main {
    public static void main(String[] args) throws Exception {
        ItemPedido itemPedido = new ItemPedido("Bermuda", "Jogador", "G", 30.0);

        itemPedido.exibir(true);
        itemPedido.exibir(false);

        Orcamento orcamento = new Orcamento();

        orcamento.addItem(itemPedido);

        orcamento.exibir(true);
        orcamento.exibir(false);

        ItemPedido itemPedido2 = new ItemPedido("Calça", "Jogger", "M", 50.0);
        orcamento.addItem(itemPedido2);

        orcamento.exibir(true);

        try {
            orcamento.removerItem(itemPedido2, itemPedido2.getId());
            orcamento.exibir(true);
        } catch(RuntimeException exception)
        {
            System.out.println("O item não foi encontrado");
        }

        try {
            orcamento.removerItem(itemPedido2, itemPedido2.getId());
            orcamento.exibir(true);
        }catch (RuntimeException exception)
        {
            System.out.println("O item não foi encontrado");
        }

        Pedido pedido = new Pedido("15/06/2023");
        pedido.addItem(itemPedido);

        pedido.exibir(true);
        pedido.exibir(false);

        pedido.entregar();
        pedido.exibir(false);

        try {
            pedido.entregar();
        }catch (Exception exception)
        {
            System.out.println("O pedido já foi entregue");
        }

        pedido.exibir(false);

    }
}

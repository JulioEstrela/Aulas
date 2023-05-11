public class App 
{
    public static void main(String[] args) {
        Loja loja = new Loja();
        Cliente cliente1 = new Cliente("Joao", "77788899910", "11984745292");
        Pedido pedido1 = new Pedido(cliente1, "cup noodles", 11.25f, "0045721");

        loja.AddCliente(cliente1);
        loja.AddPedido(pedido1);
    }
}

import java.util.List;

public class Loja 
{
    private String nomeDaLoja;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;

    public Loja(){}

    public Loja(String nomeDaLoja)
    {
        this.nomeDaLoja = nomeDaLoja;
    }

    void AddCliente(Cliente cliente)
    {
        clientes.add(cliente);;
    }

    void AddPedido(Pedido pedido)
    {
        pedidos.add(pedido);
    }
    
    //#region Getters
    public String getNomeDaLoja() {
        return nomeDaLoja;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    //#endregion
}

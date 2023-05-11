public class Pedido 
{
    private Cliente cliente;
    private String produto;
    private float valor;
    private String codigo;

    public Pedido(Cliente cliente, String produto, float valor, String codigo)
    {
        this.cliente = cliente;
        this.produto = produto;
        this.valor = valor;
        this.codigo = codigo;
    }

    //#region Getters
    public Cliente getCliente() {
        return cliente;
    }

    public String getProduto() {
        return produto;
    }

    public float getValor() {
        return valor;
    }

    public String getCodigo() {
        return codigo;
    }
    //#endregion

}

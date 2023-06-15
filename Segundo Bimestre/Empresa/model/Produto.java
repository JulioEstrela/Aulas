package model;
import exception.ComercializarException;

public class Produto extends Item{
    public Produto(String nome, Double preco) {
        super(nome, preco);

        this.id = super.id;
    }

    private long id;
    int estoque;


    @Override
    public void comercializa() throws ComercializarException {
  
        if (estoque <= 0)
            throw new ComercializarException("Produto sem estoque");

        estoque--;
    }

    @Override
    public String toString()
    {
        
        return id + " " + nome + " " + estoque;
    }

}

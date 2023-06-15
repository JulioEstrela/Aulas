package model;

import exception.ComercializarException;

public class Servico extends Item{
    public Servico(String nome, Double preco) {
        super(nome, preco);
    }

    boolean disponivel;

    void liberar() throws ComercializarException{
        if(disponivel)
            throw new ComercializarException("Servico ja esta disponivel");
        
        disponivel = true;
    }

    @Override
    public void comercializa() throws ComercializarException{
        if(!disponivel)
            throw new ComercializarException("Servico nao disponivel");
        
        
        disponivel = false;
    }

}

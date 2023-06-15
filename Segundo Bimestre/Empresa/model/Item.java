package model;

import inter.Comercializar;

public abstract class Item implements Comercializar {
    static long idBase;
    long id;
    String nome;
    Double preco;

    public Item(String nome, Double preco) {
        this.id = idBase++;
        this.nome = nome;
        this.preco = preco;
    }

    public static long getIdBase() {
        return idBase;
    }

    public static void setIdBase(long idBase) {
        Item.idBase = idBase;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String toString()
    {
        return null;
    }
}

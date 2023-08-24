import entity.Endereco;
import entity.Pedido;
import entity.Pessoa;
import entity.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //gerenciarPessoa();
        gerenciarPedido();
    }

    public static void gerenciarPessoa(){
        Pessoa p1 = new Pessoa("Julio", "Estrela", "julioestrela@gmail.com", new Endereco("Rua dos Goianazes", "São Paulo"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(p1);
        transaction.commit();

        List<Pessoa> pessoas = session.createQuery("From Pessoa", Pessoa.class).list();
        pessoas.forEach(p -> System.out.println(p));
    }

    public static void gerenciarPedido(){
        Pessoa p1 = new Pessoa("Julio", "Estrela", "julioestrela@gmail.com", new Endereco("Rua dos Goianazes", "São Paulo"));
        Produto produto1 = new Produto("Bermuda", 40.0);
        Produto produto2 = new Produto("Camisa", 75.5);

        Pedido pedido = new Pedido(p1, new ArrayList<>(List.of(produto1, produto2)));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(pedido);

        transaction.commit();

        List<Pedido> pedidos = session.createQuery("From Pedido", Pedido.class).list();
        pedidos.forEach(p -> System.out.println(p));
    }
}

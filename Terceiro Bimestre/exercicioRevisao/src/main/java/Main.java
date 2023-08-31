import entity.Passageiro;
import entity.Piloto;
import entity.Viagem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Piloto piloto = new Piloto("Julio", "1234");
        Passageiro passageiro1 = new Passageiro("Joao", "58398593849");
        Passageiro passageiro2 = new Passageiro("Maria", "82738472837");
        Passageiro passageiro3 = new Passageiro("Jose", "89819381982");
        Passageiro passageiro4 = new Passageiro("Carlos", "994398593849");
        Passageiro passageiro5 = new Passageiro("Roberto", "58398443849");

        Viagem viagem1 = new Viagem("Bahia", 4);

        viagem1.setPiloto(piloto);
        viagem1.setPassageiros(new ArrayList<>(List.of(passageiro1, passageiro2, passageiro3, passageiro4, passageiro5)));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(viagem1);
        transaction.commit();

        List<Viagem> viagens = session.createQuery("from Viagem", Viagem.class).list();

        viagens.forEach(v -> System.out.println(v));

    }
}

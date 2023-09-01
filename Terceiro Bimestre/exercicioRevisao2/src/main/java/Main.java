import entity.Aluno;
import entity.Nota;
import entity.Professor;
import entity.Turma;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Professor professor = new Professor("Igor", "17994829284", "SP4039242", "Igor123");
        Aluno aluno1 = new Aluno("Julio", "SP3088618", "juliosenha123");
        Aluno aluno2 = new Aluno("Caio", "SP4830618", "CaioEmPe");
        Aluno aluno3 = new Aluno("Joao", "SP6059483", "Bito132");

        Turma turma1 = new Turma("213B", 7, professor, new ArrayList<>(List.of(aluno1, aluno2, aluno3)));

        Nota nota1 = new Nota(7.0, turma1);
        Nota nota2 = new Nota(9.0, turma1);
        Nota nota3 = new Nota(10.0, turma1);

        aluno1.addNota(nota2);
        aluno1.addNota(nota3);
        aluno2.addNota(nota2);
        aluno2.addNota(nota1);
        aluno3.addNota(nota1);
        aluno3.addNota(nota3);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(turma1);
        transaction.commit();

        List<Turma> turmas = session.createQuery("from Turma", Turma.class).list();

        turmas.forEach(turma -> System.out.println(turma));

    }
}

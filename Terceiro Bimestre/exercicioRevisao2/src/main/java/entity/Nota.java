package entity;

import jakarta.persistence.*;

@Entity
@Table
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Double nota;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turma_id")
    private Turma turma;

    public Nota(Double nota, Turma turma) {
        this.nota = nota;
        this.turma = turma;
    }

    public Double getNota() {
        return nota;
    }

    public Turma getTurma() {
        return turma;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", nota=" + nota +
                '}';
    }
}

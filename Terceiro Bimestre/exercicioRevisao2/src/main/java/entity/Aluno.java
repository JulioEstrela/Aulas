package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String prontuario;
    @Column
    private String senha;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "aluno_nota", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "nota_id"))
    private List<Nota> notas;
    @Column
    private Double media;

    public Aluno(String nome, String prontuario, String senha) {
        this.nome = nome;
        this.prontuario = prontuario;
        this.senha = senha;
        this.notas = new ArrayList<>();
    }

    public void addNota(Nota nota){
        notas.add(nota);
        calcularMedia();
    }

    private void calcularMedia() {
        Double sum = 0.0;
        for (Nota nota : notas) sum += nota.getNota();
        media = sum/notas.size();
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prontuario='" + prontuario + '\'' +
                ", senha='" + senha + '\'' +
                ", notas=" + notas +
                ", media=" + media +
                '}';
    }
}

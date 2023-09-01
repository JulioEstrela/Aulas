package entity;

import jakarta.persistence.*;

@Entity
@Table
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String prontuario;
    @Column
    private String senha;

    public Professor(String nome, String cpf, String prontuario, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.prontuario = prontuario;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", prontuario='" + prontuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}

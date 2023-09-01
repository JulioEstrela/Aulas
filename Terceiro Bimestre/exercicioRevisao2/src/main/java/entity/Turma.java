package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String codigo;
    @Column
    private Integer horario; //horario de inicio (cada aula dura 1 hora)

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "turma_aluno", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<Aluno> alunos;

    public Turma(String codigo, Integer horario, Professor professor, List<Aluno> alunos) {
        this.codigo = codigo;
        this.horario = horario;
        this.professor = professor;
        this.alunos = alunos;
    }

    public void addAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", horario=" + horario +
                ", professor=" + professor +
                ", alunos=" + alunos +
                '}';
    }
}

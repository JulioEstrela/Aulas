package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String destino;
    @Column
    private Integer vagas;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "viagem_passageiro", joinColumns = @JoinColumn(name = "viagem_id"), inverseJoinColumns = @JoinColumn(name = "passageiro_id"))
    private List<Passageiro> passageiros;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;

    public Viagem(String destino, Integer vagas) {
        this.destino = destino;
        this.vagas = vagas;
        this.passageiros = new ArrayList<>();
    }

    public void addPassageiro(Passageiro passageiro){
        if(this.passageiros.size() < this.vagas){
            this.passageiros.add(passageiro);
        }
        else {
            System.out.println("Limite de vagas Excedido");
        }
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        if(passageiros.size() > vagas) {
            System.out.println("Essa viagem só pode receber " + this.vagas + " vagas");
        }
        else {
            this.passageiros = passageiros;
        }
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + id +
                ", destino='" + destino + '\'' +
                ", vagas=" + vagas +
                ", passageiros=" + passageiros +
                ", piloto=" + piloto +
                '}';
    }
}

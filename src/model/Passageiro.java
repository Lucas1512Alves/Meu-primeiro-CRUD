package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="passageiro")
 public class Passageiro implements Serializable {
    
    @GeneratedValue
    @Id
    @Column(name="Codpassageiro")
    private int Codpassageiro;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="email")
    private String email;
    
    //@Column(name="dtnascimento")
    //private long dtnascimento;
    
    @Column(name="endereco")
    private String endereco;
    
    @Column(name="numerocell")
    private String numerocell;
    
  

    public Passageiro(int Codpassageiro, String nome, String cpf, String email, String endereco, String numerocell /*int dtnascimento*/) {
        this.Codpassageiro          = Codpassageiro;
        this.nome                   = nome;
        this.cpf                    = cpf;
        this.email                  = email;
        //this.dtnascimento           = dtnascimento;
        this.endereco               = endereco;
        this.numerocell             = numerocell;
    }
    
    public Passageiro(){}

    public int getCodpassageiro() {
        return Codpassageiro;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    /*public long getDtnascimento() {
        return dtnascimento;
    }*/

    public String getEndereco() {
        return endereco;
    }

    public String getNumerocell() {
        return numerocell;
    }

    public void setCodpassageiro(int codpassageiro) {
        this.Codpassageiro = codpassageiro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public void setDtnascimento(long dtnascimento) {
        this.dtnascimento = dtnascimento;
    }*/

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumerocell(String numerocell) {
        this.numerocell = numerocell;
    }
}

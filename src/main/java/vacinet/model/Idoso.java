package vacinet.model;

import java.sql.Date;

public class Idoso {
    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String fone;
    private String email;
    private String senha;
    private String genero;
    private boolean acompanhante;

    public Idoso(Integer id, String nome, String cpf, Date dataNascimento, String fone, String email, String senha, String genero, boolean acompanhante) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.fone = fone;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.acompanhante = acompanhante;
    }

    public Idoso(String nome, String cpf, Date dataNascimento, String fone, String email, String senha, String genero, boolean acompanhante) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.fone = fone;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.acompanhante = acompanhante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(boolean acompanhante) {
        this.acompanhante = acompanhante;
    }

    @Override
    public String toString() {
        return "Idoso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", fone='" + fone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", genero='" + genero + '\'' +
                ", acompanhante=" + acompanhante +
                '}';
    }
}

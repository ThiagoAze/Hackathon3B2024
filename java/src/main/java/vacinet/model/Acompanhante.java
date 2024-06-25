package vacinet.model;

public class Acompanhante {
    private Integer id;
    private Integer idIdoso;
    private String nome;
    private String cpf;
    private String fone;
    private String email;
    private String senha;

    public Acompanhante(Integer id, Integer idIdoso, String nome, String cpf, String fone, String email, String senha) {
        this.id = id;
        this.idIdoso = idIdoso;
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.email = email;
        this.senha = senha;
    }

    public Acompanhante(Integer idIdoso, String nome, String cpf, String fone, String email, String senha) {
        this.idIdoso = idIdoso;
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdIdoso() {
        return idIdoso;
    }

    public void setIdIdoso(Integer idIdoso) {
        this.idIdoso = idIdoso;
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

    @Override
    public String toString() {
        return "Acompanhante{" +
                "id=" + id +
                ", idIdoso=" + idIdoso +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", fone='" + fone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}

package vacinet.model;

public class Aviso {
    private Integer id;
    private Integer idIdoso;
    private Boolean isGeral;
    private String nome;
    private String descricao;

    public Aviso(Integer id, Integer idIdoso, Boolean isGeral, String nome, String descricao) {
        this.id = id;
        this.idIdoso = idIdoso;
        this.isGeral = isGeral;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Aviso( Integer idIdoso, Boolean isGeral, String nome, String descricao) {
        this.idIdoso = idIdoso;
        this.isGeral = isGeral;
        this.nome = nome;
        this.descricao = descricao;
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

    public Boolean getisGeral() {
        return isGeral;
    }

    public void setisGeral(Boolean isGeral) {
        this.isGeral = isGeral;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Aviso{" +
                "id=" + id +
                ", idIdoso=" + idIdoso +
                ", isGeral=" + isGeral +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

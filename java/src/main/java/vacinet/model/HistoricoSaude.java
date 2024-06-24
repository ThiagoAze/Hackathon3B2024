package vacinet.model;

public class HistoricoSaude {
    private Integer idIdoso;
    private Integer id;
    private String nome;

    public HistoricoSaude(Integer id, Integer idIdoso, String nome) {
        this.id = id;
        this.idIdoso = idIdoso;
        this.nome = nome;
    }

    public HistoricoSaude(Integer idIdoso, String nome) {
        this.idIdoso = idIdoso;
        this.nome = nome;
    }

    public Integer getIdIdoso() {
        return idIdoso;
    }

    public void setIdIdoso(Integer idIdoso) {
        this.idIdoso = idIdoso;
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

    @Override
    public String toString() {
        return "HistoricoSaude{" +
                "idIdoso=" + idIdoso +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

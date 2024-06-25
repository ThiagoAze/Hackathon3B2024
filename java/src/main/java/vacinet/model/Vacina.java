package vacinet.model;

import java.sql.Date;

public class Vacina {
    private Integer id;
    private String nome;
    private Integer idadeMin;
    private Integer idadeMax;
    private Date dataInicio;
    private Date dataLimite;
    private String doenca;
    private String obs;

    public Vacina(Integer id, String nome, Integer idadeMin, Integer idadeMax, Date dataInicio, Date dataLimite, String doenca, String obs) {
        this.id = id;
        this.nome = nome;
        this.idadeMin = idadeMin;
        this.idadeMax = idadeMax;
        this.dataInicio = dataInicio;
        this.dataLimite = dataLimite;
        this.doenca = doenca;
        this.obs = obs;
    }

    public Vacina(String nome, Integer idadeMin, Integer idadeMax, Date dataInicio, Date dataLimite, String doenca, String obs) {
        this.nome = nome;
        this.idadeMin = idadeMin;
        this.idadeMax = idadeMax;
        this.dataInicio = dataInicio;
        this.dataLimite = dataLimite;
        this.doenca = doenca;
        this.obs = obs;
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

    public Integer getIdadeMin() {
        return idadeMin;
    }

    public void setIdadeMin(Integer idadeMin) {
        this.idadeMin = idadeMin;
    }

    public Integer getIdadeMax() {
        return idadeMax;
    }

    public void setIdadeMax(Integer idadeMax) {
        this.idadeMax = idadeMax;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Vacina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idadeMin=" + idadeMin +
                ", idadeMax=" + idadeMax +
                ", dataInicio=" + dataInicio +
                ", dataLimite=" + dataLimite +
                ", doenca='" + doenca + '\'' +
                ", obs='" + obs + '\'' +
                '}';
    }
}

package vacinet.model;

import java.sql.Date;

public class DiaDisponivel {
    private Integer id;
    private Integer idAgente;
    private Date data;
    private Boolean periodoManha;
    private Boolean periodoTarde;
    private int quantVisita;

    public DiaDisponivel(Integer id, Integer idAgente, Date data, Boolean periodoManha, Boolean periodoTarde, int quantVisita) {
        this.id = id;
        this.idAgente = idAgente;
        this.data = data;
        this.periodoManha = periodoManha;
        this.periodoTarde = periodoTarde;
        this.quantVisita = quantVisita;
    }

    public DiaDisponivel(Integer idAgente, Date data, Boolean periodoManha, Boolean periodoTarde, int quantVisita) {
        this.idAgente = idAgente;
        this.data = data;
        this.periodoManha = periodoManha;
        this.periodoTarde = periodoTarde;
        this.quantVisita = quantVisita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Integer idAgente) {
        this.idAgente = idAgente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getPeriodoManha() {
        return periodoManha;
    }

    public void setPeriodoManha(Boolean periodoManha) {
        this.periodoManha = periodoManha;
    }

    public Boolean getPeriodoTarde() {
        return periodoTarde;
    }

    public void setPeriodoTarde(Boolean periodoTarde) {
        this.periodoTarde = periodoTarde;
    }

    public int getQuantVisita() {
        return quantVisita;
    }

    public void setQuantVisita(int quantVisita) {
        this.quantVisita = quantVisita;
    }
}

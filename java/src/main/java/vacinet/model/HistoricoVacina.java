package vacinet.model;

import java.sql.Date;
import java.sql.Time;

public class HistoricoVacina extends HistoricoSaude{
    private Agente agente;
    private String doenca;
    private Date data;
    private Time hora;

    public HistoricoVacina(Integer id, Integer idIdoso, String nome, Agente agente, String doenca, Date data, Time hora) {
        super(id, idIdoso, nome);
        this.agente = agente;
        this.doenca = doenca;
        this.data = data;
        this.hora = hora;
    }

    public HistoricoVacina(Integer idIdoso, String nome, Agente agente, String doenca, Date data, Time hora) {
        super(idIdoso, nome);
        this.agente = agente;
        this.doenca = doenca;
        this.data = data;
        this.hora = hora;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "HistoricoVacina{" +
                "idAgente=" + agente +
                ", doenca='" + doenca + '\'' +
                ", data=" + data +
                ", hora=" + hora +
                '}';
    }
}

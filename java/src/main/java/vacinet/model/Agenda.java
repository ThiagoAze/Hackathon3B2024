package vacinet.model;

import java.sql.Date;
import java.sql.Time;

public class Agenda {
    private Integer id;
    private Integer idAgente;
    private Integer idIdoso;
    private Date data;
    private Time hora;
    private String rua;
    private String cep;
    private Integer numero;
    private String complemento;
    private String estado;
    private String cidade;
    private Boolean status;
    private Integer idVacina;

    public Agenda(Integer id, Integer idAgente, Integer idIdoso, Date data, Time hora, String rua, String cep, int numero, String complemento, String estado, String cidade, Boolean status, int idVacina) {
        this.id = id;
        this.idAgente = idAgente;
        this.idIdoso = idIdoso;
        this.data = data;
        this.hora = hora;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.cidade = cidade;
        this.status = status;
        this.idVacina = idVacina;

    }

    public Agenda(Integer idAgente, Integer idIdoso, Date data, Time hora, String rua, String cep, int numero, String complemento, String estado, String cidade, Boolean status, int idVacina) {
        this.idAgente = idAgente;
        this.idIdoso = idIdoso;
        this.data = data;
        this.hora = hora;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.cidade = cidade;
        this.status = status;
        this.idVacina = idVacina;
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

    public Integer getIdIdoso() {
        return idIdoso;
    }

    public void setIdIdoso(Integer idIdoso) {
        this.idIdoso = idIdoso;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Integer idVacina) {
        this.idVacina = idVacina;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", idAgente=" + idAgente +
                ", idIdoso=" + idIdoso +
                ", data=" + data +
                ", hora=" + hora +
                ", rua='" + rua + '\'' +
                ", cep='" + cep + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", status='" + status + '\'' +
                ", idVacina=" + idVacina +
                '}';
    }
}

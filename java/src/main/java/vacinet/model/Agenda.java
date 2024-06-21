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
    private int numero;
    private String complemento;
    private String estado;
    private String cidade;

    public Agenda(Integer id, Integer idAgente, Integer idIdoso, Date data, Time hora, String rua, String cep, int numero, String complemento, String estado, String cidade) {
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
    }

    public Agenda(Integer idAgente, Integer idIdoso, Date data, Time hora, String rua, String cep, int numero, String complemento, String estado, String cidade) {
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

    public void setNumero(int numero) {
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
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}

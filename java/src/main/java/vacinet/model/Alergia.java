package vacinet.model;

public class Alergia extends HistoricoSaude{
    private String obs;

    public Alergia(Integer id, Integer idIdoso, String nome, String obs) {
        super(id, idIdoso, nome);
        this.obs = obs;
    }

    public Alergia(Integer idIdoso, String nome, String obs) {
        super(idIdoso, nome);
        this.obs = obs;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Alergia{" +
                "obs='" + obs + '\'' +
                '}';
    }
}

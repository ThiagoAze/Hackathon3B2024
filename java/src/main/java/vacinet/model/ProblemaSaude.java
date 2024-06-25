package vacinet.model;

public class ProblemaSaude extends HistoricoSaude{
    private String obs;

    public ProblemaSaude(Integer id, Integer idIdoso, String nome, String obs) {
        super(id, idIdoso, nome);
        this.obs = obs;
    }

    public ProblemaSaude(Integer idIdoso, String nome, String obs) {
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
        return "ProblemaSaude{" +
                "obs='" + obs + '\'' +
                '}';
    }
}

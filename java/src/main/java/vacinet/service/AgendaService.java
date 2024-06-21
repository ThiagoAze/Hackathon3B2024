package vacinet.service;

import vacinet.dao.AgenteDao;
import vacinet.model.Agente;

public class AgendaService {
    public void salvar(Agente agente) {
        try {
            var dao = new AgenteDao();
            if (agente.getId() == null) {
                dao.inserir(agente);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

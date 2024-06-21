package vacinet.service;

import vacinet.dao.AgenteDao;
import vacinet.dao.IdosoDao;
import vacinet.model.Agente;
import vacinet.model.Idoso;

public class IdosoService {
    public void salvar(Idoso idoso) {
        try {
            var dao = new IdosoDao();
            if (idoso.getId() == null) {
                dao.inserir(idoso);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

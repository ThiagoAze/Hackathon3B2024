package vacinet.service;

import vacinet.dao.AcompanhanteDao;
import vacinet.dao.IdosoDao;
import vacinet.model.Acompanhante;
import vacinet.model.Idoso;

public class AcompanhanteService {
    public void salvar(Acompanhante acompanhante) {
        try {
            var dao = new AcompanhanteDao();
            if (acompanhante.getId() == null) {
                dao.inserir(acompanhante);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

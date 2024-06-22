package vacinet.service;

import vacinet.dao.AgenteDao;
import vacinet.dao.DiaDisponivelDao;
import vacinet.dao.IdosoDao;
import vacinet.model.Agente;
import vacinet.model.DiaDisponivel;
import vacinet.model.Idoso;

import java.util.Collections;
import java.util.List;

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
    public List<Idoso> listarIdoso(Integer id) {
        try {
            var dao = new IdosoDao();
            return dao.listarPorId(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

}

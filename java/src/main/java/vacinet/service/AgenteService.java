package vacinet.service;

import vacinet.dao.AgendaDao;
import vacinet.dao.AgenteDao;
import vacinet.model.Agente;

import java.util.Collections;
import java.util.List;

public class AgenteService {
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

    public List<Agente> listaId(int id) {
        try {
            var dao = new AgenteDao();
            return dao.listarId(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
    /*
    public Boolean confirmarLogin() {
        try {
            var dao = new AgenteDao();
            return dao.confirmarLogin();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
    */
}


package vacinet.service;

import vacinet.dao.AvisoDao;
import vacinet.dao.DiaDisponivelDao;
import vacinet.model.Agente;
import vacinet.model.Aviso;
import vacinet.model.DiaDisponivel;
import vacinet.model.Idoso;

import java.util.Collections;
import java.util.List;

public class AvisoService {
    public void salvar(Aviso aviso) {
        try {
            var dao = new AvisoDao();
            if (aviso.getId() == null) {
                dao.inserir(aviso);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Aviso> listarTodos() {
        try {
            var dao = new AvisoDao();
            return dao.listarGeral();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
    public List<Aviso> listarIdIdoso(Integer idIdoso) {
        try {
            var dao = new AvisoDao();
            return dao.listarIdIdoso(idIdoso);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}

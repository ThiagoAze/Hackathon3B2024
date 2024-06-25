package vacinet.service;

import vacinet.dao.AlergiaDao;
import vacinet.dao.DiaDisponivelDao;
import vacinet.model.Agente;
import vacinet.model.Alergia;
import vacinet.model.DiaDisponivel;
import vacinet.model.Idoso;

import java.util.Collections;
import java.util.List;

public class AlergiaService {
    public void salvar(Alergia alergia) {
        try {
            var dao = new AlergiaDao();
            if (alergia.getId() == null) {
                dao.inserir(alergia);
            }else {
                dao.atualizar(alergia);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletar(Alergia alergia) {
        try {
            var dao = new AlergiaDao();
            if (alergia.getId() != null) {
                dao.deletar(alergia.getId());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<Alergia> listarTodos(Integer idIdoso) {
        try {
            var dao = new AlergiaDao();
            return dao.listarIdIdoso(idIdoso);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}

package vacinet.service;

import vacinet.dao.DiaDisponivelDao;
import vacinet.model.Agente;
import vacinet.model.DiaDisponivel;

import java.util.Collections;
import java.util.List;

public class DiaDisponivelService {

    public void salvar(DiaDisponivel diaDisponivel) {
        try {
            var dao = new DiaDisponivelDao();
            if (diaDisponivel.getId() == null) {
                dao.inserir(diaDisponivel);
            }else {
                dao.atualizar(diaDisponivel);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletar(DiaDisponivel diaDisponivel) {
        try {
            var dao = new DiaDisponivelDao();
            if (diaDisponivel.getId() != null) {
                dao.deletar(diaDisponivel.getId());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<DiaDisponivel> listarDia(Agente agente) {
        try {
            var dao = new DiaDisponivelDao();
            return dao.listarPorIdAgente(agente);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}

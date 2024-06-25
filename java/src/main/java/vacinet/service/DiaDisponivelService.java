package vacinet.service;

import vacinet.dao.DiaDisponivelDao;
import vacinet.model.Agente;
import vacinet.model.DiaDisponivel;

import java.sql.Date;
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
    public List<DiaDisponivel> listarTodos(Agente agente) {
        try {
            var dao = new DiaDisponivelDao();
            return dao.listarIdAgente(agente.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<DiaDisponivel> listarId(int id) {
        try {
            var dao = new DiaDisponivelDao();
            return dao.listarId(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<DiaDisponivel> listarPeriodoManhaDia(Date data) {
        try {
            var dao = new DiaDisponivelDao();
            return dao.listarPeriodoManhaDia(data);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<DiaDisponivel> listarPeriodoTardeDia(Date data) {
        try {
            var dao = new DiaDisponivelDao();
            return dao.listarPeriodoTardeDia(data);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}

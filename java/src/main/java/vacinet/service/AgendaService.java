package vacinet.service;

import vacinet.dao.AgendaDao;
import vacinet.model.Agenda;
import vacinet.model.Agente;
import vacinet.model.Idoso;

import java.util.Collections;
import java.util.List;

public class AgendaService {
    public void salvar(Agenda agenda) {
        try {
            var dao = new AgendaDao();
            if (agenda.getId() != null) {
                dao.atualizar(agenda);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletar(Agenda agenda) {
        try {
            var dao = new AgendaDao();
            if (agenda.getId() != null) {
                dao.deletar(agenda.getId());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorIdoso(Agente agente, Idoso idoso) {
        try {
            var dao = new AgendaDao();
            dao.listarTodosPorIdoso(agente.getId(), idoso.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Agenda listarPorId(Integer id) {
        try {
            var dao = new AgendaDao();
            return dao.listarTodosPorId(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Agenda> listarTudo(Integer idAgente) {
        try {
            var dao = new AgendaDao();
            return dao.listarTodos(idAgente);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}

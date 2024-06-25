package vacinet.service;

import vacinet.dao.AgendaDao;
import vacinet.model.Agenda;
import vacinet.model.Agente;
import vacinet.model.Idoso;

import java.util.Collections;
import java.sql.Date;
import java.util.List;

public class AgendaService {
    public void salvar(Agenda agenda) {
        try {
            var dao = new AgendaDao();
            if (agenda.getId() != null) {
                dao.atualizar(agenda);
            } else {
                dao.inserir(agenda);
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
    public List<Agenda> listarAgenteIdoso(Agente agente, Idoso idoso) {
        try {
            var dao = new AgendaDao();
            return  dao.listarTodosAgenteIdoso(agente.getId(), idoso.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Agenda> listarAgenteData(Agente agente, Date data) {
        try {
            var dao = new AgendaDao();
            return dao.listarTodosAgenteData(agente.getId(), data);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Agenda> listarIdoso(Idoso idoso) {
        try {
            var dao = new AgendaDao();
            return dao.listarTodosIdoso(idoso.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public Agenda listarEndereco(Idoso idoso) {
        try {
            var dao = new AgendaDao();
            return dao.listarEndereco(idoso.getId()).get(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Agenda> listarProximaVacina(Integer idIdoso, Date dataHoje) {
        try {
            var dao = new AgendaDao();
            return dao.listarProximaVacina(idIdoso, dataHoje);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Agenda> listarUltimaVacina(Integer idIdoso, Date dataHoje) {
        try {
            var dao = new AgendaDao();
            return dao.listarUltimaVacina(idIdoso, dataHoje);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Agenda> listarId(Integer id) {
        try {
            var dao = new AgendaDao();
            return dao.listarTodosId(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
    public List<Agenda> listarAgente(Integer idAgente) {
        try {
            var dao = new AgendaDao();
            return dao.listarTodosAgente(idAgente);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}

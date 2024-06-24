package vacinet.service;

import vacinet.dao.DiaDisponivelDao;
import vacinet.dao.ProblemaSaudeDao;
import vacinet.model.Agente;
import vacinet.model.DiaDisponivel;
import vacinet.model.Idoso;
import vacinet.model.ProblemaSaude;

import java.util.Collections;
import java.util.List;

public class ProblemaSaudeService {
    public void salvar(ProblemaSaude ProblemaSaude) {
        try {
            var dao = new ProblemaSaudeDao();
            if (ProblemaSaude.getId() == null) {
                dao.inserir(ProblemaSaude);
            }else {
                dao.atualizar(ProblemaSaude);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deletar(ProblemaSaude problemaSaude) {
        try {
            var dao = new ProblemaSaudeDao();
            if (problemaSaude.getId() != null) {
                dao.deletar(problemaSaude.getId());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<ProblemaSaude> listarTodos(Integer idIdoso) {
        try {
            var dao = new ProblemaSaudeDao();
            return dao.listarIdoso(idIdoso);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}

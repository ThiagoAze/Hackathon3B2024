package vacinet.service;

import vacinet.dao.AlergiaDao;
import vacinet.dao.VacinaDao;
import vacinet.model.Alergia;
import vacinet.model.Idoso;
import vacinet.model.Vacina;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

public class VacinaService {
    public void salvar(Vacina vacina) {
        try {
            var dao = new VacinaDao();
            if (vacina.getId() == null) {
                dao.inserir(vacina);
            }else {
                dao.atualizar(vacina);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletar(Vacina vacina) {
        try {
            var dao = new VacinaDao();
            if (vacina.getId() != null) {
                dao.deletar(vacina.getId());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Vacina> listarDia(Date dia) {
        try {
            var dao = new VacinaDao();
            return dao.listarDia(dia);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Vacina> listarId(int id) {
        try {
            var dao = new VacinaDao();
            return dao.listarId(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Vacina> listarIdade(int idade) {
        try {
            var dao = new VacinaDao();
            return dao.listarIdade(idade);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}

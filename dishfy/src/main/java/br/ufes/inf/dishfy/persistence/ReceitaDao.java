import java.util.List;
import javax.persistence.EntityManager;

public interface ReceitaDao {
    
    Receita saveReceita(Receita receita);
    Receita updateReceita(Receita receita);
    Receita insertOrUpdate(Receita receita);
    Receita getReceita(Receita receita);
    List<Receita> getAllReceita();


    
}
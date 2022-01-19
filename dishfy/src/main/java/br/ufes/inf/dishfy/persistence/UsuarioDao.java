import java.util.List;
import javax.persistence.EntityManager;


public interface UsuarioDao {

    Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    Usuario insertOrUpdate(Usuario usuario);

    

    void deleteUsuario(Usuario usuario);

    Usuario getUsuario(Usuario usuario);

    List<Usuario> getAllUsuario();



}

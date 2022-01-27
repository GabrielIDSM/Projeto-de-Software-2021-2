package Repository;

import DAO.UserDAO;
import DTO.UserDTO;
import Util.PasswordUtil;
import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class UserRepository extends Repository<UserDTO> {
    @Override
    protected UserDTO get(Integer Id) {
        UserDAO objectDAO = new UserDAO();
        UserDTO objectDTO = objectDAO.read(Id);
        return objectDTO;
    }

    @Override
    protected Boolean add(UserDTO object) {
        UserDAO objectDAO = new UserDAO();
        return objectDAO.create(object);
    }

    @Override
    protected Boolean update(UserDTO object) {
        UserDAO objectDAO = new UserDAO();
        return objectDAO.update(object);
    }

    @Override
    protected Boolean remove(UserDTO object) {
        UserDAO objectDAO = new UserDAO();
        return objectDAO.delete(object.getId());
    }
    
    public Boolean createUser(UserDTO object){
        PasswordUtil passwordAuthentication = new PasswordUtil();
        object.setPassword(passwordAuthentication.hash(object.getPassword().toCharArray()));
        return add(object);
    }
    
    public List<UserDTO> all() {
        UserDAO objectDAO = new UserDAO();
        List<UserDTO> list = objectDAO.all();
        return list;
    }
    
}
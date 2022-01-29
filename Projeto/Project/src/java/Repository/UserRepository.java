package Repository;

import DAO.UserDAO;
import DTO.UserDTO;
import Model.RoleModel;
import Model.UserModel;
import Util.PasswordUtil;
import java.util.ArrayList;
import java.util.Iterator;
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
    
    public List<UserModel> allModel() {
        UserDAO objectDAO = new UserDAO();
        List<UserDTO> users = objectDAO.all();
        List<UserModel> list = new ArrayList<>();
        users.stream().map((user) -> {
            UserModel userModel = new UserModel();
            RoleModel roleModel = new RoleModel();
            roleModel.setId(user.getRole().getId());
            roleModel.setName(user.getRole().getName());
            userModel.setId(user.getId());
            userModel.setUsername(user.getUsername());
            userModel.setRole(roleModel);
            return userModel;
        }).forEachOrdered((userModel) -> {
            list.add(userModel);
        });
        return list;
    }
    
    public UserModel login(String username, String password) {
        PasswordUtil passwordAuthentication = new PasswordUtil();
        List<UserDTO> users = all();
        for (UserDTO user : users) { 
            if (user.getUsername().equals(username) &&
                    passwordAuthentication.authenticate(password.toCharArray(), user.getPassword())) {
                UserModel userModel = new UserModel();
                RoleModel roleModel = new RoleModel();
                roleModel.setId(user.getRole().getId());
                roleModel.setName(user.getRole().getName());
                userModel.setId(user.getId());
                userModel.setUsername(user.getUsername());
                userModel.setRole(roleModel);
                return userModel;
            }
        }
        return null;
    }
}
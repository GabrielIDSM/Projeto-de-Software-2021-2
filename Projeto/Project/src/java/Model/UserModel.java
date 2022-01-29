package Model;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class UserModel {
    private Integer Id;
    private String Username;
    private RoleModel Role;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public RoleModel getRole() {
        return Role;
    }

    public void setRole(RoleModel Role) {
        this.Role = Role;
    }
    
}
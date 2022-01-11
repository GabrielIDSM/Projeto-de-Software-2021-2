package Repository;

import DAO.ServiceDAO;
import DTO.ServiceDTO;
import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ServiceRepository extends Repository<ServiceDTO> {
    @Override
    protected ServiceDTO get(Integer Id) {
        ServiceDAO objectDAO = new ServiceDAO();
        ServiceDTO objectDTO = objectDAO.read(Id);
        return objectDTO;
    }

    @Override
    protected Boolean add(ServiceDTO object) {
        ServiceDAO objectDAO = new ServiceDAO();
        return objectDAO.create(object);
    }

    @Override
    protected Boolean update(ServiceDTO object) {
        ServiceDAO objectDAO = new ServiceDAO();
        return objectDAO.update(object);
    }

    @Override
    protected Boolean remove(ServiceDTO object) {
        ServiceDAO objectDAO = new ServiceDAO();
        return objectDAO.delete(object.getId());
    }
    
    public List<ServiceDTO> all() {
        ServiceDAO objectDAO = new ServiceDAO();
        List<ServiceDTO> list = objectDAO.all();
        return list;
    }
    
    public Boolean addService(ServiceDTO object) {
        return add(object); 
    }
}
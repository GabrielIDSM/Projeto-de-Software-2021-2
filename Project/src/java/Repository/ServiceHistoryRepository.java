package Repository;

import DAO.ServiceHistoryDAO;
import DTO.ServiceHistoryDTO;
import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ServiceHistoryRepository extends Repository<ServiceHistoryDTO> {
    @Override
    protected ServiceHistoryDTO get(Integer Id) {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        ServiceHistoryDTO objectDTO = objectDAO.read(Id);
        return objectDTO;
    }

    @Override
    protected Boolean add(ServiceHistoryDTO object) {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        return objectDAO.create(object);
    }

    @Override
    protected Boolean update(ServiceHistoryDTO object) {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        return objectDAO.update(object);
    }

    @Override
    protected Boolean remove(ServiceHistoryDTO object) {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        return objectDAO.delete(object.getId());
    }
    
    public List<ServiceHistoryDTO> all() {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        List<ServiceHistoryDTO> list = objectDAO.all();
        return list;
    }
    
    public Boolean removeServiceHistory(ServiceHistoryDTO object) {
        return remove(object);
    }
}
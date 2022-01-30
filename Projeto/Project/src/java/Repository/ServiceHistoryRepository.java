package Repository;

import DAO.ServiceHistoryDAO;
import DTO.ServiceDTO;
import DTO.ServiceHistoryDTO;
import Model.ServiceHistoryModel;
import Model.ServiceModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    
    public List<ServiceHistoryModel> all(Integer serviceModelId) {
        List<ServiceHistoryModel> list = new ArrayList<>();
        List<ServiceHistoryDTO>objectList = all();
        objectList.stream().filter((serviceHistoryDTO) -> (serviceHistoryDTO.getService().getId().compareTo(serviceModelId) == 0)).map((serviceHistoryDTO) -> {
            ServiceHistoryModel serviceHistoryModel = new ServiceHistoryModel();
            serviceHistoryModel.setId(serviceHistoryDTO.getId());
            serviceHistoryModel.setComplaints(serviceHistoryDTO.getComplaints());
            serviceHistoryModel.setCollectionTimestamp(serviceHistoryDTO.getCollectionTimestamp());
            return serviceHistoryModel;
        }).forEachOrdered((serviceHistoryModel) -> {
            list.add(serviceHistoryModel);
        });
        list.sort((object1, object2) -> {
            return object1.getCollectionTimestamp().compareTo(object2.getCollectionTimestamp());
        });
        return list;
    }
    
    public Boolean removeAllServiceHistoryByService(ServiceDTO object) {
        Boolean opStatus = true; 
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        List<ServiceHistoryDTO> list = objectDAO.all();
        for (ServiceHistoryDTO serviceHistoryDTO: list) {
            if (Objects.equals(object.getId(), serviceHistoryDTO.getService().getId()))
                opStatus = opStatus && remove(serviceHistoryDTO);
        }
        return opStatus;
    }
    
    public Boolean addServiceHistory(ServiceHistoryDTO object) {
        return add(object);
    }

    public Boolean removeServiceHistory(ServiceHistoryDTO object) {
        return remove(object);
    }
}
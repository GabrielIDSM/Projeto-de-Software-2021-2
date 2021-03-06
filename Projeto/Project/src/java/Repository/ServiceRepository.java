package Repository;

import DAO.ServiceDAO;
import DTO.ImageDTO;
import DTO.ServiceDTO;
import Model.ServiceModel;
import java.util.ArrayList;
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
    
    protected Boolean remove(Integer id) {
        ServiceDAO objectDAO = new ServiceDAO();
        return objectDAO.delete(id);
    }
    
    public List<ServiceDTO> all() {
        ServiceDAO objectDAO = new ServiceDAO();
        List<ServiceDTO> list = objectDAO.all();
        return list;
    }
    
    public List<ServiceModel> allModel() {
        List<ServiceDTO> objectList = all();
        ServiceHistoryRepository serviceHistoryRepository = new ServiceHistoryRepository();
        List<ServiceModel> list = new ArrayList<>();
        objectList.stream().map((serviceDTO) -> {
            ServiceModel serviceModel = new ServiceModel();
            serviceModel.setId(serviceDTO.getId());
            serviceModel.setName(serviceDTO.getName());
            serviceModel.setQuery(serviceDTO.getName());
            serviceModel.setImageFileName(serviceDTO.getImage().getFileName());
            serviceModel.setHistoryList(serviceHistoryRepository.all(serviceDTO.getId()));
            return serviceModel;
        }).forEachOrdered((serviceModel) -> {
            list.add(serviceModel);
        });
        list.sort((object1, object2) -> {
            return object1.getName().compareTo(object2.getName());
        });
        return list;
    }
    
    public Boolean addService(ServiceDTO object) {
        return add(object); 
    }
    
    public Boolean addService(ServiceModel object) {
        Boolean opStatus;
        ImageRepository imageRepository = new ImageRepository();
        ServiceDTO serviceDTO = new ServiceDTO();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setFileName(object.getImageFileName());
        serviceDTO.setName(object.getName());
        serviceDTO.setQuery(object.getQuery());
        serviceDTO.setImage(imageDTO);
        opStatus = imageRepository.addImage(imageDTO);
        if (opStatus)
            opStatus = add(serviceDTO);
        return opStatus;
    }
    
    public Boolean updateService(ServiceModel object) {
        ServiceDTO serviceDTO = get(object.getId());
        serviceDTO.setId(object.getId());
        serviceDTO.setName(object.getName());
        serviceDTO.setQuery(object.getQuery());
        serviceDTO.getImage().setFileName(object.getImageFileName());
        return update(serviceDTO);
    }
    
    public ServiceModel getModel(Integer id) {
        ServiceHistoryRepository serviceHistoryRepository = new ServiceHistoryRepository();
        ServiceDTO serviceDTO = get(id);
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setId(serviceDTO.getId());
        serviceModel.setName(serviceDTO.getName());
        serviceModel.setQuery(serviceDTO.getQuery());
        serviceModel.setImageFileName(serviceDTO.getImage().getFileName());
        serviceModel.setHistoryList(serviceHistoryRepository.all(serviceDTO.getId()));
        return serviceModel;
    }
    
    public Boolean deleteModel(Integer id) {
        Boolean opStatus;
        ImageRepository imageRepository = new ImageRepository();
        ServiceHistoryRepository serviceHistoryRepository = new ServiceHistoryRepository();
        ServiceDTO serviceDTO = get(id);
        opStatus = serviceHistoryRepository.removeAllServiceHistoryByService(serviceDTO);
        if (opStatus)
            opStatus = remove(id);
        if (opStatus)
            opStatus = imageRepository.removeImage(serviceDTO.getImage());
        return opStatus;
    }
}
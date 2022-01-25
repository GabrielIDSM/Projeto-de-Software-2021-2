package Repository;

import DAO.ImageDAO;
import DTO.ImageDTO;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ImageRepository extends Repository<ImageDTO> {
    @Override
    protected ImageDTO get(Integer Id) {
        ImageDAO objectDAO = new ImageDAO();
        ImageDTO objectDTO = objectDAO.read(Id);
        return objectDTO;
    }

    @Override
    protected Boolean add(ImageDTO object) {
        ImageDAO objectDAO = new ImageDAO();
        return objectDAO.create(object);
    }

    @Override
    protected Boolean update(ImageDTO object) {
        ImageDAO objectDAO = new ImageDAO();
        return objectDAO.update(object);
    }

    @Override
    protected Boolean remove(ImageDTO object) {
        ImageDAO objectDAO = new ImageDAO();
        return objectDAO.delete(object.getId());
    }
    
    public Boolean addImage(ImageDTO object) {
        return add(object);
    }
}
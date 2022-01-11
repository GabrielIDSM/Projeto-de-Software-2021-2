package Service;

import DTO.ServiceDTO;
import DTO.ServiceHistoryDTO;
import Repository.ServiceHistoryRepository;
import Repository.ServiceRepository;
import Util.TwitterUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class AddServiceData implements Runnable {
    @Override
    public void run() {
        TwitterUtil twitterUtil = new TwitterUtil();
        ServiceRepository serviceRepository = new ServiceRepository();
        ServiceHistoryRepository serviceHistoryRepository = new ServiceHistoryRepository();
        List<ServiceDTO> serviceList = serviceRepository.all();
        serviceList.forEach((serviceDTO) -> {
            ServiceHistoryDTO serviceHistoryDTO = new ServiceHistoryDTO();
            serviceHistoryDTO.setService(serviceDTO);
            serviceHistoryDTO.setCollectionTimestamp(new Date());
            try {
                serviceHistoryDTO.setComplaints(twitterUtil.getComplaintCount(serviceDTO.getQuery()));
                serviceHistoryRepository.addServiceHistory(serviceHistoryDTO);
            } catch (URISyntaxException | IOException | ParseException e) {
                System.err.println(e.getMessage());
            }
        });
    }
}
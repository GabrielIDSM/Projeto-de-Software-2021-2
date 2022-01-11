package Task;

import DTO.ServiceDTO;
import DTO.ServiceHistoryDTO;
import Repository.ServiceRepository;
import Util.TwitterUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        List<ServiceDTO> serviceList = serviceRepository.all();
        serviceList.forEach((serviceDTO) -> {
            ServiceHistoryDTO serviceHistoryDTO = new ServiceHistoryDTO();
            serviceHistoryDTO.setService(serviceDTO);
            serviceHistoryDTO.setCalendarDate(Calendar.getInstance());
            try {
                serviceHistoryDTO.setComplaints(twitterUtil.getComplaintCount(serviceDTO.getQuery()));
            } catch (URISyntaxException | IOException | ParseException e) {
                System.err.println(e.getMessage());
            }
        });
    }
}
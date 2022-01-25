package Service;

import DTO.ServiceHistoryDTO;
import Repository.ServiceHistoryRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class RemoveServiceData implements Runnable {
    @Override
    public void run() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date); 
        calendar.add(Calendar.MONTH, -3);
        ServiceHistoryRepository serviceHistoryRepository = new ServiceHistoryRepository();
        List<ServiceHistoryDTO> serviceHistoryList = serviceHistoryRepository.all();
        serviceHistoryList.forEach((serviceHistoryDTO) -> {
            if (calendar.getTime().after(serviceHistoryDTO.getCollectionTimestamp()))
                serviceHistoryRepository.removeServiceHistory(serviceHistoryDTO);
        });
    }
}

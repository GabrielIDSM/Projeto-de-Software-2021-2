package Task;

import DTO.ServiceHistoryDTO;
import Repository.ServiceHistoryRepository;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class RemoveServiceData implements Runnable {
    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        ServiceHistoryRepository serviceHistoryRepository = new ServiceHistoryRepository();
        List<ServiceHistoryDTO> serviceHistoryList = serviceHistoryRepository.all();
        serviceHistoryList.forEach((serviceHistoryDTO) -> {
            if (calendar.compareTo(serviceHistoryDTO.getCalendarDate()) >= 0)
                serviceHistoryRepository.removeServiceHistory(serviceHistoryDTO);
        });
    }
}

package Controller;

import Task.AddServiceData;
import Task.RemoveServiceData;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class Startup implements ServletContextListener {
    private ScheduledExecutorService executorAddServiceData;
    private ScheduledExecutorService executorRemoveServiceData;
    private AddServiceData addServiceData;
    private RemoveServiceData removeServiceData;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        addServiceData = new AddServiceData();
        removeServiceData = new RemoveServiceData();

        executorAddServiceData = Executors.newSingleThreadScheduledExecutor();
        executorAddServiceData.scheduleAtFixedRate(addServiceData, 0, 30, TimeUnit.MINUTES);
        sce.getServletContext().setAttribute("addServiceData", addServiceData);
        
        executorRemoveServiceData = Executors.newSingleThreadScheduledExecutor();
        executorRemoveServiceData.scheduleAtFixedRate(removeServiceData, 0, 24, TimeUnit.HOURS);
        sce.getServletContext().setAttribute("removeServiceData", removeServiceData);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        executorAddServiceData.shutdown();
        executorRemoveServiceData.shutdown();
    }
}
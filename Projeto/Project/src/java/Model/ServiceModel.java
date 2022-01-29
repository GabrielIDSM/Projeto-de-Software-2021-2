package Model;

import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ServiceModel {
    public static final Integer DANGER_THRESHOLD = 50;
    public static final Integer WARNING_THRESHOLD = 30;
    public static final Integer NORMAL_THRESHOLD = 15;

    private Integer Id;
    private String Name;
    private String Query;
    private String imageFileName;
    private List<ServiceHistoryModel> historyList;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String Query) {
        this.Query = Query;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public List<ServiceHistoryModel> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<ServiceHistoryModel> historyList) {
        this.historyList = historyList;
    }
    
}
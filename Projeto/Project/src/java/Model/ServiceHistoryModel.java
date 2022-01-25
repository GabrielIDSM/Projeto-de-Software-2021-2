package Model;

import java.util.Date;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ServiceHistoryModel {
    private Integer Id;
    private java.util.Date CollectionTimestamp;
    private Integer Complaints;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Date getCollectionTimestamp() {
        return CollectionTimestamp;
    }

    public void setCollectionTimestamp(Date CollectionTimestamp) {
        this.CollectionTimestamp = CollectionTimestamp;
    }

    public Integer getComplaints() {
        return Complaints;
    }

    public void setComplaints(Integer Complaints) {
        this.Complaints = Complaints;
    }
    
}
package DTO;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
@Entity
@Table(name = "service_history_conf")
public class ServiceHistoryDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    
    @ManyToOne
    private ServiceDTO Service;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "calendar_date")
    private java.util.Calendar CalendarDate;
    
    @Column(name = "complaints")
    private Integer Complaints;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public ServiceDTO getService() {
        return Service;
    }

    public void setService(ServiceDTO Service) {
        this.Service = Service;
    }

    public Calendar getCalendarDate() {
        return CalendarDate;
    }

    public void setCalendarDate(Calendar CalendarDate) {
        this.CalendarDate = CalendarDate;
    }

    public Integer getComplaints() {
        return Complaints;
    }

    public void setComplaints(Integer Complaints) {
        this.Complaints = Complaints;
    }
    
}
package nl.novi.fsdbe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends Person {

    @Column
    private String dateOfBirth;

    @Column
    private String photo;

    @Column
    private boolean seeOwnMedication;

    @Column
    private String roomNumber;

    @Column
    private String telPharmacy;

    @Column
    private String telGeneralPractitioner;

    @OneToMany(
            mappedBy = "client",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("client")
    private List<Planning> plannings = new ArrayList<>();

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isSeeOwnMedication() {
        return seeOwnMedication;
    }

    public void setSeeOwnMedication(boolean seeOwnMedication) {
        this.seeOwnMedication = seeOwnMedication;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTelPharmacy() {
        return telPharmacy;
    }

    public void setTelPharmacy(String telPharmacy) {
        this.telPharmacy = telPharmacy;
    }

    public String getTelGeneralPractitioner() {
        return telGeneralPractitioner;
    }

    public void setTelGeneralPractitioner(String telGeneralPractitioner) {
        this.telGeneralPractitioner = telGeneralPractitioner;
    }

    public List<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }
}

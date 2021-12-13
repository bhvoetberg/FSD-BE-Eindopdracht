package nl.novi.fsdbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

}

package nl.novi.fsdbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Column
    private String medName;

    @Column
    private String perilous;

    @Column
    private String urlExternalInfo;

    @Column
    private String administerMethod;

    @Column
    private String dosageForm;

    @Column
    private String instructions;

    @Id
    @Column(nullable = false, unique = true)
    private Long id;
}

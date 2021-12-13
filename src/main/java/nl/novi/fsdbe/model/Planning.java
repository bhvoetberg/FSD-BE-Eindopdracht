package nl.novi.fsdbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planning")
public class Planning {

    @Column
    private String medName;

    @Column
    private Integer quantity;

    @Column
    private Integer frequencyPerDay;

    @Column
    private boolean activePlanning;

    @Column
    private String planDateTime;

    @Id
    @Column(nullable = false, unique = true)
    private Long id;

}


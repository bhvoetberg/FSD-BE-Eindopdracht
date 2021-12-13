package nl.novi.fsdbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deviations")
public class Deviation {
    @Column
    private String finding;

    @Column
    private String resolution;

    @Column
    private boolean activeDeviation;

    @Id
    @Column(nullable = false, unique = true)
    private Long id;

}

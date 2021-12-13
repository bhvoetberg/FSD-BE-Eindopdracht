package nl.novi.fsdbe.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends Person {

    @Column
    private String functionName;

}

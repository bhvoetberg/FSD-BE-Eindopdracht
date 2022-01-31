package nl.novi.fsdbe.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends Person {

    @Column
    private String functionName;

    @OneToOne
    @JsonIgnoreProperties("employee")
    @JoinColumn(name="user_id", referencedColumnName = "username")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
}

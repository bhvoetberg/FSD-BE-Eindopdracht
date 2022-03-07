package nl.novi.fsdbe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "planning")
public class Planning {

    @Column
    private Integer quantity;

    @Column
    private boolean enabled;

    @Column
    private String planDate;

    @Column
    private String planTime;

    @Column
    private String actPerformed;

    public String getActPerformed() {
        return actPerformed;
    }

    public void setActPerformed(String actPerformed) {
        this.actPerformed = actPerformed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("plannings")
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;

    @OneToOne
    @JoinColumn(name = "deviation_id", referencedColumnName = "id")
    private Deviation deviation;

    @ManyToOne
    @JsonIgnoreProperties("plannings")
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}


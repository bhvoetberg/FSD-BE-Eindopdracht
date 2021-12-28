package nl.novi.fsdbe.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Column
    private String medName;

    @Column
    private boolean perilous;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Planning> plannings;

    public List<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }



    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public boolean isPerilous() {
        return perilous;
    }

    public void setPerilous(boolean perilous) {
        this.perilous = perilous;
    }

    public String getUrlExternalInfo() {
        return urlExternalInfo;
    }

    public void setUrlExternalInfo(String urlExternalInfo) {
        this.urlExternalInfo = urlExternalInfo;
    }

    public String getAdministerMethod() {
        return administerMethod;
    }

    public void setAdministerMethod(String administerMethod) {
        this.administerMethod = administerMethod;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

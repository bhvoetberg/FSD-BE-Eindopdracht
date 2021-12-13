package nl.novi.fsdbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String apiKey;

    @Column
    private boolean enabled = true;

    @Id
    @Column(nullable = false, unique = true)
    private Long id;
}

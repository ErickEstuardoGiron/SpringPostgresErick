package datapostgres.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String edad;

    public User() {}

    public User(String name, String email, String edad) {
        this.name = name;
        this.email = email;
        this.edad = edad;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String name) {
        this.edad = edad;
    }
}

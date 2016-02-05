package senatest.sena1025844.entity;

/**
 * Created by ekmil on 4/2/2016.
 */
public class User {

    private String name;
    private String lastname;
    private Double identification;
    private String email;

    public User() {
    }

    public User(String name, String lastname, double identification,
                String email) {
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getIdentification() {
        return identification;
    }

    public void setIdentification(Double identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

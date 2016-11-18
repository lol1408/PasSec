package com.serega.springmvc.hibernate.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Model Resource for entity "resource"
 *
 * @author Makarenko Sergey
 * @version 1.0
 */
@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @Column(name = "idresource")
    @JsonProperty("idResource")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idResource;

    @Column(name = "nameresource", nullable = false)
    @JsonProperty("nameResource")
    private String nameResource;

    @Column(name = "login", nullable = false)
    @JsonProperty("login")
    private String login;

    @Column(name = "password", nullable = false)
    @JsonProperty("password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser", nullable = false)
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
    private User user;

    public Resource() {
    }

    public Resource(Long idResource, String nameResource, String login, String password) {
        this.idResource = idResource;
        this.nameResource = nameResource;
        this.login = login;
        this.password = password;
    }

    public Long getIdResource() {
        return idResource;
    }

    public void setIdResource(Long idResource) {
        this.idResource = idResource;
    }

    public String getNameResource() {
        return nameResource;
    }

    public void setNameResource(String nameResource) {
        this.nameResource = nameResource;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if(!user.getResources().contains(this)){
            user.getResources().add(this);
        }
    }
    @Override
    public String toString() {
        return "Resource{" +
                "idResource=" + idResource +
                ", nameResource='" + nameResource + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

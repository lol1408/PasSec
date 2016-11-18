package com.serega.springmvc.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.serega.springmvc.web.jsonview.Views;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sergey on 20.10.16.
 */
@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    @JsonProperty
    private Long idUser;

    @Column(name = "login", unique = true, nullable = false)
    @JsonProperty
    @JsonView(Views.Public.class)
    private String login;

    @Column(name = "password", nullable = false)
    @JsonProperty
    private String password;

    @Column(name = "mail",unique = true, nullable = false)
    @JsonProperty
    @JsonView(Views.Public.class)
    private String mail;

    @OneToMany(mappedBy = "user")
    private Set<Resource> resources = new HashSet<>(0);;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }
    public void addResource(Resource resource){
        this.resources.add(resource);
        if(resource.getUser()!=this){
            resource.setUser(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        User user = (User)o;
        if(this.login.equals(user.getLogin()) &&
                this.password.equals(user.getPassword())&&
                this.mail.equals(user.getMail()))return true;
        else return false;
    }
}

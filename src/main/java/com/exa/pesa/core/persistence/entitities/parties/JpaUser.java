package com.exa.pesa.core.persistence.entitities.parties;

import com.exa.pesa.core.model.parties.User;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by Andres on 9/10/2017.
 */
@Entity
@Table(name = "Usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"UsuarioNombre"}))
public class JpaUser {

    @Id
    @Column(name = "usuarioid")
    private Integer id;

    @Column(name = "usuarionombre", length = 100, nullable = false)
    private String name;

    @Column(name = "usuariologin", length = 20, nullable = false)
    private String login;

    @Column(name = "usuariopassword", length = 100, nullable = false)
    private String password;

    @Column(name = "usuariopasswordweb", length = 32, nullable = true)
    private String passwordWeb;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuariotipo", nullable = false)
    private JpaRole role;

    @Column(name = "inactivo", nullable = false)
    private boolean inactive;

    public JpaUser() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public JpaRole getRole() {
        return role;
    }

    public void setRole(JpaRole role) {
        this.role = role;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public String getPasswordWeb() {
        return passwordWeb;
    }

    public void setPasswordWeb(String passwordWeb) {
        this.passwordWeb = passwordWeb;
    }

    public User getModel(){
        User model = new User();
        model.setId(this.id);
        model.setName(this.name);
        model.setLogin(this.login);
        model.setPassword(this.password);
        model.setRole(this.role.getModel());
        model.setInactive(this.inactive);
        model.setPasswordWeb(this.passwordWeb);
        return model;
    }

}

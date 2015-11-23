package org.smf.ensuaranceEx1.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shehan on 11/22/2015.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> roles;

    @OneToMany(mappedBy = "user")
    private Set<ReqQuote> quotes;

    public static User createUser(String username, String email, String password) {
        User user = new User();

        user.username = username;
        user.email = email;
        user.password = password;

        user.quotes = new HashSet<ReqQuote>();
        if(user.roles == null) {
            user.roles = new HashSet<UserRole>();
        }
        user.roles.add(
                new UserRole(
                        RoleEnum.USER.toString(),
                        user
                ));

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public Set<ReqQuote> getQuotes() {
        return quotes;
    }

    public void setQuotes(Set<ReqQuote> quotes) {
        this.quotes = quotes;
    }
}

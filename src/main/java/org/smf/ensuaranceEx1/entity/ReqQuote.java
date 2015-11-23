package org.smf.ensuaranceEx1.entity;

import javax.persistence.*;

/**
 * Created by Shehan on 11/23/2015.
 */
@Entity
@Table(name = "reqQuote")
public class ReqQuote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "desc")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

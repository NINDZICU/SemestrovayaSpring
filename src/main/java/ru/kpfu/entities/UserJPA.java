package ru.kpfu.entities;

/**
 * Created by Anatoly on 15.05.2017.
 */

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "users"
)
public class UserJPA implements UserDetails,Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @NotNull
    @Column(
            name = "user_id",
            unique = true
    )
    private int id;
    @NotNull
    @Column(
            name = "login",
            unique = true
    )
    private String login;
    @NotNull
    @Column
    private String password;
    @Column
    @NotNull
    private String name;
    @Column(
            length = 2
    )
    @NotNull
    private String gender;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private Set<OrderJPA> orders;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private Set<CommentJPA> comments;

    @ManyToMany(fetch = FetchType.EAGER,cascade={CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_authorities", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
    inverseJoinColumns = {@JoinColumn(name="authority_id", referencedColumnName = "id")})
    private Set<AuthorityJPA> authorities = new HashSet<>();

    public UserJPA() {
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<OrderJPA> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<OrderJPA> orders) {
        this.orders = orders;
    }

    public Set<CommentJPA> getComments() {
        return this.comments;
    }

    public void setComments(Set<CommentJPA> comments) {
        this.comments = comments;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Set<AuthorityJPA> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AuthorityJPA> authorities) {
        this.authorities = authorities;
    }
    public void addAuthority(AuthorityJPA authority) {
        this.authorities.add(authority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserJPA userJPA = (UserJPA) o;

        if (id != userJPA.id) return false;
        if (login != null ? !login.equals(userJPA.login) : userJPA.login != null) return false;
        if (password != null ? !password.equals(userJPA.password) : userJPA.password != null) return false;
        if (name != null ? !name.equals(userJPA.name) : userJPA.name != null) return false;
        return gender != null ? gender.equals(userJPA.gender) : userJPA.gender == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}

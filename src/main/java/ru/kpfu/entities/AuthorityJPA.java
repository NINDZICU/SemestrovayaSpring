package ru.kpfu.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Anatoly on 23.05.2017.
 */
@Entity
@Table(name = "user_role")
public class AuthorityJPA implements GrantedAuthority {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @NotNull
    @Column(
            name = "id",
            unique = true
    )
    private int id;
    @Length(max = 30)
    @Column(unique = true)
    private String authority;
    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "authorities"
    )
    private Set<UserJPA> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<UserJPA> getUsers() {
        return users;
    }

    public void setUsers(Set<UserJPA> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorityJPA that = (AuthorityJPA) o;

        if (id != that.id) return false;
        return authority != null ? authority.equals(that.authority) : that.authority == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}

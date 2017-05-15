package ru.kpfu.entities;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "users"
)
public class UserJPA implements Serializable {
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

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            UserJPA user = (UserJPA)o;
            if(this.id != user.id) {
                return false;
            } else {
                label44: {
                    if(this.login != null) {
                        if(this.login.equals(user.login)) {
                            break label44;
                        }
                    } else if(user.login == null) {
                        break label44;
                    }

                    return false;
                }

                if(this.name != null) {
                    if(!this.name.equals(user.name)) {
                        return false;
                    }
                } else if(user.name != null) {
                    return false;
                }

                return this.gender != null?this.gender.equals(user.gender):user.gender == null;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.id;
        result = 31 * result + (this.login != null?this.login.hashCode():0);
        result = 31 * result + (this.name != null?this.name.hashCode():0);
        result = 31 * result + (this.gender != null?this.gender.hashCode():0);
        return result;
    }
}

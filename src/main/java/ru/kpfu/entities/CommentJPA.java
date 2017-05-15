package ru.kpfu.entities;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "comment"
)
public class CommentJPA implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @NotNull
    @Column(
            name = "id",
            unique = true
    )
    private Integer id = Integer.valueOf(-1);
    @Column(
            name = "text"
    )
    private String text;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}
    )
    @JoinColumn(
            name = "login",
            nullable = false
    )
    private UserJPA user;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}
    )
    @JoinColumn(
            name = "good_id",
            nullable = false
    )
    private GoodJPA good;

    public CommentJPA() {
    }

    public CommentJPA(String text, UserJPA user, GoodJPA good) {
        this.text = text;
        this.user = user;
        this.good = good;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserJPA getUser() {
        return this.user;
    }

    public void setUser(UserJPA user) {
        this.user = user;
    }

    public GoodJPA getGood() {
        return this.good;
    }

    public void setGood(GoodJPA good) {
        this.good = good;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            CommentJPA that = (CommentJPA)o;
            if(this.id != null) {
                if(!this.id.equals(that.id)) {
                    return false;
                }
            } else if(that.id != null) {
                return false;
            }

            label46: {
                if(this.text != null) {
                    if(this.text.equals(that.text)) {
                        break label46;
                    }
                } else if(that.text == null) {
                    break label46;
                }

                return false;
            }

            if(this.user != null) {
                if(this.user.equals(that.user)) {
                    return this.good != null?this.good.equals(that.good):that.good == null;
                }
            } else if(that.user == null) {
                return this.good != null?this.good.equals(that.good):that.good == null;
            }

            return false;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.id != null?this.id.hashCode():0;
        result = 31 * result + (this.text != null?this.text.hashCode():0);
        result = 31 * result + (this.user != null?this.user.hashCode():0);
        result = 31 * result + (this.good != null?this.good.hashCode():0);
        return result;
    }
}

package ru.kpfu.entities;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "orders"
)
public class OrderJPA {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @NotNull
    @Column(
            name = "order_id",
            unique = true
    )
    private int id;
    @Column
    private Date date;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinColumn(
            name = "login",
            nullable = false
    )
    private UserJPA user;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "order_goods",
            joinColumns = {@JoinColumn(
                    name = "order_id1",
                    referencedColumnName = "order_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "good_id",
                    referencedColumnName = "good_id"
            )}
    )
    private Set<GoodJPA> goods;

    public OrderJPA() {
    }

    public UserJPA getUser() {
        return this.user;
    }

    public void setUser(UserJPA user) {
        this.user = user;
    }

    public Set<GoodJPA> getGoods() {
        return this.goods;
    }

    public void setGoods(Set<GoodJPA> goods) {
        this.goods = goods;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            OrderJPA order = (OrderJPA)o;
            return this.id != order.id?false:(this.date != null?this.date.equals(order.date):order.date == null);
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.id;
        result = 31 * result + (this.date != null?this.date.hashCode():0);
        return result;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

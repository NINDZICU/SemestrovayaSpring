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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "goods"
)
public class GoodJPA implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @NotNull
    @Column(
            name = "good_id",
            unique = true
    )
    private Integer id = Integer.valueOf(-1);
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private String description;
    @Column
    private String img;
    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}
    )
    @JoinTable(
            name = "good_category",
            joinColumns = {@JoinColumn(
                    name = "good_id",
                    referencedColumnName = "good_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "category_id",
                    referencedColumnName = "id"
            )}
    )
    private Set<CategoryJPA> categories;
    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "goods"
    )
    private Set<OrderJPA> orders;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "good",
            cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH}
    )
    private Set<CommentJPA> comments;

    public GoodJPA() {
    }

    public GoodJPA(String name, double price, String description, Set<CategoryJPA> categories) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categories = categories;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CommentJPA> getComments() {
        return this.comments;
    }

    public void setComments(Set<CommentJPA> comments) {
        this.comments = comments;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<CategoryJPA> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<CategoryJPA> categories) {
        this.categories = categories;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<OrderJPA> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<OrderJPA> orders) {
        this.orders = orders;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            GoodJPA goodJPA = (GoodJPA)o;
            if(Double.compare(goodJPA.price, this.price) != 0) {
                return false;
            } else {
                label44: {
                    if(this.id != null) {
                        if(this.id.equals(goodJPA.id)) {
                            break label44;
                        }
                    } else if(goodJPA.id == null) {
                        break label44;
                    }

                    return false;
                }

                if(this.name != null) {
                    if(!this.name.equals(goodJPA.name)) {
                        return false;
                    }
                } else if(goodJPA.name != null) {
                    return false;
                }

                return this.description != null?this.description.equals(goodJPA.description):goodJPA.description == null;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.id != null?this.id.hashCode():0;
        result = 31 * result + (this.name != null?this.name.hashCode():0);
        long temp = Double.doubleToLongBits(this.price);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        result = 31 * result + (this.description != null?this.description.hashCode():0);
        return result;
    }
}


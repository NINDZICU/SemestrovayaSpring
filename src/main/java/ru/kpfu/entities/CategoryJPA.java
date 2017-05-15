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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "category"
)
public class CategoryJPA implements Serializable {
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
            unique = true
    )
    @NotNull
    private String name;
    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "categories",
            cascade = {CascadeType.REFRESH}
    )
    private Set<GoodJPA> goods;

    public CategoryJPA() {
    }

    public CategoryJPA(String name, Set<GoodJPA> goods) {
        this.name = name;
        this.goods = goods;
    }

    public CategoryJPA(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<GoodJPA> getGoods() {
        return this.goods;
    }

    public void setGoods(Set<GoodJPA> goods) {
        this.goods = goods;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            CategoryJPA that = (CategoryJPA)o;
            if(this.id != null) {
                if(this.id.equals(that.id)) {
                    return this.name != null?this.name.equals(that.name):that.name == null;
                }
            } else if(that.id == null) {
                return this.name != null?this.name.equals(that.name):that.name == null;
            }

            return false;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.id != null?this.id.hashCode():0;
        result = 31 * result + (this.name != null?this.name.hashCode():0);
        return result;
    }
}

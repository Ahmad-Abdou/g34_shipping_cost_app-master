package se.lexicon.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Box {
    @Id
    @GeneratedValue(generator = "UUID")
    private String id;
    private String name;
    private String country;
    private String type;
    private double cost;
    private double weight;
    private String weightType;
    private LocalDateTime createDate;
    private boolean status;

    public Box() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeightType() {
        return weightType;
    }

    public void setWeightType(String weightType) {
        this.weightType = weightType;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box box = (Box) o;

        if (Double.compare(box.cost, cost) != 0) return false;
        if (Double.compare(box.weight, weight) != 0) return false;
        if (status != box.status) return false;
        if (id != null ? !id.equals(box.id) : box.id != null) return false;
        if (name != null ? !name.equals(box.name) : box.name != null) return false;
        if (country != null ? !country.equals(box.country) : box.country != null) return false;
        if (type != null ? !type.equals(box.type) : box.type != null) return false;
        if (weightType != null ? !weightType.equals(box.weightType) : box.weightType != null) return false;
        return createDate != null ? createDate.equals(box.createDate) : box.createDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (weightType != null ? weightType.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", weightType='" + weightType + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                '}';
    }
}


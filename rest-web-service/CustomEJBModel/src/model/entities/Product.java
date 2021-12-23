package model.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.FetchType;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "PRODUCT")
@XmlRootElement(name = "product")
@NamedQueries({ @NamedQuery(name = "Product.findAll", query = "select o from Product o") })
public class Product implements Serializable {

    private static final long serialVersionUID = -393944207562348939L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRO_SEQ")
    @SequenceGenerator(name = "PRO_SEQ", sequenceName = "PRODUCT_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(name = "PRODUCT_CODE", nullable = false, length = 50)
    private String productCode;

    @XmlTransient
    //@OneToMany(mappedBy = "product", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderrDetail> orderrDetailList;

    public Product() {
    }

    public Product(String description, Long id, String productCode) {
        this.description = description;
        this.id = id;
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @XmlTransient
    public List<OrderrDetail> getOrderrDetailList() {
        return orderrDetailList;
    }

    @XmlTransient
    public void setOrderrDetailList(List<OrderrDetail> orderrDetailList) {
        this.orderrDetailList = orderrDetailList;
    }

    public OrderrDetail addOrderrDetail(OrderrDetail orderrDetail) {
        getOrderrDetailList().add(orderrDetail);
        orderrDetail.setProduct(this);
        return orderrDetail;
    }

    public OrderrDetail removeOrderrDetail(OrderrDetail orderrDetail) {
        getOrderrDetailList().remove(orderrDetail);
        orderrDetail.setProduct(null);
        return orderrDetail;
    }
}

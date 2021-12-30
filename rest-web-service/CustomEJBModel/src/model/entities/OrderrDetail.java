package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "ORDERR_DETAIL")
@XmlType(propOrder = { "id", "orderr", "product", "quantity" })
@NamedQueries({ @NamedQuery(name = "OrderrDetail.findAll", query = "select o from OrderrDetail o") })
public class OrderrDetail implements Serializable {

    private static final long serialVersionUID = 3977884245957785413L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDDT_SEQ")
    @SequenceGenerator(name = "ORDDT_SEQ", sequenceName = "ORDERR_DETAIL_ID_SEQ_GEN", allocationSize = 1,
                       initialValue = 1)
    private Long id;
    @Column(nullable = false)
    private Long quantity;

    // FK
    @ManyToOne
    @JoinColumn(name = "ORDERR_ID")
    private Orderr orderr;
    // FK
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public OrderrDetail() {
    }

    public OrderrDetail(Long id, Orderr orderr, Product product, Long quantity) {
        this.id = id;
        this.orderr = orderr;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Orderr getOrderr() {
        return orderr;
    }

    public void setOrderr(Orderr orderr) {
        this.orderr = orderr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

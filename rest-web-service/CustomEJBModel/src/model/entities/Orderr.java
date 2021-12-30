package model.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Table;
import javax.persistence.FetchType;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "ORDERR")
@XmlType(propOrder = { "customer", "documentNumber", "id", "orderrDate" })
@NamedQueries({ @NamedQuery(name = "Orderr.findAll", query = "select o from Orderr o") })
public class Orderr implements Serializable {

    private static final long serialVersionUID = 6813680977724329790L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORD_SEQ")
    @SequenceGenerator(name = "ORD_SEQ", sequenceName = "ORDERR_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
    private Long id;
    @Column(name = "DOCUMENT_NUMBER", unique = true)
    private Long documentNumber;
    @Temporal(TemporalType.DATE)
    @Column(name = "ORDERR_DATE", nullable = false)
    private Date orderrDate;

    // FK
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @XmlTransient
    @OneToMany(mappedBy = "orderr", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderrDetail> orderrDetailList;

    public Orderr() {
    }

    public Orderr(Customer customer, Long documentNumber, Long id, Date orderrDate) {
        this.customer = customer;
        this.documentNumber = documentNumber;
        this.id = id;
        this.orderrDate = orderrDate;
    }


    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderrDate() {
        return orderrDate;
    }

    public void setOrderrDate(Date orderrDate) {
        this.orderrDate = orderrDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        orderrDetail.setOrderr(this);
        return orderrDetail;
    }

    public OrderrDetail removeOrderrDetail(OrderrDetail orderrDetail) {
        getOrderrDetailList().remove(orderrDetail);
        orderrDetail.setOrderr(null);
        return orderrDetail;
    }
}

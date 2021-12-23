package model.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.FetchType;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CUSTOMER")
@XmlRootElement(name = "customer")
@NamedQueries({ @NamedQuery(name = "Customer.findAll", query = "select o from Customer o") })
public class Customer implements Serializable {

    private static final long serialVersionUID = 7843543187434810749L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(name = "CUST_SEQ", sequenceName = "CUSTOMER_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
    private Long id;
    @Temporal(TemporalType.DATE)
    //@XmlJavaTypeAdapter(model.adapter.DateStringToCalendar.class)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name = "CUSTOMER_CODE", unique = true, length = 50)
    private String customerCode;
    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;
    @Column(name = "TAX_IDENTIFICATION_NUMBER", unique = true, length = 50)
    private String taxIdentificationNumber;

    @XmlTransient
    //@OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Orderr> orderrList;

    public Customer() {
    }

    public Customer(Date birthDate, String customerCode, String firstName, Long id, String lastName,
                    String taxIdentificationNumber) {
        this.birthDate = birthDate;
        this.customerCode = customerCode;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    @XmlTransient
    public List<Orderr> getOrderrList() {
        return orderrList;
    }

    @XmlTransient
    public void setOrderrList(List<Orderr> orderrList) {
        this.orderrList = orderrList;
    }

    public Orderr addOrderr(Orderr orderr) {
        getOrderrList().add(orderr);
        orderr.setCustomer(this);
        return orderr;
    }

    public Orderr removeOrderr(Orderr orderr) {
        getOrderrList().remove(orderr);
        orderr.setCustomer(null);
        return orderr;
    }
}

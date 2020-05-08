package com.wipro.employeews.context;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String empId;
    private String empFirstName;
    private String empLastName;
    private String empLocation;
    private String empBand;

    public Employee() {
    }

    public Employee(String empId, String empFirstName, String empLastName, String empLocation, String empBand) {
        this.empId = empId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empLocation = empLocation;
        this.empBand = empBand;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpLocation() {
        return empLocation;
    }

    public void setEmpLocation(String empLocation) {
        this.empLocation = empLocation;
    }

    public String getEmpBand() {
        return empBand;
    }

    public void setEmpBand(String empBand) {
        this.empBand = empBand;
    }

}

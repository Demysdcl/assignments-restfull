package com.wipro.jersey.student.app.ws.context;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentId;
    private String studentName;
    private String studentClass;
    private Float studentTotalMarks;

    public Student() {
    }

    public Student(String studentId, String studentName, String studentClass, Float studentTotalMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentTotalMarks = studentTotalMarks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Float getStudentTotalMarks() {
        return studentTotalMarks;
    }

    public void setStudentTotalMarks(Float studentTotalMarks) {
        this.studentTotalMarks = studentTotalMarks;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.studentId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this == obj || Objects.equals(this.studentId, ((Student) obj).studentId);
    }

}

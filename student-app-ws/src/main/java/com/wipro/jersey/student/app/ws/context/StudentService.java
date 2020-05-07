package com.wipro.jersey.student.app.ws.context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentService implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>(Arrays.asList(
            new Student("S001", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S002", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S003", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S004", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S005", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S006", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S007", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S008", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S009", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S010", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S011", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S012", "Steve Martin", "C" + randClass(), randMarks())
        ));
    }

    private float randMarks() {
        return new Random().nextFloat() * (10 - 0) + 0;
    }

    private int randClass() {
        return new Random().nextInt() * (100 - 1) + 1;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public Student getStudentById(String id) {
        return this.students.stream()
            .filter(it -> it.getStudentId().equalsIgnoreCase(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Any student found by ID: " + id));
    }

    public List<Student> getStudentsThatHasScoreGT(float mark) {
        return this.students.stream()
            .filter(it -> it.getStudentTotalMarks() > mark)
            .collect(Collectors.toList());
    }

    public Student saveStudent(Student student) {
        this.students.forEach(it -> {
            if (it.getStudentId().equalsIgnoreCase(student.getStudentId())) {
                throw new RuntimeException("ID: " + it.getStudentId() + " already exists!");
            }
        });
        this.students.add(student);
        return student;
    }

    public Student updateStudent(Student student) {
        Student studentUpdatable = this.getStudentById(student.getStudentId());
        studentUpdatable.setStudentClass(student.getStudentClass());
        studentUpdatable.setStudentName(student.getStudentName());
        studentUpdatable.setStudentTotalMarks(student.getStudentTotalMarks());
        return studentUpdatable;
    }

    public void deleteStudent(Student student) {
        Student studentToDelete = this.getStudentById(student.getStudentId());
        this.students.remove(studentToDelete);
    }

    List<Student> getStudentsBelongClass(String studenClass) {
        return this.students.stream()
            .filter(it -> it.getStudentClass().equals(studenClass))
            .collect(Collectors.toList());
    }

}

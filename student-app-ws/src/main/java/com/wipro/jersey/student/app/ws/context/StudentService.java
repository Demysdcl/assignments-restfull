package com.wipro.jersey.student.app.ws.context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final List<Student> STUDENTS;

    static {
        STUDENTS = new ArrayList<>(Arrays.asList(
            new Student("S001", "Steve Martin", "C" + randClass(), randMarks()),
            new Student("S002", "Demys Lima", "C" + randClass(), randMarks()),
            new Student("S003", "Martin Loren", "C" + randClass(), randMarks()),
            new Student("S004", "Rick Martinez", "C" + randClass(), randMarks()),
            new Student("S005", "Bill Garcia", "C" + randClass(), randMarks()),
            new Student("S006", "Ruan Montana", "C" + randClass(), randMarks()),
            new Student("S007", "Tailon Twitter", "C" + randClass(), randMarks()),
            new Student("S008", "Igor Gonzales", "C" + randClass(), randMarks()),
            new Student("S009", "Diogo Silva", "C" + randClass(), randMarks()),
            new Student("S010", "Silvio Monteiro", "C" + randClass(), randMarks()),
            new Student("S011", "Marcos Rosa", "C" + randClass(), randMarks()),
            new Student("S012", "Vinicius Reis", "C" + randClass(), randMarks())
        ));
    }

    private static float randMarks() {
        float random = new Random().nextFloat() * (10 - 0) + 0;
        return Float.parseFloat(String.format("%.01f", random));
    }

    private static int randClass() {
        return new Random().nextInt(10 - 1 + 1) + 1;
    }

    public List<Student> getStudents() {
        return STUDENTS;
    }

    public Student getStudentById(String id) {
        return STUDENTS.stream()
            .filter(it -> it.getStudentId().equalsIgnoreCase(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Any student found by ID: " + id));
    }

    public List<Student> getStudentsThatHasScoreGT(float mark) {
        return STUDENTS.stream()
            .filter(it -> it.getStudentTotalMarks() > mark)
            .collect(Collectors.toList());
    }

    public Student saveStudent(Student student) {
        STUDENTS.forEach(it -> {
            if (it.getStudentId().equalsIgnoreCase(student.getStudentId())) {
                throw new RuntimeException("ID: " + it.getStudentId() + " already exists!");
            }
        });
        STUDENTS.add(student);
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
        STUDENTS.remove(studentToDelete);
    }

    List<Student> getStudentsBelongClass(String studenClass) {
        return STUDENTS.stream()
            .filter(it -> it.getStudentClass().equalsIgnoreCase(studenClass))
            .collect(Collectors.toList());
    }

}

package com.wipro.jersey.student.app.ws;

import com.wipro.jersey.student.app.ws.context.Student;
import com.wipro.jersey.student.app.ws.context.StudentService;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();
        System.out.println(service.getStudents().size());
        Student student = service.getStudentById("S001");
        service.deleteStudent(student);
        System.out.println(service.getStudents().size());

    }
}

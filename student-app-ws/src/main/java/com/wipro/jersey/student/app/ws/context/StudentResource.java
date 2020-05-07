package com.wipro.jersey.student.app.ws.context;

import java.io.Serializable;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/students")
public class StudentResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private final StudentService service = new StudentService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> getStudents() {
        return this.service.getStudents();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Student getStudentById(@PathParam("id") String id) {
        return this.service.getStudentById(id);
    }

    @GET
    @Path("/mark/{mark}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> getStudentsThatHasScoreGT(
        @DefaultValue("7") @PathParam("mark") float score,
        @DefaultValue("0") @QueryParam("mark") float queryMark,
        @DefaultValue("0") @MatrixParam("mark") float matrixMark) {

        float selectedScore = queryMark > 0 ? queryMark
            : matrixMark > 0 ? matrixMark : score;

        return this.service.getStudentsThatHasScoreGT(selectedScore);
    }

    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Student saveStudent(
        @FormParam("studentId") String studentId,
        @FormParam("studentName") String studentName,
        @FormParam("studentClass") String studentClass,
        @FormParam("studentTotalMark") float studentTotalMark) {
        return this.service.saveStudent(new Student(studentId, studentName, studentClass, studentTotalMark));
    }

    @PUT
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Student updateStudent(
        @FormParam("studentId") String studentId,
        @FormParam("studentName") String studentName,
        @FormParam("studentClass") String studentClass,
        @FormParam("studentTotalMark") float studentTotalMark) {
        return this.service.updateStudent(new Student(studentId, studentName, studentClass, studentTotalMark));
    }

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteStudent(@FormParam("student") Student student) {
        this.service.deleteStudent(student);
    }

    @GET
    @Path("/class/{class}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> getStudentsBelongClass(
        @DefaultValue("C1") @PathParam("class") String studenClass,
        @DefaultValue("") @QueryParam("class") String queryClass,
        @DefaultValue("") @MatrixParam("class") String matrixClass
    ) {
        String selectedClass = !queryClass.isEmpty() ? queryClass
            : !matrixClass.isEmpty() ? matrixClass : studenClass;
        return this.service.getStudentsBelongClass(selectedClass);
    }

}

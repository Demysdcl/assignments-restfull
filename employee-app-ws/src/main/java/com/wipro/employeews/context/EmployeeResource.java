package com.wipro.employeews.context;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employees")
public class EmployeeResource {

    private final EmployeeService service = new EmployeeService();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employee> employees() {
        return service.findAll();
    }

    @GET
    @Path("location/{location}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employee> findByEmpLocation(@PathParam("location") String empLocation) {
        return service.findByEmpLocation(empLocation);
    }

    @GET
    @Path("band/{band}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employee> findByEmpBand(@PathParam("band") String empBand) {
        return service.findByEmpBand(empBand);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML})
    public Employee save(Employee employee) {
        return service.save(employee);
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee update(@PathParam("id") String empId, Employee employee) {
        return service.update(empId, employee);
    }

}

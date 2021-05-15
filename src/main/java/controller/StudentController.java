package controller;

import entity.Student;
import service.StudentService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/students")
public class StudentController {

    StudentService studentService = new StudentService();

//     http://something.com/rest/students
    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> getListStudent() {
        return studentService.getListStudent();
    }

    // http://something.com/rest/students/123
    @GET
    @Path("/1")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Student getStudent() {
        return studentService.findID();
    }

}

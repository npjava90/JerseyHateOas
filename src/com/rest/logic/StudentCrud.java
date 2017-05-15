package com.rest.logic;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.rest.model.Student;



//HATEOAS  
@Path("produceboth")
public class StudentCrud {

	@Context
	UriInfo uriInfo;
	Student student = null;
	{

		student = new Student();
		student.setAge(10);
		student.setName("Npp");

	}

	@Path("both")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student addStudent() {

		student.setAge(27);
		student.setName("Amay jha");

		 java.net.URI selfUri1 = uriInfo.getBaseUriBuilder().path(StudentCrud.class)
				.path(StudentCrud.class, "getStudent").build(student.getName());
		 
		 java.net.URI selfUri2 = uriInfo.getBaseUriBuilder().path(StudentCrud.class)
					.path(StudentCrud.class, "updateStudent").build(student.getName());
		 
		 java.net.URI selfUri3 = uriInfo.getBaseUriBuilder().path(StudentCrud.class)
					.path(StudentCrud.class, "deleteStudent").build(student.getName());
		 
		 
		student.getLinks().add(selfUri1);
		student.getLinks().add(selfUri2);
		student.getLinks().add(selfUri3);
		return student;
	}

	@Path("getStudent")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent() {

		return student;
	}

	@Path("updateStudent")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateStudent() {
		student.setAge(25);
		student.setName("Nisha Jain");
		
		
		return student;
	}

	@Path("deleteStudent")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent() {
		student.setAge(25);
		student.setName("Nisha Jain");
		return student;
	}

}
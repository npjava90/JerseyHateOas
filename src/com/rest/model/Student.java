package com.rest.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	 private String name;
	    private int age;
	    
	   
	     private List<URI> links = new ArrayList<URI>();
	       
	    public Student() {
	    }
	    public String getName() {
	        return name;
	    }
	    public List<URI> getLinks() {
			return links;
		}
		public void setLinks(List<URI> links) {
			this.links = links;
		}
		public void setName(String name) {
	        this.name = name;
	    }
	    public int getAge() {
	        return age;
	    }
	    public void setAge(int age) {
	        this.age = age;
	    }
}

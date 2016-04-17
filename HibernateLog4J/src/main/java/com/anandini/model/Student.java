package com.anandini.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name = "StudentEntity")
@Table( name = "STUDENT" , uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"), 
		@UniqueConstraint(columnNames = "EMAIL")
		})
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID" , unique = true , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "EMAIL" , unique = true , nullable = false , length = 100)
	private String email;
	
	
	@Column(name = "FIRSTNAME" , unique = false , nullable = false , length = 50)
	private String firstName;
	
	@Column(name = "LASTNAME" , unique = false , nullable = false , length = 50)
	private String lastName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="STUDENT_DEPT",joinColumns={@JoinColumn(referencedColumnName="ID")}
	,inverseJoinColumns={ @JoinColumn(referencedColumnName="ID")} )
	private Set<Department> departments;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
	
}

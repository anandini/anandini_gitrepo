package com.anandini.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "DepartmentEntity")
@Table(name = "DEPARTMENT" , uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")
		})
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID" , unique = true , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	
	@Column(name = "DEPTNAME" , unique = true , nullable = false , length = 100)
	private String deptName;
	
	/*@ManyToMany(cascade=CascadeType.ALL,mappedBy = "departments")
	private Set<Student> students ;*/

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/*public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}*/
	
}

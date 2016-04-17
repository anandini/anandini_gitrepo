package com.anandini;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.anandini.model.Department;
import com.anandini.model.Student;
import com.anandini.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Hello World!" );
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("session : "+session);
        
        session.beginTransaction();
       
        Department dept1 = new Department();
        dept1.setDeptName("Maths");
        
        Department dept2 = new Department();
        dept2.setDeptName("Science");
        
        Department dept3 = new Department();
        dept3.setDeptName("Computer");
        
        Set<Department> setDept = new HashSet<Department>();
        setDept.add(dept1);
        setDept.add(dept2);
        setDept.add(dept3);
        
        Student student1 = new Student();
        student1.setFirstName("Rahul");
        student1.setLastName("Shrama");
        student1.setEmail("aaa@gmail.com");
        
        Student student2 = new Student();
        student2.setFirstName("Rahul1");
        student2.setLastName("Shrama1");
        student2.setEmail("bbb@gmail.com");
        
        Student student3 = new Student();
        student3.setFirstName("Rahul2");
        student3.setLastName("Shrama2");
        student3.setEmail("ccc@gmail.com");
        
        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        
        student1.setDepartments(setDept);
        student2.setDepartments(setDept);
        student3.setDepartments(setDept);
        
      
        
        session.save(student1);
        session.save(student2);
        session.save(student3);
   
        
        session.getTransaction().commit();
        session.close();
        
        sessionFactory.close();
        
    }
}

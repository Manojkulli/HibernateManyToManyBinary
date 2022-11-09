package com.ty.BinaryManyToMany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.BinaryManyToMany.dto.Student;
import com.ty.BinaryManyToMany.dto.Teacher;

public class Teacherdao {

	public static void main(String[] args) {
		
		Teacher t1=new Teacher();
		t1.setName("parimala");
		t1.setSubject("Kannada");
		
		Teacher t2=new Teacher();
		t2.setName("Dimple");
		t2.setSubject("English");
		
		Teacher t3=new Teacher();
		t3.setName("Manoj");
		t3.setSubject("Social");
		
		Student s1=new Student();
		s1.setGrade("A");
		s1.setName("Manoj");
		
		Student s2=new Student();
		s2.setGrade("B");
		s2.setName("Akash");
		
		Student s3=new Student();
		s3.setGrade("C");
		s3.setName("Rakesh");
		
		List<Student> ls1=new ArrayList<Student>();
		ls1.add(s1);
		ls1.add(s3);
		t1.setStudent(ls1);
		
		List<Student> ls2=new ArrayList<Student>();
		ls2.add(s2);
		ls2.add(s3);
		t2.setStudent(ls2);
		
		List<Student> ls3=new ArrayList<Student>();
		ls3.add(s1);
		ls3.add(s2);
		t3.setStudent(ls3);
		
		List<Teacher> lt1=new ArrayList<Teacher>();
		lt1.add(t1);
		lt1.add(t3);
		s1.setTeacher(lt1);
		
		List<Teacher> lt2=new ArrayList<Teacher>();
		lt2.add(t2);
		lt2.add(t3);
		s2.setTeacher(lt2);
		
		List<Teacher> lt3=new ArrayList<Teacher>();
		lt3.add(t1);
		lt3.add(t2);
		s3.setTeacher(lt3);
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("manoj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		entityManager.persist(t3);
		entityManager.persist(t2);
		entityManager.persist(t1);
		entityTransaction.commit();
	}
}

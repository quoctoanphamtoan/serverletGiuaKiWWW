package com.giuaki.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.giuaki.entity.Person;
import com.giuaki.util.hibernateUtil;

public class PersonDao {
	public List<Person> getAllPerson() {
		List<Person> list = null;
		Transaction transaction = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Person> query = session.createQuery("FROM Person", Person.class);
			list = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}

		return list;

	}
	
	public void addPerson(Person person) {
		 
		Transaction transaction = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(person);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
 

	}
	public void deletePerson(int id) {
		 
		Transaction transaction = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			 Person person = session.find(Person.class,id);
			 session.remove(person);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
 

	}
	
	public Person getPersonById(int personId) { 
		Transaction transaction = null;
		Person person = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			  person = session.find(Person.class,personId); 
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
		return person;
	}
	
	public void editPerson(int personId,Person personNew) { 
		Transaction transaction = null; 
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			  Person personEdit = session.find(Person.class,personId); 
			  personEdit.setAddress(personNew.getAddress());
			  personEdit.setName(personNew.getName());
			  personEdit.setDate(personNew.getDate());
			  session.saveOrUpdate(personEdit);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
	 
	}
	
	
	
	
	public static void main(String[] args) {
//		new PersonDao().
		System.out.println(new PersonDao().getPersonById(1));
	}
	
}

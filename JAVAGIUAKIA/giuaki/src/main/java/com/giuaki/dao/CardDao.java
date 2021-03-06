package com.giuaki.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.giuaki.entity.Card;
import com.giuaki.entity.Person;
import com.giuaki.util.hibernateUtil;

public class CardDao {
	public List<Card> getAllCard(int personId) {
		List<Card> list = null;
		Transaction transaction = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Card> query = session.createQuery("FROM Card where person_id = "+personId, Card.class);
			list = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		return list;	
	}
	public void addCard(int personId,Card card) { 
		Transaction transaction = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			 Person person = session.find(Person.class,personId);
			 person.addCard(card); 
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
	}
	
	public void deleteCard(int cardId) { 
		Transaction transaction = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			 Card card = session.find(Card.class,cardId);
			 session.remove(card);
			 		 
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
	}
	
	public Card getCardById(int cardId) { 
		Transaction transaction = null;
		Card card = null;
		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			 card = session.find(Card.class,cardId);  
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
		return card;
	}
	public void editCard(int cardId,Card cardNew) { 
		Transaction transaction = null;

		try (Session session = hibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Card cardEdit = session.find(Card.class,cardId);  
			 cardEdit.setNumber(cardNew.getNumber());
			 cardEdit.setType(cardNew.getType());
			 session.saveOrUpdate(cardEdit);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
		 
	}
	
	
public static void main(String[] args) {
//	new CardDao().deleteCard(5);
	System.out.println(new CardDao().getCardById(11));
	
}
}

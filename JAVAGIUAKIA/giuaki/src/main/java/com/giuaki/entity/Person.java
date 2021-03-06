package com.giuaki.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "date")
	private String date;

	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private List<Card> cards;
 	
	
	
	public void setDate(String date) {
		this.date = date;
	}

	public void addCard(Card card) {
		this.cards.add(card); 
	}
	
	public int getId() {
		return id;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Card> getCards() {
		return cards;
	}


	public void setCards(List<Card> cards) {
		this.cards = cards;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}
 

 

	public Person(int id, String name, String address, String date, List<Card> cards) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.date = date;
		this.cards = cards;
	}


	public Person(String name, String address, String date) {
		super();
		this.name = name;
		this.address = address;
		this.date = date;
	}


	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", address=" + address + ", date=" + date + "]";
	}
	
	
	
	
}

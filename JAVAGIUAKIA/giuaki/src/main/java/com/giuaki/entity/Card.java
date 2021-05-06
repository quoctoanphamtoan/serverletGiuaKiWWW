package com.giuaki.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Card")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "type")
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Card(int id, String number, String type) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
	}

	public Card(String number, String type) {
		super();
		this.number = number;
		this.type = type;
	}

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", number=" + number + ", type=" + type + "]";
	}
	
	
	
	
}

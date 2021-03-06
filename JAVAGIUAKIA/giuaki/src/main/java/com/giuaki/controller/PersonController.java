package com.giuaki.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giuaki.dao.PersonDao;
import com.giuaki.entity.Person;

///....../person/add
///....../person/delete
//urlPatterns ("/person/*")
@WebServlet("/person/*")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDao personDao;

	public PersonController() {
		personDao = new PersonDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().substring(29).toString();
		System.out.println(url);
		switch (url) {
		case "person":
			showFormPerson(request, response);
			break;
//person/add
		case "person/add":
			showFromAdPerson(request, response);
			break;
//person/addperson
		case "person/addperson":
			addPerson(request, response);
			break;
//person/delete?id=1	
		case "person/delete":
			deletePerson(request, response);
			break;
//person/edit?id=1
		case "person/edit":
			showFormEditPerson(request, response);
			break;
///person/editperson?1
		case "person/editperson":
			editPerson(request, response);
			break;
		default:
			break;
		}
	}

	private void editPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int personId = Integer.parseInt(request.getParameter("id").toString());
		String name = request.getParameter("name").toString();
		String address = request.getParameter("address").toString();
		String date = request.getParameter("date").toString();
		Person personNew = new Person(name, address, date);
		personDao.editPerson(personId, personNew);
		response.sendRedirect("/giuaki/person");
		
	}

	private void showFormEditPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int personId = Integer.parseInt(request.getParameter("id").toString());
		request.setAttribute("personEdit", personDao.getPersonById(personId)); 
		request.getRequestDispatcher("/WEB-INF/views/FormEditPerson.jsp").forward(request, response);
		
	}

	private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id").toString());

		personDao.deletePerson(id);
		response.sendRedirect("/giuaki/person");

	}

	private void addPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name").toString();
		String address = request.getParameter("address").toString();
		String date = request.getParameter("date").toString();
		personDao.addPerson(new Person(name, address, date));

		response.sendRedirect("/giuaki/person");

	}

	private void showFromAdPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/FormAddPerson.jsp").forward(request, response);

	}

	private void showFormPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listPerson", personDao.getAllPerson());
		// personDao.getAllPerson() l? list person
		// List<Person> list = personDao.getAllPerson();
		// request.setAttribute("listPerson", list);
		request.getRequestDispatcher("/WEB-INF/views/Person.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

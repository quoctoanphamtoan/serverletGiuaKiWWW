package com.giuaki.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giuaki.dao.CardDao;
import com.giuaki.entity.Card;

 @WebServlet("/card/*")
public class CardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CardDao cardDao ;
     
    public CardController() {
        cardDao = new CardDao();
       
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().substring(29).toString();
		System.out.println(url);
		 switch (url) {
		case "card":
			showCard(request,response);
			break;
//			card/addcard
			
		case "card/addcard":
			showFormAddCard(request,response);
			break;
//			card/addCardToPerson?id=1 
		case "card/addCardToPerson":
			addCardToPerson(request,response);
			break;
			
//         card/delete?id=1
		case "card/delete":
			deleteCard(request,response);
			break;
//			card/edit?id=11&&personId=1
		case "card/edit":
			showFormEditCard(request,response);
			break;
//			card/editCard?id=1
		case "card/editCard":
			editCard(request,response);
			break;
		default:
			break;
		}
	}
 
	private void editCard(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		id=1&&cardId=11 
		int personId = Integer.parseInt(request.getParameter("id").toString());
		int id = Integer.parseInt(request.getParameter("cardId").toString());
		String number = request.getParameter("number").toString();
		String type = request.getParameter("type").toString();
		
		Card cardNew = new Card(number, type);
		cardDao.editCard(id, cardNew);
		response.sendRedirect("/giuaki/card?id="+personId);
		
	}


	private void showFormEditCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		id=11&&personId=1

		int cardId = Integer.parseInt(request.getParameter("id").toString());
		request.setAttribute("cardEdit", cardDao.getCardById(cardId));
		int personId = Integer.parseInt(request.getParameter("personId").toString());
		request.setAttribute("personId", personId);
		 request.getRequestDispatcher("/WEB-INF/views/FormEditCard.jsp").forward(request, response);
		
	}


	private void deleteCard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cardId = Integer.parseInt(request.getParameter("id").toString());
		cardDao.deleteCard(cardId);
		int personId = Integer.parseInt(request.getParameter("personId").toString());
		response.sendRedirect("/giuaki/card?id="+personId);
		 
	}


	private void addCardToPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int personId = Integer.parseInt(request.getParameter("id").toString());
		String number = request.getParameter("number").toString();
		String type = request.getParameter("type").toString();
		cardDao.addCard(personId, new Card(number, type));
		response.sendRedirect("/giuaki/card?id="+personId);
		
	}


	private void showFormAddCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		id=1
		int personId = Integer.parseInt(request.getParameter("id").toString());
		request.setAttribute("personId", personId);
	 request.getRequestDispatcher("/WEB-INF/views/FormAddCard.jsp").forward(request, response);
		
	}


	private void showCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int personId = Integer.parseInt(request.getParameter("id").toString());
			request.setAttribute("listCard", cardDao.getAllCard(personId));
			request.setAttribute("personId",personId);
		request.getRequestDispatcher("/WEB-INF/views/Card.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}

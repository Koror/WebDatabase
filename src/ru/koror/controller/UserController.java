package ru.koror.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.koror.dao.UserDAO;
import ru.koror.model.User;

@WebServlet("/backend")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public final String LIST_USER="/user_list.jsp";
	public final String INSERT_EDIT="/user.jsp";
	UserDAO dao;
	public UserController()
	{
		super();
		dao = new UserDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete"))
		{
			dao.deleteUser(Integer.parseInt(request.getParameter("userId")));
			forward=LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		}
		else if(action.equalsIgnoreCase("edit"))
		{
			User user = dao.getUserById(Integer.parseInt(request.getParameter("userId")));
			forward=INSERT_EDIT;
			request.setAttribute("user", user);
		}
		else if(action.equalsIgnoreCase("listUser"))
		{
			forward=LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else if(action.equalsIgnoreCase("insert")){
            forward=INSERT_EDIT;
        }
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Если пришел параметр id, то обнавляем пользователя иначе создаем нового
		if((request.getParameter("id")!=null)&(request.getParameter("id")!=""))
		{
			dao.updateUser(request.getParameter("nickname"), request.getParameter("pass"), Integer.parseInt(request.getParameter("id")));
		}else
		{
			dao.addUser(request.getParameter("nickname"), request.getParameter("pass"), request.getParameter("email"));
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
	    request.setAttribute("users", dao.getAllUsers());
	    view.forward(request, response);
	}

}

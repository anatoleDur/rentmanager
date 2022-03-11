package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	
	@Autowired
	ClientService clientService;

	private static final long serialVersionId = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("listUsers", this.clientService.findAll());
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/users/list.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// traitement du formulaire (appel à la méthode de sauvegarde)

		try {
			if(request.getParameter("delete")!=null) {
			this.clientService.delete(Integer.parseInt(request.getParameter("delete")));
			this.doGet(request, response);
			}
//			if(request.getParameter("modify")!=null) {
//				this.clientService.delete(Integer.valueOf(request.getQueryString().substring(3)));
//				int idUser=Integer.parseInt(request.getParameter("modify"));
//				request.setAttribute("nom", clientService.findById(idUser).getNom());
//				request.setAttribute("prenom", clientService.findById(idUser).getPrenom());
//				request.setAttribute("email", clientService.findById(idUser).getEmail());
//				request.setAttribute("naissance", clientService.findById(idUser).getNaissance());
////				this.getServletContext().getRequestDispatcher("/WEB-INF/views/users/create.jsp").forward(request, response);
//				
//				response.sendRedirect("/rentmanager/users/modify?id=${idUser}");
//				}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() throws ServletException {
	super.init();
	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
}

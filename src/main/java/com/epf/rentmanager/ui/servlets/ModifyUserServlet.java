package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/users/modify")
public class ModifyUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	ClientService clientService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getQueryString().substring(3));
		try {
			request.setAttribute("nom", clientService.findById(id).getNom());
			request.setAttribute("prenom", clientService.findById(id).getPrenom());
			request.setAttribute("email", clientService.findById(id).getEmail());
			request.setAttribute("naissance", clientService.findById(id).getNaissance());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/users/modify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// traitement du formulaire (appel à la méthode de sauvegarde)

		try {
			Integer id = Integer.valueOf(request.getQueryString().substring(3));
			clientService.delete(id);
			String nom = request.getParameter("last_name");
			String prenom = request.getParameter("first_name");
			String email = request.getParameter("email");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String naissance = request.getParameter("naissance");
			LocalDate dateNaissance = LocalDate.parse(naissance, formatter);
			Client client = new Client(nom, prenom, email, dateNaissance);
			this.clientService.create(client);
			response.sendRedirect("/rentmanager/users");
//			this.getServletContext().getRequestDispatcher("/WEB-INF/views/users/modify.jsp").forward(request, response);
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
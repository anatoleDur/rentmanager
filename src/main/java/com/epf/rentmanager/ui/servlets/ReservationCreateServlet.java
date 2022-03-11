package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.ReservationInfos;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/rents/create")
public class ReservationCreateServlet extends HttpServlet {
		
	@Autowired
	ReservationService reservationService;
	@Autowired
	VehicleService vehicleService;
	@Autowired
	ClientService clientService;

	private static final long serialVersionId = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("vehicles", this.vehicleService.findAll());
			request.setAttribute("clients", this.clientService.findAll());
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/rents/create.jsp").forward(request,
					response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// traitement du formulaire (appel à la méthode de sauvegarde)
		
		try {
			int idVehicle=Integer.parseInt(request.getParameter("car"));
			int idClient=Integer.parseInt(request.getParameter("client"));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String debut=request.getParameter("begin");
			String fin=request.getParameter("end");
			LocalDate dateDebut = LocalDate.parse(debut, formatter);
			LocalDate dateFin = LocalDate.parse(fin, formatter);
			Reservation reservation=new Reservation(idVehicle,idClient,dateDebut,dateFin);
			this.reservationService.create(reservation);
			this.doGet(request, response);
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

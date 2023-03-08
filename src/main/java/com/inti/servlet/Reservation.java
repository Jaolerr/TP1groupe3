package com.inti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.inti.model.Client;
import com.inti.model.Vol;
import com.inti.util.HibernateUtil;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session s;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		s=HibernateUtil.getSessionFactory().openSession();
		int idVol=Integer.valueOf(request.getParameter("idV")) ;
		int idClient=Integer.valueOf(request.getParameter("idC"));
		System.out.println(idVol);
		Client client = s.get(Client.class, idClient);
		Vol vol = s.get(Vol.class, idVol);
		
		request.getSession().setAttribute("Client", client);
		request.getSession().setAttribute("vol", vol);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Reservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		com.inti.model.Reservation reserv = new com.inti.model.Reservation();
		reserv.setVol((Vol)request.getSession().getAttribute("vol"));
		reserv.setClient((Client)request.getSession().getAttribute("Client"));
		s.save(reserv);
		
	}

}

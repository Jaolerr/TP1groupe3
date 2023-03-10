package com.inti.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.inti.model.Vol;
import com.inti.util.HibernateUtil;

/**
 * Servlet implementation class ServletVol
 */
@WebServlet("/ServletVol")
public class ServletVol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session s; 
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		s=HibernateUtil.getSessionFactory().openSession();
		System.out.println( s.createQuery("from Vol",Vol.class).list());
		
		
		System.out.println("hello");
		
		//System.out.println(Lvol);
		request.setAttribute("listeVol", s.createQuery("from Vol",Vol.class).list());
		request.setAttribute("idClient" , 1);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageVol.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

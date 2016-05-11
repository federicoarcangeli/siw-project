package it.uniroma3.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DescrizionePiattoController
 */
@WebServlet("/ProcessaDescrizionePiatto")
public class DescrizionePiattoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DescrizionePiattoController() {
        
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DescrizionePiattoHelper helper = new DescrizionePiattoHelper();
		DescrizionePiattoAction action = new DescrizionePiattoAction();
		String nextPage = "/inserimentoPiatti.jsp";
		if(helper.validate(request)) {
			nextPage = action.execute(request);
		}
		nextPage = response.encodeURL(nextPage);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}

package fr.imie.cours;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet extends javax.servlet.http.HttpServlet {

	@EJB
	private HelloLocal ejb;

	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		response.getOutputStream().print(ejb.hello());
	}

}

package fr.imie.cours.contact;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {

	private static final long serialVersionUID = -7675986528804174535L;

	private static final String VIEW = "/person.jsp";

	private DAO<Person> dao = Factory.getInstance().getPersonDAO();

	private void select(Person data, HttpServletRequest request) {
		data = dao.findOne(data);
		request.setAttribute("data", data);
	}

	private void save(Person data) {
		if (data.getId() == null) {
			dao.insert(data);
		} else {
			dao.update(data);
		}
	}

	private void delete(Person data) {
		dao.delete(data);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if (path == null) {
		} else if (path.matches("/save.*") || request.getMethod().matches("POST|PUT")) {
			save(data(request));
		} else if (path.matches("/delete.*") || request.getMethod().matches("DELETE")) {
			delete(data(request));
		} else if (path.matches("/select.*")) {
			select(data(request), request);
		}
		request.setAttribute("list", dao.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	private Person data(HttpServletRequest request) {
		Person person = new Person();
		person.setFirstName(request.getParameter("firstName"));
		person.setLastName(request.getParameter("lastName"));
		if (request.getParameter("id") != null && request.getParameter("id").isEmpty() == false) {
			person.setId(Integer.parseInt(request.getParameter("id")));
		}
		return person;
	}

}

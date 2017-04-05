package fr.imie.cours;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet extends javax.servlet.http.HttpServlet {

	private HelloRemote ejb;

	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		try {
			Properties p = new Properties();
			p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
			p.put("java.naming.provider.url", "http://localhost:8080/tomee/ejb");
			InitialContext ctx = new InitialContext(p);
			ejb = (HelloRemote) ctx.lookup("HelloEJBRemote");
			response.getOutputStream().print(ejb.hello());
		} catch (Exception ex) {
			ex.printStackTrace(new PrintStream(response.getOutputStream()));
		}
	}

}

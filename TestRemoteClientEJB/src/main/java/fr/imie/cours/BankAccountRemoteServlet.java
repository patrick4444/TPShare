package fr.imie.cours;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bank")
public class BankAccountRemoteServlet extends HttpServlet {

	private static final long serialVersionUID = -8772725883947500861L;

	private BankAccountRemote ejbBankAccount;

	// // @PostConstruct
	// public void initEJB() {
	// }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		try {
			Properties p = new Properties();

			// TOMEE
			p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
			p.put("java.naming.provider.url", "http://localhost:8080/tomee/ejb");

			// WILDFLY
			// p.put(Context.INITIAL_CONTEXT_FACTORY,
			// "org.jboss.naming.remote.client.InitialContextFactory");
			// p.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

			InitialContext ctx = new InitialContext(p);

			// for (NameClassPair pair : Collections.list(ctx.list(""))) {
			// out.println(pair.getName());
			// out.println(pair.getClassName());
			// }

			// TOMEE
			ejbBankAccount = (BankAccountRemote) ctx.lookup("BankAccountEJBRemote");

			// WILDFLY
			// ejbBankAccount = (BankAccountRemote)
			// ctx.lookup("ejb:/TestRemoteServerEJB/BankAccountEJB!fr.imie.cours.BankAccountRemote");

			ejbBankAccount.transfer(BigDecimal.valueOf(100), 1, 2);
			System.out.println("EJB OK");
		} catch (Exception ex) {
			ex.printStackTrace(new PrintStream(out));
		}
	}
}

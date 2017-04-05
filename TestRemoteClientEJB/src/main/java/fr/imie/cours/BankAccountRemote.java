package fr.imie.cours;

import javax.ejb.Remote;
import java.math.BigDecimal;

@Remote
public interface BankAccountRemote {

	public void transfer(BigDecimal amount, Integer a, Integer b);

}

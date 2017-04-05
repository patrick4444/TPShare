package fr.imie.cours;

import javax.ejb.Local;
import java.math.BigDecimal;

@Local
public interface BankAccountLocal {

	public void transfer(BigDecimal amount, Integer a, Integer b);

}

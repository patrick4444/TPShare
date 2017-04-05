package fr.imie.cours;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class HelloEJB implements HelloLocal, HelloRemote {

    public String hello() {
        return "Hello World" ;
    }

    public String hello2(){
        return "2";
    }

}

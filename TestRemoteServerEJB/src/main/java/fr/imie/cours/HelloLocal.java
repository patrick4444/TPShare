package fr.imie.cours;

import javax.ejb.Local;

@Local
public interface HelloLocal {

    public String hello();

    public String hello2() ;

}

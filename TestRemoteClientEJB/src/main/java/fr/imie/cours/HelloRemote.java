package fr.imie.cours;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {

    public String hello();

}

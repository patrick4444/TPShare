package fr.imie.cours;

import java.io.IOException;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/tuto")
public class TutoWebSocket {

	@OnOpen
	public void onOpen(Session session) {
		System.out.println(session.getId());
		try {
			String string = Json.createObjectBuilder()
					.add("c", 50)
					.add("d", "test")
					.build().toString();
			session.getBasicRemote().sendText(string);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println(session.getId());
	}

	@OnMessage
	public void onMessage(String message) {
		System.out.println(message);
		JsonObject json = Json.createReader(new StringReader(message)).readObject();
		System.out.println(json.getInt("a"));
		System.out.println(json.getString("b"));
	}

}

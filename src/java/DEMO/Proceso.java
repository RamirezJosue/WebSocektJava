package DEMO;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/proceso")

public class Proceso {
    
    /*
    * OnOpen Nos permite interceptar la creacion de una sesion 
    * La clase de sesion nos permite enviar los datos al usuario
    */
    
   
    @OnOpen
    public void onOpen( Session session){
        System.out.println(session.getId() + " ha abierto una conexion");
        try{
            session.getBasicRemote().sendText("Conexion establicida");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    /*
    * Cuando un usuario envia un mensaje al servidor, este metodo interceptar el mensaje
    */
    
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("Mensaje " + session.getId() + "" + message );
        try{
            session.getBasicRemote().sendText(message);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    @OnClose
    public void onClose (Session session){
        System.out.println("Sesion " + session.getId() + " ha terminado");
    }
    
    
}

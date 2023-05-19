/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat_application.service;


import chat_application.event.EventHandler;
import chat_application.model.Recive_Message;
import chat_application.model.User_Account;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mikołaj
 */
public class Service {

    private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 9999;
    private final String IP = "localhost";
    private User_Account user;

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
    }

    public void startServer() {
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //  list user
                    List<User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        User_Account u = new User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                        }
                    }
                    EventHandler.getInstance().getEventMenuLeft().newUser(users);
                }
            });
             client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    int userID = (Integer) os[0];
                    boolean status = (Boolean) os[1];
                    if (status) {
                        //  connect
                        EventHandler.getInstance().getEventMenuLeft().userConnect(userID);
                    } else {
                        //  disconnect
                        EventHandler.getInstance().getEventMenuLeft().userDisconnect(userID);
                    }
                }
            });
             client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    Recive_Message message = new Recive_Message(os[0]);
                    EventHandler.getInstance().getEventChat().receiveMessage(message);
                }
            });
            client.open();
        } catch (URISyntaxException e) {
            error(e);
        }
    }

    public Socket getClient() {
        return client;
    }
    public User_Account getUser() {
        return user;
    }

    public void setUser(User_Account user) {
        this.user = user;
    }

    private void error(Exception e) {
        System.err.println(e);
    }
}
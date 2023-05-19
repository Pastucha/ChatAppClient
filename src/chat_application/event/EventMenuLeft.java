/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package chat_application.event;

import chat_application.model.User_Account;
import java.util.List;

/**
 *
 * @author Mikołaj
 */
public interface EventMenuLeft {
    public void newUser(List<User_Account> users);
    public void userConnect(int userID);
    public void userDisconnect(int userID);
}

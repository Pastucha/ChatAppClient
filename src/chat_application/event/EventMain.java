/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package chat_application.event;

import chat_application.model.User_Account;

/**
 *
 * @author Mikołaj
 */
public interface EventMain {
    public void initChat();
    
    public void selectUser(User_Account user);

    public void updateUser(User_Account user);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package chat_application.event;

import chat_application.model.Recive_Message;
import chat_application.model.Send_Message;

/**
 *
 * @author Mikołaj
 */
public interface EventChat {
     public void sendMessage(Send_Message data);

    public void receiveMessage(Recive_Message data);
}

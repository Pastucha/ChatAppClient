/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package chat_application.event;

import chat_application.model.Message;

/**
 *
 * @author Mikołaj
 */
public interface EventMessage {
    public void callMessage(Message message);
}

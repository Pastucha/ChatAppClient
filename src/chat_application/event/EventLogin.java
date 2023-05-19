/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package chat_application.event;

import chat_application.model.Login;
import chat_application.model.Register;

/**
 *
 * @author Mikołaj
 */
public interface EventLogin {
    public void login(Login data);

    public void register(Register data,EventMessage message);

    public void goRegister();

    public void goLogin();
}

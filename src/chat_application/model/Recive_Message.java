/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat_application.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Recive_Message {

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Recive_Message(int fromUserID, String text) {
        this.fromUserID = fromUserID;
        this.text = text;
    }

    public Recive_Message(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            fromUserID = obj.getInt("fromUserID");
            text = obj.getString("text");
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

    private int fromUserID;
    private String text;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fromUserID", fromUserID);
            json.put("text", text);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}

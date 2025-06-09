package com.tcs.soap_client_simulation.model;


public class MessaggeStringXml {

    private String messaggeBody;

    public MessaggeStringXml() {
        // Constructor vacío requerido para deserialización
    }

    public MessaggeStringXml(String messaggeBody) {
        this.messaggeBody = messaggeBody;
    }

    public String getMessaggeBody() {
        return messaggeBody;
    }

    public void setMessaggeBody(String messaggeBody) {
        this.messaggeBody = messaggeBody;
    }
}

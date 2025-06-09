package com.tcs.soap_client_simulation.controller;


import com.tcs.soap_client_simulation.model.MessaggeStringXml;
import com.tcs.soap_client_simulation.service.MessageStringXMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class MessageStringXMLController {

    @Autowired
    private final MessageStringXMLService messageStringXMLService;

    public MessageStringXMLController(MessageStringXMLService messageStringXMLService){
        this.messageStringXMLService = messageStringXMLService;
    }

    @PostMapping("soap-receiver")
    public void recieveMessage(@RequestBody MessaggeStringXml messaggeStringXML){
        messageStringXMLService.processMessage(messaggeStringXML);
    }
}

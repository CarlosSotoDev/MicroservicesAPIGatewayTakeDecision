package com.tcs.xml_deserializer.controller;

import com.netflix.discovery.converters.Auto;
import com.tcs.xml_deserializer.model.Transaction;
import com.tcs.xml_deserializer.service.XmlDeserializerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
@Slf4j
public class XmlDeserializerController {

    private final XmlDeserializerService deserializerService;

    @Autowired
    public XmlDeserializerController(XmlDeserializerService deserializerService){
        this.deserializerService = deserializerService;
    }

    @PostMapping("/receive")
    public ResponseEntity<String> receiveXml(@RequestBody String rawXml){
        try{
            Transaction transaction = deserializerService.deserializeXml(rawXml);
            log.info("Transaction Received: " + transaction.getTransactionId());
            return ResponseEntity.ok("XML DESERIALIZED SUCCESFULL");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR WAS OCURRED TRYING TO DESERIALIZE");
        }
    }
}

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
@RequestMapping("/receive")
@Slf4j
public class XmlDeserializerController {

    private final XmlDeserializerService deserializerService;

    @Autowired
    public XmlDeserializerController(XmlDeserializerService deserializerService){
        this.deserializerService = deserializerService;
    }

    @PostMapping
    public ResponseEntity<String> receiveXml(@RequestBody String rawXml){
        log.info("✅ XML recibido por xml-deserializer:");
        log.info(rawXml);  // Esto mostrará el XML crudo recibido

        try {
            Transaction transaction = deserializerService.deserializeXml(rawXml);
            log.info("🧾 Transacción procesada: ID = {}", transaction.getTransactionId());
            return ResponseEntity.ok("XML DESERIALIZED SUCCESSFULLY");
        } catch (Exception e) {
            log.error("❌ Error al deserializar XML: {}", e.getMessage());
            return ResponseEntity.badRequest().body("ERROR WHILE DESERIALIZING XML");
        }
    }
}

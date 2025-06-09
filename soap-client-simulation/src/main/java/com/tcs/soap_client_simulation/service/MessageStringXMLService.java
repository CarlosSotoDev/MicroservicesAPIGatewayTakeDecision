package com.tcs.soap_client_simulation.service;

import com.tcs.soap_client_simulation.model.MessaggeStringXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageStringXMLService {


    //Slf4j
    private static final Logger logger = LoggerFactory.getLogger(MessageStringXMLService.class);

    public void processMessage(MessaggeStringXml message) {
        // Obtener el cuerpo del mensaje
        String xml = message.getMessaggeBody();

        logger.info("Mensaje XML recibido y en espera: \n{}", xml);

        // Crear cliente RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Configurar headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        // Crear la solicitud
        HttpEntity<String> request = new HttpEntity<>(xml, headers);

        // Enviar al receptor en puerto 8083
        String endpoint = "http://localhost:8082/api/transaction/receive";

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(endpoint, request, String.class);
            logger.info("Respuesta del receptor XML: {}", response.getBody());
        } catch (Exception e) {
            logger.error("❌ Error al enviar XML al receptor: {}", e.getMessage());
        }
    }
}
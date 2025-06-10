package com.tcs.xml_deserializer.service;

import com.tcs.xml_deserializer.model.Transaction;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.StringReader;

@Service
public class XmlDeserializerService {

    public Transaction deserializeXml(String rawXml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Transaction.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Transaction) unmarshaller.unmarshal(new StringReader(rawXml));
    }
}

package com.tcs.xml_deserializer.service;

import com.tcs.xml_deserializer.model.Transaction;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.StringReader;

@Service
public class XmlDeserializerService {

    public Transaction deserializeXml(String rawXml) throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Transaction.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Transaction) unmarshaller.unmarshal(new StringReader(rawXml));
    }
}

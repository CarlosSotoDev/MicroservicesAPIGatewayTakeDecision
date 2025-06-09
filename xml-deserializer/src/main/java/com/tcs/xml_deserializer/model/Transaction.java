package com.tcs.xml_deserializer.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {
    private String transactionId;
    private String guid;

    private Payer payer;

    private BigDecimal amount;
    private String currency;

    private Beneficiary beneficiary;
    private String opcode;



}

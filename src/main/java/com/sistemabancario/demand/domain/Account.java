package com.sistemabancario.demand.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
public class Account {
    private String id;
    private String clientId;
    private String accountTypeId;
    private String nroCuenta;
    private Double saldo;
    private String representationId;
    private String documentNumber;
    private String phoneNumber;
    private String email;
    private String documentTypeId;
    private String cointypeId;
}

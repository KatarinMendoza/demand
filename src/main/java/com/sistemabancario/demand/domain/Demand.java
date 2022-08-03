package com.sistemabancario.demand.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document("demand")
public class Demand {
    @Id
    private String id;
    private String accountid;
    private Double mount;
    private String paymentmethod;
    private String cointtypeId;
    private String operationId;
    private String status;
}

package com.sistemabancario.demand.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRecord {
	private String id;
	private String accountId;
	private String operationTypeId;
	private Double amount;
	private Integer share;
	private Date payDate;
	private String cointypeId;
	private String pagemode;
}

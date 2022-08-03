package com.sistemabancario.demand.Service.impl;

import ch.qos.logback.core.net.server.Client;
import com.sistemabancario.demand.Service.IDemandService;
import com.sistemabancario.demand.domain.Account;
import com.sistemabancario.demand.domain.Demand;
import com.sistemabancario.demand.domain.TransactionRecord;
import com.sistemabancario.demand.repository.IDemandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.sql.rowset.spi.TransactionalWriter;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class DemandService implements IDemandService {

    @Autowired
    private final IDemandRepository demandRepository;


    @Override
    public Flux<Demand> findAll() {
        return demandRepository.findAll();
    }

    @Override
    public Mono<Demand> findById(String id) {
        return demandRepository.findById(id);
    }

    @Override
    public Mono<Demand> save(Demand demand) {
        return demandRepository.save(demand);
    }

    @Override
    public Mono<Demand> update(Demand demand) {
       if (generarTransaccion(demand) == false){
           return null;
       }
        return demandRepository.save(demand);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return demandRepository.deleteById(id);
    }

    private TransactionRecord transactionRecord;
    public Boolean generarTransaccion(Demand demand){
        RestTemplate temp=new RestTemplate();
        Account account=temp.getForObject("http://localhost:8090/transactionrecord/" + demand.getAccountid(),Account.class);
        if (demand.getMount() == 0 || demand.getPaymentmethod().isEmpty()
        || account.getPhoneNumber().isEmpty() || account.getNroCuenta().isEmpty()){
            System.out.println("Los datos no estan completos");
            return false;
        }else{
            transactionRecord.setAmount(demand.getMount());
            transactionRecord.setPagemode(demand.getPaymentmethod());
            transactionRecord.setCointypeId(demand.getCointtypeId());
            transactionRecord.setPayDate(new Date());
            transactionRecord.setAccountId(demand.getAccountid());
            transactionRecord.setOperationTypeId(demand.getOperationId());

        }
        transactionRecord = temp.getForObject("http://localhost:8090/transactionrecord/"+ transactionRecord,TransactionRecord.class);
        return true;

    }
}

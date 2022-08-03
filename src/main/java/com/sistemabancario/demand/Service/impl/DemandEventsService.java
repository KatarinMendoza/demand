package com.sistemabancario.demand.Service.impl;

import com.sistemabancario.demand.domain.Demand;
import com.sistemabancario.demand.events.DemandCreatedEvent;
import com.sistemabancario.demand.events.Event;
import com.sistemabancario.demand.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class DemandEventsService {
    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("@${topic.demand.name:demands}")
    private String topicTransaction;

    public void publish(Demand demand){
        DemandCreatedEvent created=new DemandCreatedEvent();
        created.setData(demand);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());
        this.producer.send(topicTransaction,created);
    }

    public  void Update(Demand demand){
        DemandCreatedEvent update=new DemandCreatedEvent();
        update.setData(demand);
        update.setId(UUID.randomUUID().toString());
        update.setType(EventType.UPDATED);
        update.setDate(new Date());
        this.producer.send(topicTransaction,update);
    }
}

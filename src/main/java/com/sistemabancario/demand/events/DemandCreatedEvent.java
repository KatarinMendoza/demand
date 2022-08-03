package com.sistemabancario.demand.events;

import com.sistemabancario.demand.domain.Demand;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DemandCreatedEvent extends Event<Demand>{
}

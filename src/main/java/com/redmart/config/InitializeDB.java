package com.redmart.config;


import com.redmart.tickets.entity.Ticket;
import com.redmart.tickets.repo.TicketsRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Configuration
@Order(2)
public class InitializeDB {

    @Inject
    private TicketsRepository ticketsRepository;

    @PostConstruct
    public void initalizeDB(){
        ticketsRepository.save(new Ticket("UnresolvedAddressException ","Apache","SUD","","New","UnresolvedAddressException cause the QuorumCnxManager.Listener exit"));
        ticketsRepository.save(new Ticket("Generic Shell Executor","BigTop","SUD","Roman","Open","Create a generic shell executor iTest driver"));
        ticketsRepository.save(new Ticket("Installation","Camel","Anonymous","Christian","Open","camel-hbase feature should install the avro bundle"));
        ticketsRepository.save(new Ticket("UDP Service","Apache","Jackub","","New","UDP server closes active session after 60"));
        ticketsRepository.save(new Ticket("Booking failure","Fly Dubai","SUD","Sachin","Open","Firefox users cannot make payments."));
        ticketsRepository.save(new Ticket("Slow network","Redmart","SUD","Sachin","Open","Application does not respond in intranet"));
        ticketsRepository.save(new Ticket("Namenode fails","Apache","KK","SUD","Closed","Namenode cannot recover from standby..."));
    }
}

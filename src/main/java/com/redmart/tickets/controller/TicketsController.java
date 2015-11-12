package com.redmart.tickets.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.redmart.tickets.entity.Ticket;
import com.redmart.tickets.repo.TicketsRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketsController {

    @Inject
    private TicketsRepository ticketsRepository;

    @GET
    @RequestMapping(value = "/all")
    @Produces("application/json")
    public List<Ticket> getTickets(){
        List<Ticket> tickets = new ArrayList<>();
        Iterable<Ticket> all = ticketsRepository.findAll();
        for (Ticket ticket : all){
            tickets.add(ticket);
        }
        return tickets;
    }


    @DELETE
    @RequestMapping(value = "/delete")
    @Produces("text/html")
    public @ResponseBody String delete(
            @RequestParam(value = "id", defaultValue = "-1") Long id){
        ticketsRepository.delete(id);
        return "{\"result\": \"SUCCESS\"}";
    }

    @PUT
    @RequestMapping(value = "/update")
    @Produces("text/html")
    public @ResponseBody String updateTicket(@RequestBody Ticket ticket){
        ticketsRepository.save(ticket);
        return "{\"result\": \"SUCCESS\"}";
    }

    @POST
    @RequestMapping(value = "/create")
    @Produces("application/json")
    public String createTicket(@RequestBody Ticket ticket){
        ticketsRepository.save(ticket);
        return "{\"result\": \"SUCCESS\"}";
    }
}

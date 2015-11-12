package com.redmart.tickets.repo;


import com.redmart.tickets.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketsRepository extends CrudRepository<Ticket, Long>{
    List<Ticket> findByStatus(String status);
    Ticket findById(Long id);
}

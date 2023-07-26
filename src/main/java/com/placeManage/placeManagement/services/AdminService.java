package com.placeManage.placeManagement.services;

import com.placeManage.placeManagement.entity.Ticket;
import com.placeManage.placeManagement.repository.PlaceRepository;
import com.placeManage.placeManagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService{
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    PlaceRepository placeRepository;

    @Override
    public void processTicket(long ticket_id) {
        Ticket ticket = ticketRepository.findById(ticket_id);
        ticket.getPlace().setUnprocessedTickets(ticket.getPlace().getUnprocessedTickets()-1);
        ticket.setProcessed(true);
        ticketRepository.save(ticket);
        placeRepository.save(ticket.getPlace());
    }
}

package com.placeManage.placeManagement.repository;

import com.placeManage.placeManagement.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
        Ticket findById(long id);
}

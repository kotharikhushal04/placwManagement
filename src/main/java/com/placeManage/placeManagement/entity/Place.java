package com.placeManage.placeManagement.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "place_id")
    private  String id;

    public Place(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "int default 0")
    private int unprocessedTickets;

    @Column(unique = true)
    private String prefix;

    @OneToMany(mappedBy = "place")
    private List<Ticket> tickets= new ArrayList<>();

    public Place(String id, String name, int unprocessedTickets, String prefix, List<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.unprocessedTickets = unprocessedTickets;
        this.prefix = prefix;
        this.tickets = tickets;
    }

    public Place() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnprocessedTickets() {
        return unprocessedTickets;
    }

    public void setUnprocessedTickets(int unprocessedTickets) {
        this.unprocessedTickets = unprocessedTickets;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unprocessedTickets=" + unprocessedTickets +
                ", prefix='" + prefix + '\'' +
                ", tickets=" + tickets +
                '}';
    }


}

package com.example.heroku.dtos;

import java.util.List;

public class TicketsDTO {

    private final List<CustomerTicketDTO> tickets;

    public TicketsDTO(List<CustomerTicketDTO> tickets) {
        this.tickets = tickets;
    }

    public List<CustomerTicketDTO> getTickets() {
        return tickets;
    }
}

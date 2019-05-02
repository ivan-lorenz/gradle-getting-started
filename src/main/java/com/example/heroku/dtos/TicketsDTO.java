package com.example.heroku.dtos;

import java.util.List;

public class TicketsDTO {

    private final List<TicketDTO> tickets;

    public TicketsDTO(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }
}

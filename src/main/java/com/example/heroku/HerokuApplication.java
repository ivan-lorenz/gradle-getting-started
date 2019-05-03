/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.heroku;

import com.example.heroku.dtos.*;
import com.example.heroku.entities.*;
import com.example.heroku.services.*;
import com.example.heroku.vms.BuyTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@SpringBootApplication
public class HerokuApplication {

  @Autowired
  private EventService eventService;

  @Autowired
  private TicketConfigService ticketConfigService;

  @Autowired
  private TicketService  ticketService;

  @Autowired
  private StoreService storeService;

  @Autowired
  private ProductService productService;

  public static void main(String[] args) throws Exception {
    SpringApplication.run(HerokuApplication.class, args);
  }


  @RequestMapping("/events/{cityCode}")
  ResponseEntity events(@PathVariable String cityCode) {
    List<Event> events = eventService.findByCityCode(cityCode);
    return ok(new EventsDTO(convertEventDTOs(events)));
  }

  private List<EventDTO> convertEventDTOs(List<Event> events) {
    return events.stream()
            .map(event -> {

              List<TicketConfig> ticketConfigs = ticketConfigService.findByEventId(event.getId());

              List<TicketConfigDTO> ticketConfigDTOS = ticketConfigs.stream().map(ticketConfig -> {
                long soldTickets = ticketService.countByTicketConfig(event.getId(), ticketConfig.getType());
                long totalTickets = ticketConfig.getQuantity();
                return new TicketConfigDTO(ticketConfig.getId(),
                        ticketConfig.getType(),
                        PriceCurreny.convertToEuros(ticketConfig.getPrice()),
                        totalTickets - soldTickets);

              }).collect(Collectors.toList());

              return new EventDTO(event.getId(),
                      event.getName(),
                      event.getStart(),
                      event.getCategory(),
                      VenueDTO.from(event.getVenue(), null),
                      ticketConfigDTOS,
                      event.getUrlImage(),
                      event.getDescription());

            }).collect(Collectors.toList());
  }

  @RequestMapping(value = "/events/{event_id}/tickets", method = RequestMethod.POST)
  ResponseEntity buyTicket(@PathVariable("event_id") long eventId, @RequestBody BuyTicket buyTicket) {

    Ticket ticket = ticketService.createTicket(buyTicket.getCustomerId(), eventId, buyTicket.getType());

    TicketDTO ticketDTO = new TicketDTO(ticket.getId(), "ES","EUR", 100.0);

    return ok(ticketDTO);
  }


  @RequestMapping("/tickets/{customerId}")
  ResponseEntity events(@PathVariable("customerId") long customerId) {
    List<Ticket> tickets = ticketService.findByCustomerId(customerId);

    List<CustomerTicketDTO> customerTicketDTO = tickets.stream().map(
            ticket -> {

                List<Store> stores = storeService.findByVenueId(ticket.getEvent().getVenue().getId());

                return new CustomerTicketDTO(
                        ticket.getId(),
                        EventDTO.from(ticket.getEvent()),
                        ticket.getSeat(), ticket.getQrUrl(),
                        ticket.getSeatZoneUrl(),
                        stores.stream().map(StoreDTO::from).collect(Collectors.toList()));
            }
    ).collect(Collectors.toList());

    return ok(new TicketsDTO(customerTicketDTO));
  }


  @RequestMapping("/venue/{venueId}/stores")
  ResponseEntity stores(@PathVariable("venueId") long venueId) {
    List<Store> stores = storeService.findByVenueId(venueId);


    List<StoreDTO> collect = stores.stream().map(store -> {
              List<Product> productsToStore = productService.findByStoreId(store.getId());
              List<ProductDTO> productDTOs = productsToStore.stream()
                      .map(product -> new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getUrlImage()))
                      .collect(Collectors.toList());

              return new StoreDTO(store.getId(), store.getName(), store.getZoneId(), store.getUrlImage(), productDTOs);

            }
    ).collect(Collectors.toList());
    return ok(collect);
  }

}

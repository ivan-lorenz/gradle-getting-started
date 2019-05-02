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

import com.example.heroku.dtos.EventDTO;
import com.example.heroku.dtos.EventsDTO;
import com.example.heroku.dtos.TicketConfigDTO;
import com.example.heroku.dtos.VenueDTO;
import com.example.heroku.entities.Event;
import com.example.heroku.entities.PriceCurreny;
import com.example.heroku.entities.TicketConfig;
import com.example.heroku.services.EventService;
import com.example.heroku.services.TicketConfigService;
import com.example.heroku.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                      VenueDTO.from(event.getVenue()),
                      ticketConfigDTOS
                      );

            }).collect(Collectors.toList());
  }

  @RequestMapping(value = "/events/{event_id}/tickets", method = RequestMethod.POST)
  ResponseEntity events(@PathVariable int eventId) {
    return null;
  }


}

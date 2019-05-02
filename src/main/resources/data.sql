
insert into venue (id, name, city_code, address) values(1, 'Barcelona FC', 'BCN', 'Barcelona FC address');
insert into venue (id, name, city_code, address) values(2, 'Madrid FC', 'MAD', 'Madrid FC address');

insert into event (id, name, description, venue_id, start, category) values(3, 'La Liga game', 'Barcelona football game', 1, ' 2019-01-01 21:00:00','FOOTBALL_MATCH');
insert into event (id, name, description, venue_id, start, category) values(4, 'La Liga game', 'Madrid football game', 2, ' 2019-01-02 22:00:00','FOOTBALL_MATCH');

insert into ticket_config (id, type, price, quantity, event_id) values(5, 'VIP', 100, 1000, 3);
insert into ticket_config (id, type, price, quantity, event_id) values(6, 'NORMAL', 50, 2000, 3);


insert into ticket (id, type, customer_id, event_id) values(7, 'NORMAL', 1234, 3);

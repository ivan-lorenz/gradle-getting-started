
insert into venue (id, name, city_code) values(1, 'Barcelona FC', 'BCN');
insert into venue (id, name, city_code) values(2, 'Madrid FC', 'MAD');

insert into event (id, name, description, venue_id) values(3, 'La Liga game', 'Barcelona football game', 1);
insert into event (id, name, description, venue_id) values(4, 'La Liga game', 'Madrid football game', 2);

insert into ticket (id, type, price, event_id) values(5, 'VIP', 100, 3);
insert into ticket (id, type, price, event_id) values(6, 'NORMAL', 50, 3);
insert into ticket (id, type, price, event_id) values(7, 'NORMAL', 50, 3);




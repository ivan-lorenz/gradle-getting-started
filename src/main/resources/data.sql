
insert into venue (id, name, city_code, address) values(1, 'Barcelona FC', 'BCN', 'Barcelona FC address');
insert into venue (id, name, city_code, address) values(2, 'Madrid FC', 'MAD', 'Madrid FC address');

insert into event (id, name, description, venue_id, start, category, url_image) values(3, 'La Liga game', 'Barcelona football game', 1, ' 2019-01-01 21:00:00','FOOTBALL_MATCH','https://image.shutterstock.com/image-photo/barcelona-january-25-panoramic-view-450w-93599314.jpg');
insert into event (id, name, description, venue_id, start, category, url_image) values(4, 'La Liga game', 'Madrid football game', 2, ' 2019-01-02 22:00:00','FOOTBALL_MATCH', 'https://images-na.ssl-images-amazon.com/images/I/61BWocKFkeL._SX425_.jpg');

insert into ticket_config (id, type, price, quantity, event_id) values(5, 'VIP', 100, 1000, 3);
insert into ticket_config (id, type, price, quantity, event_id) values(6, 'NORMAL', 50, 2000, 3);


insert into ticket (id, type, customer_id, event_id) values(7, 'NORMAL', 1234, 3);

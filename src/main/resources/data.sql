
insert into venue (id, name, city_code, address) values(1, 'Barcelona FC', 'BCN', 'Barcelona FC address');

insert into event (id, name, description, venue_id, start, category, url_image) values(2, 'La Liga game', 'Reus vs. Getafe', 1, ' 2019-01-01 21:00:00','FOOTBALL_MATCH','http://files.proyectoclubes.com/oviedo/201811/662x372a_19123750real-oviedo-real-sporting_215.jpg');
insert into event (id, name, description, venue_id, start, category, url_image) values(3, 'La Liga game', 'Madrid football game', 1, ' 2019-01-02 22:00:00','FOOTBALL_MATCH', 'https://images-na.ssl-images-amazon.com/images/I/61BWocKFkeL._SX425_.jpg');

insert into ticket_config (id, type, price, quantity, event_id) values(4, 'VIP', 100, 1000, 2);
insert into ticket_config (id, type, price, quantity, event_id) values(5, 'NORMAL', 50, 1, 2);

insert into ticket_config (id, type, price, quantity, event_id) values(6, 'VIP', 100, 2000, 3);
insert into ticket_config (id, type, price, quantity, event_id) values(7, 'NORMAL', 50, 3000, 3);

insert into ticket (id, type, customer_id, event_id, seat_zone_url) values(8, 'NORMAL', 1234, 2, 'https://i.ibb.co/nc50Fb9/Screenshot-2019-05-03-at-05-08-29.png');

insert into store (id, name, zone_id, venue_id, url_image) values(9, 'McDonald''s', '4D', 1, 'https://www.ishn.com/ext/resources/Issues/2016/September/columns/ISHN_0916_C1_pic.jpg?1472749174');
insert into store (id, name, zone_id, venue_id, url_image) values(10, 'Kings', '5D', 1, 'https://pbs.twimg.com/profile_images/2094778704/Kings_Logo_CMYK__1_.jpg');
insert into store (id, name, zone_id, venue_id, url_image) values(11, 'Queens', '5D', 1, 'https://images.deliveryhero.io/image/talabat/restaurants/Queens_Eng_635525259720865559.jpg');

insert into product (id, name, price, store_id, url_image) values(12, 'Burger', 10, 9,'https://res.cloudinary.com/hksqkdlah/image/upload/s--or4BUPPr--/c_scale,dpr_2.0,f_auto,h_344,q_auto:low,w_344/24811_sfs-black-bean-burger-50');
insert into product (id, name, price, store_id, url_image) values(13, 'Coca-cola', 5, 9, 'https://images-na.ssl-images-amazon.com/images/I/81mEIp4PMBL._SL1500_.jpg');
insert into product (id, name, price, store_id, url_image) values(14, 'Fish&Chips', 20, 10, 'https://d3cizcpymoenau.cloudfront.net/images/37243/SFS_Fish_and_Chips-35.jpg');
insert into product (id, name, price, store_id, url_image) values(15, 'Salad', 10, 11, 'https://www.tasteofhome.com/wp-content/uploads/2017/10/exps6498_MRR133247D07_30_5b_WEB-2.jpg');
insert into product (id, name, price, store_id, url_image) values(16, 'Water', 5, 11,'https://slowdancejournal.files.wordpress.com/2015/11/plastic-water-bottle.jpg');

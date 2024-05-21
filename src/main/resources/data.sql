insert into address (id, street, postcode, city, country) values 
(1, 'Main Street', '12345', 'London', 'UK'),
(2, 'Second Street', '54321', 'Paris', 'France');

insert into client (id, first_name, last_name, telephone, address_id) values 
(1, 'Jonh', 'Doe', '123456789', 1),
(2, 'Jane', 'Doe', '987654321', 2);

insert into customer_order (id, number, is_delivery, pilotes, order_total, client_id, order_date) values 
(1, '123', true, 5, 6.65, 1, '2020-01-01 10:00:00'),
(2, '456', false, 10, 13.3, 2, '2020-01-02 11:00:00');


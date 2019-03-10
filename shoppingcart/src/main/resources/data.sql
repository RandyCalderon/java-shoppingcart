INSERT INTO user(userid, username, password, role, firstname, middlename, lastname, phonenumber, email, street, city, zip, state, country, unit_number)
VALUES (1, 'thumpthump', 'password', 'USER', 'Randy', null, 'Calderon', '901-333-2014', 'tm@gmail.com', '6333 Brick Avenue', 'Burbank', 91606, 'CA',  'USA', null),
       (2, 'jimmyj', 'password', 'USER', 'Jimmy', 'Alex', 'Sanders', '802-345-1930', 'jtry@gmail.com', '1020 Bermuda Road', 'Houston', 70129, 'TX', 'USA', null),
       (3, 'metax', 'password', 'USER', 'Rob', null, 'Robinson', '740-232-3890', 'metax@gmail.com', '8327 Jersey Lane', 'Newport', 008859, 'NJ', 'USA', null);

INSERT INTO supplier(supplierid,suppliername,productname,quantity)
VALUES (1, 'Kibbles Inc','Kibbles n Bits', 400),
       (2, 'Purina Inc', 'Purina One SmartBlend', 300),
       (3, 'Chapstick Inc', 'Chapstick Moisturizing Lip Balm 3ct', 1000),
       (4, 'Pop Secret Inc', 'Pop Secret Premium Popcorn 30ct', 700);

INSERT INTO product(productid, productname, description, quantity, price)
VALUES (1, 'Product 1', 'Number 1', 30, 24.99),
       (2, 'Product 2', 'Number 2', 15, 32.99),
       (3, 'Product 3', 'Number 3', 40, 2.99),
       (4, 'Product 4', 'Number 4', 25, 12.99),
       (5, 'Product 5', 'Number 5', 20, 10.99),
       (6, 'Product 6', 'Number 6', 20, 10.99),
       (7, 'Product 7', 'Number 7', 20, 10.99),
       (8, 'Product 8', 'Number 8', 20, 10.99),
       (9, 'Product 9', 'Number 9', 20, 10.99),
       (10, 'Product 10', 'Number 10', 20, 10.99),
       (11, 'Product 11', 'Number 11', 20, 10.99),
       (12, 'Product 12', 'Number 12', 20, 10.99),
       (13, 'Product 13', 'Number 13', 20, 10.99),
       (14, 'Product 14', 'Number 14', 20, 10.99),
       (15, 'Product 15', 'Number 15', 20, 10.99),
       (16, 'Product 16', 'Number 16', 20, 10.99),
       (17, 'Product 17', 'Number 17', 20, 10.99),
       (18, 'Product 18', 'Number 18', 20, 10.99),
       (19, 'Product 19', 'Number 19', 20, 10.99),
       (20, 'Product 20', 'Number 20', 20, 10.99),
       (21, 'Product 21', 'Number 21', 20, 10.99),
       (22, 'Product 22', 'Number 22', 20, 10.99),
       (23, 'Product 23', 'Number 23', 20, 10.99),
       (24, 'Product 24', 'Number 24', 20, 10.99),
       (25, 'Product 25', 'Number 25', 20, 10.99),
       (26, 'Product 26', 'Number 26', 20, 10.99),
       (27, 'Product 27', 'Number 27', 20, 10.99),
       (28, 'Product 28', 'Number 28', 20, 10.99),
       (29, 'Product 29', 'Number 29', 20, 10.99),
       (30, 'Product 30', 'Number 30', 20, 10.99),
       (31, 'Product 31', 'Number 31', 20, 10.99),
       (32, 'Product 32', 'Number 32', 20, 10.99),
       (33, 'Product 33', 'Number 33', 20, 10.99),
       (34, 'Product 34', 'Number 34', 20, 10.99),
       (35, 'Product 35', 'Number 35', 20, 10.99),
       (36, 'Product 36', 'Number 36', 20, 10.99),
       (37, 'Product 37', 'Number 37', 20, 10.99),
       (38, 'Product 38', 'Number 38', 20, 10.99),
       (39, 'Product 39', 'Number 39', 20, 10.99),
       (40, 'Product 40', 'Number 40', 20, 10.99),
       (41, 'Product 41', 'Number 41', 20, 10.99),
       (42, 'Product 42', 'Number 42', 20, 10.99),
       (43, 'Product 43', 'Number 43', 20, 10.99),
       (44, 'Product 44', 'Number 44', 20, 10.99),
       (45, 'Product 45', 'Number 45', 20, 10.99),
       (46, 'Product 46', 'Number 46', 20, 10.99),
       (47, 'Product 47', 'Number 47', 20, 10.99),
       (48, 'Product 48', 'Number 48', 20, 10.99),
       (49, 'Product 49', 'Number 49', 20, 10.99),
       (50, 'Product 50', 'Number 50', 20, 10.99);


INSERT INTO orders(orderid, userid, productname, quantity, productid)
VALUES (1, 1,'Chapstick Moisturizing Lip Balm 3ct', 2, 3),
       (2, 3,'Pop Secret Premium Popcorn 30ct', 3, 4),
       (3, 2,'Purina One SmartBlend', 5, 2),
       (4, 3,'Kibbles n Bits', 8, 1);

INSERT INTO supplier_products(productid, supplierid)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);

-- INSERT INTO cart(userid, productid, quantity)

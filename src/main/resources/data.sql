MERGE INTO `dealer` (id, name) VALUES
(1, 'Big Al Ford'),
(2, 'Franks Autos'),
(3, 'Shady Petes');


MERGE INTO `car` (id, dealer, msrp, color, make, model)  VALUES
(1, 1, 18000.00, 'Brown', 'Ford', 'Probe'),
(2, 1, 30000.00, 'Blue', 'Ford', 'F150'),
(3, 1, 22000.00, 'Black', 'Ford', 'Focus'),
(4, 1, 40000.00, 'Black', 'Ford', 'Mustang'),
(5, 2, 18999.99, 'Brown', 'Toyota', 'Corolla'),
(6, 2, 26187.00, 'Blue', 'Lexus', 'IS 250'),
(7, 2, 24475.00, 'Red', 'Mazda', 'Mazda 6'),
(8, 2, 23800.00, 'Black', 'Chevy', 'Equinox'),
(9, 3, 7999.00, 'Yellow', 'Yugo', 'GV'),
(10, 3, 3000.00, 'White', 'Pontiac', 'Aztek'),
(11, 3, 2000.00, 'Black', 'Ford', 'Pinto'),
(12, 3, 1500.00, 'Blue', 'Geo', 'Metro');


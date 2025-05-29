-- 1ro Configurar usuario root password mariapass --
-- 2do Crear la base de datos tallerJava --


use tallerJava;
INSERT INTO comercio_cuenta_banco_cliente (numero, saldo) VALUES (1001, 50000.00);
INSERT INTO comercio_cuenta_banco_cliente (numero, saldo) VALUES (1002, 30000.00);
INSERT INTO comercio_cuenta_banco_cliente (numero, saldo) VALUES (1003, 15000.00);

INSERT INTO comercio_tarjeta (numero, marca, localDate, cuenta_cliente_id) VALUES (123456, 'Visa', '2023-05-10', 1001);
INSERT INTO comercio_tarjeta (numero, marca, localDate, cuenta_cliente_id) VALUES (789012, 'MasterCard', '2024-01-15', 1002);
INSERT INTO comercio_tarjeta (numero, marca, localDate, cuenta_cliente_id) VALUES (345678, 'Amex', '2022-12-01', 1003);

INSERT INTO comercio_pos (id, activo) VALUES (1, true);
INSERT INTO comercio_pos (id, activo) VALUES (2, false);
INSERT INTO comercio_pos (id, activo) VALUES (3, true);

INSERT INTO comercio_cuenta_banco_comercio (nroCuenta) VALUES (2001);
INSERT INTO comercio_cuenta_banco_comercio (nroCuenta) VALUES (2002);
INSERT INTO comercio_cuenta_banco_comercio (nroCuenta) VALUES (2003);

INSERT INTO comercio_deposito (cuenta_id, fecha, importe) VALUES (2001, '2024-01-01', 10000.00);
INSERT INTO comercio_deposito (cuenta_id, fecha, importe) VALUES (2002, '2024-02-15', 15000.00);
INSERT INTO comercio_deposito (cuenta_id, fecha, importe) VALUES (2003, '2024-03-10', 20000.00);

INSERT INTO comercio_comercio (rut, cuenta_id, password) VALUES (11111111, 2001, 'pass123');
INSERT INTO comercio_comercio (rut, cuenta_id, password) VALUES (22222222, 2002, 'clave456');
INSERT INTO comercio_comercio (rut, cuenta_id, password) VALUES (33333333, 2003, 'secreta789');

INSERT INTO comercio_reclamos (comercio_id, reclamo, fecha) VALUES (1, 'No funcionó el POS', '2025-05-01');
INSERT INTO comercio_reclamos (comercio_id, reclamo, fecha) VALUES (2, 'Compra duplicada', '2025-05-10');
INSERT INTO comercio_reclamos (comercio_id, reclamo, fecha) VALUES (3, 'Error en el importe', '2025-05-15');

INSERT INTO comercio_compra (importe, fecha, descripcion, tarjeta_id, pos_id) VALUES (1000.00, '2025-04-01', 'Compra en local A', 123456, 1);
INSERT INTO comercio_compra (importe, fecha, descripcion, tarjeta_id, pos_id) VALUES (2500.00, '2025-04-05', 'Compra en local B', 789012, 2);
INSERT INTO comercio_compra (importe, fecha, descripcion, tarjeta_id, pos_id) VALUES (1750.00, '2025-04-10', 'Compra en local C', 345678, 3);


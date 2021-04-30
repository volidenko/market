INSERT INTO bill (id, number, date_created, total_cost, payed, cc_number) VALUES (1, 271320540, '2021-04-21', 8527, true, '1111222233334444');

INSERT INTO cart (id, total_items, products_cost, delivery_included) VALUES (5, 0, 0, true);
INSERT INTO cart (id, total_items, products_cost, delivery_included) VALUES (6, 0, 0, true);
INSERT INTO cart (id, total_items, products_cost, delivery_included) VALUES (7, 0, 0, true);
INSERT INTO cart (id, total_items, products_cost, delivery_included) VALUES (4, 1, 6517, true);

INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (4, 5, 1);

INSERT INTO contacts (phone, address, id, city_region) VALUES ('+38 099 456 78 90', 'Центральная 22', 4, 'Одесса');
INSERT INTO contacts (phone, address, id, city_region) VALUES ('+380962112345', 'Перспективная', 7, 'Днепр');

INSERT INTO customer_order (id, user_account_id, date_created, executed, products_cost, delivery_included, delivery_cost) VALUES (1, 4, '2021-04-22', false, 8127, true, 400);

INSERT INTO ordered_product (customer_order_id, product_id, quantity) VALUES (1, 8, 1);


INSERT INTO category (id, title) VALUES (1, 'NoteBook');
INSERT INTO category (id, title) VALUES (2, 'Смартфоны');
INSERT INTO category (id, title) VALUES (3, 'Телевизоры');
INSERT INTO category (id, title) VALUES (4, 'Планшеты');
INSERT INTO category (id, title) VALUES (5, 'Мониторы');
INSERT INTO category (id, title) VALUES (6, 'Компьютеры');


INSERT INTO manufacturer (id, title) VALUES (1, 'Acer');
INSERT INTO manufacturer (id, title) VALUES (2, 'Apple');
INSERT INTO manufacturer (id, title) VALUES (3, 'Asus');
INSERT INTO manufacturer (id, title) VALUES (4, 'HP');
INSERT INTO manufacturer (id, title) VALUES (5, 'Samsung');


INSERT INTO product (id, name, price, category_id, manufacturer_id, available, description) VALUES (1, 'Asus ROG Strix G15 G512LI-HN058', 26999, 1, 3, true, 'Экран 15.6" IPS (1920x1080) Full HD 144 Гц, матовый / Intel Core i5-10300H (2.5 - 4.5 ГГц) / RAM 16 ГБ / SSD 512 ГБ / nVidia GeForce GTX 1650 Ti, 4 ГБ / без ОД / LAN / Wi-Fi / Bluetooth / без ОС / 2.39 кг / черный');
INSERT INTO product (id, name, price, category_id, manufacturer_id, available, description) VALUES (2, 'Acer Aspire 5 A515-55G', 18999, 1, 1, true, 'Экран 15.6" IPS (1920x1080) Full HD, матовый / Intel Core i5-1035G1 (1.0 - 3.6 ГГц) / RAM 8 ГБ / SSD 512 ГБ / nVidia GeForce MX350, 2 ГБ / без ОД / LAN / Wi-Fi / Bluetooth / веб-камера / без ОС / 1.8 кг / серебристый');
INSERT INTO product (id, name, price, category_id, manufacturer_id, available, description) VALUES (3, 'HP Pavilion Gaming Laptop 15-ec1003ua', 23499, 1, 4, true, 'Экран 15.6" IPS (1920x1080) Full HD, матовый / AMD Ryzen 5 4600H (3.0 - 4.0 ГГц) / RAM 16 ГБ / SSD 512 ГБ / nVidia GeForce GTX 1050, 3 ГБ / без ОД / LAN / Wi-Fi / Bluetooth / веб-камера / FreeDOS / 1.98 кг / темно-серый');
INSERT INTO product (id, name, price, category_id, manufacturer_id, available, description) VALUES (4, 'Apple iPhone 12 Pro Max 128GB Gold', 39499, 2, 2, true, 'Экран (6.7", OLED (Super Retina XDR), 2778x1284) / Apple A14 Bionic / тройная основная камера: 12 Мп + 12 Мп + 12 Мп, фронтальная камера: 12 Мп / 128 ГБ встроенной памяти / 3G / LTE / 5G / GPS / Nano-SIM / iOS 14');
INSERT INTO product (id, name, price, category_id, manufacturer_id, available, description) VALUES (5, 'Samsung Galaxy S21 8/128GB Phantom White', 26999, 2, 5, true, 'Экран (6.2", Dynamic AMOLED 2X, 2400x1080)/ Samsung Exynos 2100 (1 x 2.9 ГГц + 3 x 2.8 ГГц + 4 x 2.2 ГГц)/ тройная основная камера: 64 Мп + 12 Мп + 12 Мп, фронтальная 10 Мп/ RAM 8 ГБ/ 128 ГБ встроенной памяти/ 3G/ LTE/ 5G/ GPS/ поддержка 2х SIM-карт (Nano-SIM)/ Android 11.0 / 4000 мА*ч');
INSERT INTO product (id, name, price, category_id, manufacturer_id, available, description) VALUES (6, 'Apple iPad 10.2" Wi-Fi 32GB', 11499, 4, 2, true, 'Экран 10.2" IPS (2160x1620) MultiTouch / Apple A12 Bionic (2.49 ГГц) / 32 ГБ встроенной памяти / Wi-Fi / Bluetooth 4.2 / основная камера 8 Мп, фронтальная - 1.2 Мп / iPadOS 14 / 490 г / серый космос');
INSERT INTO product (id, name, price, category_id, manufacturer_id, available, description) VALUES (7, 'Samsung Galaxy Tab S6 Lite LTE 64GB', 26999, 4, 5, true, 'Экран 10.4" TFT (2000x1200) MultiTouch / Samsung Exynos 9611 (2.3 ГГц + 1.7 ГГц) / RAM 4 ГБ / 64 ГБ встроенной памяти + microSD / 3G / 4G / Wi-Fi / Bluetooth 5.0 / основная камера 8 Мп, фронтальная - 5 Мп / GPS / ГЛОНАСС / Android 10.0 (Q) / 467 г / серый');


INSERT INTO role (id, title) VALUES (0, 'ROLE_ADMIN');
INSERT INTO role (id, title) VALUES (1, 'ROLE_STAFF');
INSERT INTO role (id, title) VALUES (2, 'ROLE_USER');

INSERT INTO storage (id, available) VALUES (1, true);
INSERT INTO storage (id, available) VALUES (2, true);



INSERT INTO user_account (id, email, password, name, active) VALUES (1, 'admin', '$2a$10$Cmwx2Xr/PVpkibiiDz0s7eaVGZHPUvAu5ivdVC5BJgSYbp3c06FY6', 'Admin', true);
INSERT INTO user_account (id, email, password, name, active) VALUES (4, 'user@i.ua', '$2a$10$Cmwx2Xr/PVpkibiiDz0s7eaVGZHPUvAu5ivdVC5BJgSYbp3c06FY6', 'User', true);

INSERT INTO user_role (user_id, role_id) VALUES (1, 0);




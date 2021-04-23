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


INSERT INTO product (id, name, price, description, available) VALUES (1, 'Asus ROG Strix G15 G512LI-HN058', 26999, 'Экран 15.6" IPS (1920x1080) Full HD 144 Гц, матовый / Intel Core i5-10300H (2.5 - 4.5 ГГц) / RAM 16 ГБ / SSD 512 ГБ / nVidia GeForce GTX 1650 Ti, 4 ГБ / без ОД / LAN / Wi-Fi / Bluetooth / без ОС / 2.39 кг / черный', true);
INSERT INTO product (id, name, price, description, available) VALUES (2, 'Acer Aspire 5 A515-55G', 18999, 'Экран 15.6" IPS (1920x1080) Full HD, матовый / Intel Core i5-1035G1 (1.0 - 3.6 ГГц) / RAM 8 ГБ / SSD 512 ГБ / nVidia GeForce MX350, 2 ГБ / без ОД / LAN / Wi-Fi / Bluetooth / веб-камера / без ОС / 1.8 кг / серебристый', true);
INSERT INTO product (id, name, price, description, available) VALUES (3, 'HP Pavilion Gaming Laptop 15-ec1003ua', 23499, 'Экран 15.6" IPS (1920x1080) Full HD, матовый / AMD Ryzen 5 4600H (3.0 - 4.0 ГГц) / RAM 16 ГБ / SSD 512 ГБ / nVidia GeForce GTX 1050, 3 ГБ / без ОД / LAN / Wi-Fi / Bluetooth / веб-камера / FreeDOS / 1.98 кг / темно-серый', true);
INSERT INTO product (id, name, price, description, available) VALUES (4, 'Apple iPhone 12 Pro Max 128GB Gold', 39499, 'Экран (6.7", OLED (Super Retina XDR), 2778x1284) / Apple A14 Bionic / тройная основная камера: 12 Мп + 12 Мп + 12 Мп, фронтальная камера: 12 Мп / 128 ГБ встроенной памяти / 3G / LTE / 5G / GPS / Nano-SIM / iOS 14', true);
INSERT INTO product (id, name, price, description, available) VALUES (5, 'Samsung Galaxy S21 8/128GB Phantom White', 26999, 'Экран (6.2", Dynamic AMOLED 2X, 2400x1080)/ Samsung Exynos 2100 (1 x 2.9 ГГц + 3 x 2.8 ГГц + 4 x 2.2 ГГц)/ тройная основная камера: 64 Мп + 12 Мп + 12 Мп, фронтальная 10 Мп/ RAM 8 ГБ/ 128 ГБ встроенной памяти/ 3G/ LTE/ 5G/ GPS/ поддержка 2х SIM-карт (Nano-SIM)/ Android 11.0 / 4000 мА*ч', true);
INSERT INTO product (id, name, price, description, available) VALUES (6, 'Asus ROG Strix G15 G512LI-HN058', 26999, 'Инженеры ASUS работали над внешним видом ноутбука ROG Strix G совместно со специалистами дизайнерского бюро компании BMW. Результат – стильное устройство с современнейшей системой охлаждения.', true);
INSERT INTO product (id, name, price, description, available) VALUES (7, 'Asus ROG Strix G15 G512LI-HN058', 26999, 'Инженеры ASUS работали над внешним видом ноутбука ROG Strix G совместно со специалистами дизайнерского бюро компании BMW. Результат – стильное устройство с современнейшей системой охлаждения.', true);


INSERT INTO region (id, name, subtitle, color, description) VALUES (3, 'Island', '', 'blue', 'Scotch produced on the islands surrounding the mainland of Scotland offer a very diverse and different taste, they''re not however recognised by the Scotch Whisky Association but are easily grouped together for geographic reasons as one as they''re all islands. Although diverse in flavours, peat and salinity are found in all of the Islands whiskies, the latter because of the vicinity to the sea.
<p><ul>
<li>Number of distilleries: Under 10
<li>Typical flavours: Smoke, Brine, Oil, Black Pepper and Honey
</ul>');
INSERT INTO region (id, name, subtitle, color, description) VALUES (4, 'Islay', '', 'black', 'The Scottish island of Islay (pronounced eye-luh) is located to the west of the mainland and is the smallest Whisky region in terms of area coverage in Scotland. Even though it''s a relatively small island, Islay is currently home to 8 distilleries, 3 of which are World famous, Ardbeg, Laphroaig and Lagavulin. The region is known for its peaty single malts and it''s believed that whisky distillation reached Scotland from Ireland via Islay in the 13th century, hence the high number of past and present distilleries on the island.
<p><ul>
<li>Number of distilleries: Under 10
<li>Typical flavours: Seaweed, Brine, Carbolic Soap, Apple, Smoke and Kippers
</ul>');
INSERT INTO region (id, name, subtitle, color, description) VALUES (1, 'Campbeltown', '', 'purple', 'Campbeltown is part of mainland Scotland but it''s found at the foot of the Mull of Kintyre and was once a thriving whisky hotspot with over 34 distilleries, however it''s now home to just 3. A mixture of improved transportation links to the rival distilleries in the north and a decline in quality as distillers cut corners for mass-production resulting in an inferior product.
<p><ul>
<li>Number of distilleries: Under 5
<li>Typical flavours: Brine, Smoke, Dried Fruit, Vanilla and Toffee
</ul>');
INSERT INTO region (id, name, subtitle, color, description) VALUES (6, 'Speyside', '', 'green', 'The region of Speyside is located in the north east of Scotland surrounding the River Spey, it''s a sub-region to the neighbouring Highlands because of the high density of distilleries in the area. It''s home to the highest number of distilleries in Scotland with well over 60 at present. Speyside is a protected region for Scotch Whisky distilling under UK Government legislation.
<p><ul>
<li>Number of distilleries: Over 60
<li>Typical flavours: Apple, Vanilla, Oak, Malt, Nutmeg and Dried Fruit
</ul>');
INSERT INTO region (id, name, subtitle, color, description) VALUES (2, 'Highland', '', 'brown', 'The Highlands is Scotland''s largest whisky producing area, covering anywhere from the north of Glasgow (the Clyde estuary to the River Tay) all the way to Thurso in the north, not to mention the east and west regions excluding Speyside. Due to the large area, whisky in the Highlands is very diverse and offers a vast amount of different flavours so it''s hard to put a certain style on Whisky from this region.
<p><ul>
<li>Number of distilleries: Over 25
<li>Typical flavours: Fruit Cake, Malt, Oak, Heather, Dried Fruit and Smoke
</ul>');
INSERT INTO region (id, name, subtitle, color, description) VALUES (5, 'Lowland', '', 'yellow', 'Lowlands is the second biggest whisky region in terms of the area it covers, but it''s currently only home to fewer than five distilleries. The Lowlands region covers the south of Scotland up to the north of Glasgow and Edinburgh where it meets the border on the Highlands, the line follows the old county borders running from the Clyde estuary in the west to the River Tay in the east, anything south of this is to the border with England is classified as the ''Lowlands'' in whisky terms.
<p><ul>
<li>Number of distilleries: Under 5
<li>Typical flavours: Grass, Honeysuckle, Cream, Toffee, Toast and Cinnamon
</ul>');

INSERT INTO role (id, title) VALUES (0, 'ROLE_ADMIN');
INSERT INTO role (id, title) VALUES (1, 'ROLE_STAFF');
INSERT INTO role (id, title) VALUES (2, 'ROLE_USER');

INSERT INTO storage (id, available) VALUES (1, true);
INSERT INTO storage (id, available) VALUES (2, true);
INSERT INTO storage (id, available) VALUES (3, true);
INSERT INTO storage (id, available) VALUES (4, true);
INSERT INTO storage (id, available) VALUES (5, true);
INSERT INTO storage (id, available) VALUES (6, true);
INSERT INTO storage (id, available) VALUES (7, true);
INSERT INTO storage (id, available) VALUES (8, true);
INSERT INTO storage (id, available) VALUES (9, true);
INSERT INTO storage (id, available) VALUES (10, true);
INSERT INTO storage (id, available) VALUES (11, true);

INSERT INTO user_account (id, email, password, name, active) VALUES (1, 'admin', '$2a$10$Cmwx2Xr/PVpkibiiDz0s7eaVGZHPUvAu5ivdVC5BJgSYbp3c06FY6', 'Admin', true);
INSERT INTO user_account (id, email, password, name, active) VALUES (4, 'user@i.ua', '$2a$10$Cmwx2Xr/PVpkibiiDz0s7eaVGZHPUvAu5ivdVC5BJgSYbp3c06FY6', 'User', true);

INSERT INTO user_role (user_id, role_id) VALUES (1, 0);


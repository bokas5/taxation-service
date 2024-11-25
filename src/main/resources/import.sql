INSERT INTO trader (traderId, name, location)
VALUES (1, 'Trader A', 'GERMANY'),
       (2, 'Trader B', 'FRANCE'),
       (3, 'Trader C', 'SPAIN'),
       (4, 'Trader D', 'ITALY');

INSERT INTO country_tax_rules (id, country, taxRate, taxAmount, taxType)
VALUES (1, 'GERMANY', 10.0, 0.0, 'RATE'),  -- Rate-based taxation
       (2, 'FRANCE', 0.0, 3.0, 'AMOUNT'),  -- Amount-based taxation
       (3, 'SPAIN', 12.0, 0.0, 'RATE'),    -- Rate-based taxation
       (4, 'ITALY', 0.0, 1.0, 'AMOUNT');   -- Amount-based taxation
INSERT INTO coin (name, symbol) VALUES
    ('Bitcoin', 'btc'),
    ('Litecoin', 'ltc');

INSERT INTO portfolio (token, name) VALUES
    ('f98a3d1b-c18a-496a-a250-e54e6b2a3a88', 'testje');

INSERT INTO wallet (coin_id, portfolio_id, address, description) VALUES
    (1, 1, 'bitcoin_address', 'Bitcoin wallet'),
    (1, 2, 'litecoin_address', 'Litecoin wallet');
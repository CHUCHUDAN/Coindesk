DROP TABLE IF EXISTS currency;
CREATE TABLE IF NOT EXISTS currency (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          currency_en VARCHAR(10) NOT NULL UNIQUE,
                          currency_zh VARCHAR(10) NOT NULL UNIQUE
);

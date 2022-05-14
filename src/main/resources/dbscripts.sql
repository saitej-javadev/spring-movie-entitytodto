use mydb;
CREATE TABLE Movie (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(20),
                       language VARCHAR(20),
                       director VARCHAR(20),
                       actor VARCHAR(20),
                       actress VARCHAR(20)
);
create table if not exists book(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    price INT,
    type varchar(255),
    purchaseDate varchar(255)
);
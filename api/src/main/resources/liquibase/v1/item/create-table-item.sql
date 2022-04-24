CREATE TABLE item (
    id              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name           VARCHAR(255) NOT NULL,
    type           VARCHAR(255) NOT NULL,
    price          DECIMAL(24, 2) NOT NULL,
    PRIMARY KEY ( id )
);
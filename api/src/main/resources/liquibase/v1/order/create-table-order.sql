CREATE TABLE `order` (
    id             BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name           VARCHAR(255) NOT NULL,
    phone          VARCHAR(255) NOT NULL,
    status         VARCHAR(255) NOT NULL,
    PRIMARY KEY ( id )
);
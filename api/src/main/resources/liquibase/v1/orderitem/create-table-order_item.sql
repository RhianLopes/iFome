CREATE TABLE order_item (
    id              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    quantity        INTEGER NOT NULL,
    order_id        BIGINT UNSIGNED NOT NULL,
    item_id         BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY ( id ),
    CONSTRAINT `fk_order_item_order_id` FOREIGN KEY ( `order_id` ) REFERENCES `order` ( `id` ) ON DELETE CASCADE,
    CONSTRAINT `fk_order_item_item_id` FOREIGN KEY ( `item_id` ) REFERENCES `item` ( `id` ) ON DELETE CASCADE
);
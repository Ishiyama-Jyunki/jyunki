CREATE TABLE store (
    store_code        VARCHAR(5)  NOT NULL PRIMARY KEY,
    store_name        VARCHAR(25) NOT NULL,
    floor_id          VARCHAR(8)  NOT NULL,
    store_category_id INTEGER,
    delete_flag       INTEGER     DEFAULT 0,
    created_at        TIMESTAMP WITHOUT TIME ZONE
                        DEFAULT '2023-01-01 00:00:00',
    updated_at        TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE floor (
    floor_id     VARCHAR(8)  NOT NULL PRIMARY KEY,
    floor_name   VARCHAR(10) NOT NULL,
    floor_info   VARCHAR(50),
    store_count  INTEGER     DEFAULT 1,
    open_space   INTEGER     DEFAULT 0,
    created_at   TIMESTAMP WITHOUT TIME ZONE
                   DEFAULT '2023-01-01 00:00:00',
    updated_at   TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE product (
    product_id      SMALLSERIAL   NOT NULL PRIMARY KEY,
    product_name    VARCHAR(20)   NOT NULL,
    category_id     INTEGER       NOT NULL,
    store_code      VARCHAR(5)    NOT NULL,
    brand_name      VARCHAR(30),
    unit_price      INTEGER       DEFAULT 0,
    product_price   INTEGER       DEFAULT 0,
    stock_quantity  INTEGER       DEFAULT 100,
    stock_out_flag  BOOLEAN       DEFAULT FALSE,
    created_at      TIMESTAMP WITHOUT TIME ZONE
                      DEFAULT '2023-01-01 00:00:00',
    updated_at      TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE product_category (
    category_id   SMALLSERIAL PRIMARY KEY,
    category_name VARCHAR(20) NOT NULL,
    explanation   VARCHAR(25),
    created_at    TIMESTAMP WITHOUT TIME ZONE
                    DEFAULT '2023-01-01 00:00:00',
    updated_at    TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE facility (
    facility_code VARCHAR(10) NOT NULL PRIMARY KEY,
    facility_name VARCHAR(15) NOT NULL,
    created_at    TIMESTAMP WITHOUT TIME ZONE
                    DEFAULT '2023-01-01 00:00:00',
    updated_at    TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE department_store_join (
    no          SMALLSERIAL NOT NULL PRIMARY KEY,
    floor_id    VARCHAR(10) NOT NULL,
    item_name   VARCHAR(15) NOT NULL,
    item_code   VARCHAR(10) NOT NULL,
    explanation VARCHAR(50),
    created_at  TIMESTAMP WITHOUT TIME ZONE
                  DEFAULT '2023-01-01 00:00:00',
    updated_at  TIMESTAMP WITHOUT TIME ZONE
);


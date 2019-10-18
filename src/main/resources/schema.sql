CREATE SCHEMA test_schema;

Set search_path TO test_schema;

CREATE TABLE item
(
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(256) NOT NULL UNIQUE,
  code INTEGER      NOT NULL UNIQUE
);

CREATE TABLE attribute
(
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(256) NOT NULL UNIQUE
);

CREATE TABLE item_attribute
(
  item_id      BIGINT NOT NULL REFERENCES item (id),
  attribute_id BIGINT NOT NULL REFERENCES attribute (id),
  PRIMARY KEY (item_id, attribute_id)
);

CREATE TABLE lang
(
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(4) NOT NULL UNIQUE
);

CREATE TABLE item_lang
(
  item_id BIGINT       NOT NULL REFERENCES item (id),
  lang_id BIGINT       NOT NULL REFERENCES lang (id),
  meaning VARCHAR(256) NOT NULL,
  PRIMARY KEY (item_id, lang_id)
);

CREATE TABLE attribute_lang
(
  attribute_id BIGINT       NOT NULL REFERENCES attribute (id),
  lang_id      BIGINT       NOT NULL REFERENCES lang (id),
  meaning      VARCHAR(256) NOT NULL,
  PRIMARY KEY (attribute_id, lang_id)
);

INSERT INTO item (id, name, code)
VALUES (1, 'Telephone', 1212);

INSERT INTO attribute (id, name)
VALUES (1, 'Model'),
       (2, 'Manufacture'),
       (3, 'Screen Size');

INSERT INTO lang (id, name)
VALUES (1, 'RU'),
       (2, 'EN'),
       (3, 'FR'),
       (4, 'KZ');

INSERT INTO item_attribute (item_id, attribute_id)
VALUES (1, 1),
       (1, 2),
       (1, 3);

INSERT INTO item_lang (item_id, lang_id, meaning)
VALUES (1, 1, 'Телефон'),
       (1, 2, 'Phone'),
       (1, 4, 'Тел'),
       (1, 3, 'Le téléphone');

INSERT INTO attribute_lang (attribute_id, lang_id, meaning)
VALUES (1, 1, 'Модель'),
       (1, 3, 'Le modèle'),
       (1, 4, 'Улгісі'),
       (2, 1, 'Производство'),
       (2, 3, 'La production'),
       (2, 4, 'Өндіріс');
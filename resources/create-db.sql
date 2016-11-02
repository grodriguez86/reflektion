--DROP TABLE users IF EXISTS;

CREATE TABLE message (
  id         INTEGER PRIMARY KEY,
  text VARCHAR(200),
  lang  VARCHAR(30),
  data  TIMESTAMP,
  country VARCHAR(50)
);
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
create table if not exists animals
(
    id          uuid         not null,
    name        varchar     not null,
    kind        varchar     not null,
    UNIQUE      (id),
    PRIMARY KEY (id)
);



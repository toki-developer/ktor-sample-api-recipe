DROP TABLE IF EXISTS recipes;

CREATE TABLE IF NOT EXISTS recipes (
  id SERIAL NOT NULL,
  name varchar(100)  NOT NULL,
  cost integer NOT NULL,
  ingredients varchar(300) NOT NULL,
  created_at timestamp not null default current_timestamp,
  updated_at timestamp not null default current_timestamp,
  PRIMARY KEY (id)
);

INSERT INTO recipes (
  name,
  cost,
  ingredients
)
VALUES (
  '卵かけご飯',
  200,
  '米,卵,醤油'
);

INSERT INTO recipes (
  name,
  cost,
  ingredients
)
VALUES (
  'チャーハン',
  500,
  '米、ねぎ,卵,チャーシュ,醤油'
);

create function set_update_time() returns trigger as '
  begin
    new.updated_at := ''now'';
    return new;
  end;
' language 'plpgsql';

create trigger update_tri before update on recipes for each row
  execute procedure set_update_time();

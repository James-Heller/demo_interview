create table foo
(
    id serial primary key not null,
    create_at timestamptz not null default NOW(),
    some_data jsonb
);

insert into foo
values (DEFAULT, NOW(), '{
  "a": 1,
  "b": null
}'),
       (DEFAULT, NOW(), '{
         "a": 2,
         "b": false
       }'),
       (DEFAULT, NOW(), '{
         "a": 3,
         "b": "123"
       }'),
       (DEFAULT, NOW(), '{
         "a": 4,
         "b": [
           1,
           2,
           3,
           4
         ]
       }'),
       (DEFAULT, NOW(), '{"a": 5, "b": 678}')
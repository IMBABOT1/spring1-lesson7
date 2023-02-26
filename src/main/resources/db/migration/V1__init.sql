create table products (
    id          bigserial primary key,
    title       varchar(255),
    price       int,
    order_item  bigint not null references order_items (id)
);

insert into products (title, price, order_item)
values ('Milk', 100, 1),
       ('Bread', 80, 1),
       ('Cheese', 90, 1);

create table users (
    id         bigserial primary key,
    username   varchar(36) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles (
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles (
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
       ('john', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);

create table orders (
    id              bigserial primary key,
    user_id         bigint not null references users (id),
    total_price     int not null,
    address         varchar(255),
    phone           varchar(255)
);

create table order_items (
    id                      bigserial primary key,
    product_id              bigint not null references products (id),
    user_id                 bigint not null references users (id),
    order_id                bigint not null references orders (id),
    product_title           varchar(255),
    quantity                int not null,
    price_per_product       int not null,
    price                   int not null
);

insert into orders (user_id, total_price, address, phone)
values (1, 100, 'address', 'phone'),
       (2, 100, 'address1', 'phone');
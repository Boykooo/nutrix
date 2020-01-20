create table account
(
    id             serial primary key,
    email          varchar(255) not null,
    password       varchar(255),
    reg_date       timestamp    not null,
    blocked        boolean      not null,
    deleted        boolean      not null default false,
    email_approved boolean      not null default false
);

create table role
(
    id          serial primary key,
    name        varchar(150) not null,
    description varchar(500)
);

create table account_role
(
    account_id bigint not null,
    role_id    bigint not null,
    constraint fk_account_ud foreign key (account_id) references account (id),
    constraint fk_role_id foreign key (role_id) references role (id)
);

create table refresh_token
(
    account_id bigint       not null,
    token      varchar(255) not null,
    constraint fk_account_id foreign key (account_id) references account (id)
);


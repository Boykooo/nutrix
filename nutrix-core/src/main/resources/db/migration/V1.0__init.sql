create table photo
(
    id            varchar(255) primary key,
    path          varchar(255) not null,
    compress_path varchar(255),
    owner_id      bigint       not null
);

create table account
(
    id       bigint primary key,
    name     varchar(150) not null,
    photo_id varchar(100),
    goal     varchar(100) not null,
    sex      varchar(100) not null,
    birthday date         not null,
    height   smallint     not null,
    constraint fk_photo_id foreign key (photo_id) references photo (id)
);

alter table photo
    add constraint fk_owner_id foreign key (owner_id) references account (id);


-- #############################            WEIGHT          #############################

create table weight_info
(
    account_id     bigint primary key,
    start_weight   smallint not null,
    current_weight smallint not null,
    target_weight  smallint not null,
    constraint fk_account_id foreign key (account_id) references account (id)
);

create table weight_history
(
    account_id bigint primary key,
    date       date not null ,
    weight     smallint not null,
    constraint fk_account_id foreign key (account_id) references account (id)
)



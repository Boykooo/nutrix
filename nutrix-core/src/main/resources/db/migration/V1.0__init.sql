create table account
(
    id       bigint primary key,
    name     varchar(150) not null,
    photo_id bigint
);

create table photo
(
    id            varchar(255) primary key,
    path          varchar(255) not null,
    compress_path varchar(255),
    owner_id      bigint       not null,
    constraint fk_owner_id foreign key (owner_id) references account (id)
);

alter table account
    add constraint fk_photo_id foreign key (photo_id) references photo (id);

alter table users add column enabled tinyint(1) not null;
alter table users modify userId username varchar(20);
alter table users modify username varchar(50);
alter table users modify email varchar(50);
alter table users modify password varchar(50);
alter table users modify display_name varchar(50);

create table if not exists authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username)
)
create unique index ix_auth_username on authorities (username,authority);

create table groups (
  id bigint(20) not null auto_increment,
  group_name varchar(50) not null,
  primary key(id)
);

create table group_authorities (
  group_id bigint(20) not null,
  authority varchar(50) not null,
  constraint fk_group_authorities_group foreign key(group_id) references groups(id)
);

create table group_members (
  id bigint(20) not null auto_increment,
  username varchar(50) not null,
  group_id bigint(20) not null,
  primary key(id),
  constraint fk_group_members_group foreign key(group_id) references groups(id)
);

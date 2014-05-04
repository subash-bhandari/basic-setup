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

create table posts (
  id bigint(20) not null auto_increment,
  tile varchar(200) not null,
  author_id bigint(20) not null,
  created_ts timestamp not null,
  updated_ts timestamp not null,
  primary key(id),
  constraint fk_posts_users foreign key(author_id) references users(id)
);

create table post_contents (
  post_id bigint(20) not null,
  content mediumtext not null,
  constraint fk_post_contents_posts foreign key(post_id) references posts(id)
);

create table comments (
  id bigint(20) not null auto_increment,
  commentor_id bigint(20) not null,
  created_ts timestamp not null,
  updated_ts timestamp not null,
  primary key(id),
  constraint fk_comments_users foreign key(commentor_id) references users(id)
);

create table comment_contents (
  comment_id bigint(20) not null,
  content mediumtext not null,
  constraint fk_comment_contents_comments foreign key(comment_id) references comments(id)
);

create table categories (
  id bigint(20) not null auto_increment,
  category varchar(100) not null,
  primary key(id)
);

create table posts_categories (
  post_id bigint(20) not null,
  category_id bigint(20) not null,
  constraint posts_categories_posts foreign key(post_id) references posts(id),
  constraint posts_categories_categories foreign key(category_id) references categories(id)
);
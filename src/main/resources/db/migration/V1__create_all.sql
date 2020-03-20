    drop table if exists cuisine;

    drop table if exists dish;

    drop table if exists ingredient;

    drop table if exists menu;

    drop table if exists restaurant;

    drop table if exists user;

create table cuisine (
       id integer not null auto_increment,
        cuisine_name varchar(255),
        primary key (id)
    ) engine=InnoDB;

create table dish (
       dish_id integer not null auto_increment,
        description varchar(255),
        dish_name varchar(255),
        price double precision,
        primary key (dish_id)
    ) engine=InnoDB;

create table ingredient (
       ingredient_id integer not null auto_increment,
        ingredient_name varchar(255),
        weight double precision,
        primary key (ingredient_id)
    ) engine=InnoDB;

create table menu (
       id integer not null auto_increment,
        description varchar(255),
        primary key (id)
    ) engine=InnoDB;

create table restaurant (
       restaurant_id integer not null auto_increment,
        address varchar(255),
        description varchar(255),
        restaurant_name varchar(255),
        menu_id integer,
        primary key (restaurant_id)
    ) engine=InnoDB;

create table user (
       user_id integer not null auto_increment,
        first_name varchar(255),
        last_name varchar(255),
        login varchar(255),
        password varchar(255),
        primary key (user_id)
    ) engine=InnoDB;
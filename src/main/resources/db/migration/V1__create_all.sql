create table dish (
       dish_id integer not null auto_increment,
        description varchar(255),
        dish_name varchar(255),
        price double precision,
        primary key (dish_id)
    ) ;

    create table ingredient (
       ingredient_id integer not null auto_increment,
        ingredient_name varchar(255),
        weight double precision,
        primary key (ingredient_id)
    ) ;


    create table restaurant (
       restaurant_id integer not null auto_increment,
        address varchar(255),
        description varchar(255),
        restaurant_name varchar(255),
        primary key (restaurant_id)
    );

    create table user (
       user_id integer not null auto_increment,
        first_name varchar(255),
        last_name varchar(255),
        login varchar(255),
        password varchar(255),
        primary key (user_id)
    );
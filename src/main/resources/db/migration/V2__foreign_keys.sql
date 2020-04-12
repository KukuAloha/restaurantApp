    alter table comment_dish
       add constraint FKpd6klbwbshf4givxkltm08d3b
       foreign key (dish_id)
       references dish (id);

    alter table comment_dish
       add constraint FK8b8hs6ldihttqgnjsykxapbm9
       foreign key (user_id)
       references user (id);

    alter table comment_restaurant
       add constraint FKylhjafh9iwhdww2wtl3wuf87
       foreign key (restaurant_id)
       references restaurant (id);

    alter table comment_restaurant
       add constraint FKpgyjjbx32ap9rwh6cjh9g0naf
       foreign key (user_id)
       references user (id);

    alter table cuisine_restaurant
       add constraint FK27icvcide65wdspkujtlgv3ix
       foreign key (restaurant_id)
       references restaurant (id);

    alter table cuisine_restaurant
       add constraint FKiuejt4vtlre889uo2ia009pem
       foreign key (cuisine_id)
       references cuisine (id);

    alter table dish
       add constraint FKljuksxg35var0r9a3y09l148h
       foreign key (menu_id)
       references menu (id);

    alter table dish_ingredient
       add constraint FKlsik2ca5etotku9wviwcnsbu4
       foreign key (ingredient_id)
       references ingredient (id);

    alter table dish_ingredient
       add constraint FKb0mfoikuh0kjw66vsssyqseo
       foreign key (dish_id)
       references dish (id);

    alter table menu
       add constraint FKblwdtxevpl4mrds8a12q0ohu6
       foreign key (restaurant_id)
       references restaurant (id);
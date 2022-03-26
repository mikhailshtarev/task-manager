Insert into tm_db.users (id, username, password, email, created_date_time, last_updated_date_time, created_user,
                         last_updated_user)
values ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b1', 'useruser',
        '$2a$10$hqRuT.iImVfeB9I9N2bSuuEc4jCdCKs1BD.K1ErhUGY4XUMV2wZbS', 'useremail@yandex.ru', null, null, null, null),
       ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b2', 'contentcontent',
        '$2a$10$hqRuT.iImVfeB9I9N2bSuuEc4jCdCKs1BD.K1ErhUGY4XUMV2wZbS', 'contentemail@yandex.ru', null, null, null,
        null),
       ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b3', 'adminadmin',
        '$2a$10$hqRuT.iImVfeB9I9N2bSuuEc4jCdCKs1BD.K1ErhUGY4XUMV2wZbS', 'adminemail@yandex.ru', null, null, null, null);

insert into tm_db.users_roles (user_id, role_id)
values ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b1', '2bb3655f-7a70-42eb-ac44-b81ef0bbd9b5'),
       ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b2', '2bb3655f-7a70-42eb-ac44-b81ef0bbd9b5'),
       ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b2', '2bc3655f-7a70-42eb-ac44-b81ef0bbd9b5'),
       ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b3', '2bb3655f-7a70-42eb-ac44-b81ef0bbd9b5'),
       ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b3', '2bc3655f-7a70-42eb-ac44-b81ef0bbd9b5'),
       ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b3', '2bd3655f-7a70-42eb-ac44-b81ef0bbd9b5'),
       ('2bb3655f-7a70-42eb-ac44-b81ef0bbd9b3', '2be3655f-7a70-42eb-ac44-b81ef0bbd9b5');
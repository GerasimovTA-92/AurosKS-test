insert into k_pacs (title, description, creation_date) values("test 1", "test 1", "24-06-2022");
insert into k_pacs (title, description, creation_date) values("test 2", "test 2", "24-06-2022");
insert into k_pacs (title, description, creation_date) values("test 3", "test 3", "24-06-2022");

insert into k_pacs_sets (title) values("test 1");
insert into k_pacs_sets (title) values("test 2");
insert into k_pacs_sets (title) values("test 3");

insert into k_pacs_sets_k_pacs (k_pacs_set_id, k_pac_id) values(1, 1);
insert into k_pacs_sets_k_pacs (k_pacs_set_id, k_pac_id) values(1, 2);
insert into k_pacs_sets_k_pacs (k_pacs_set_id, k_pac_id) values(2, 1);
insert into k_pacs_sets_k_pacs (k_pacs_set_id, k_pac_id) values(2, 3);
insert into k_pacs_sets_k_pacs (k_pacs_set_id, k_pac_id) values(2, 2);

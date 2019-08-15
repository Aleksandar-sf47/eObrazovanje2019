insert into uloga(uloga) values ('ADMIN');
insert into uloga(uloga) values ('NASTAVNIK');
insert into uloga(uloga) values ('STUDENT');

insert into korisnici(k_ime, sifra) values ('admin', '$2a$10$JXS3FkNTxQMK8Slm/FJojOK2t5kgiGVgdrgzl7nFwLEoGY96VpjVW');

insert into korisnik_uloge(korisnik_id, uloga_id) values ('1','1');
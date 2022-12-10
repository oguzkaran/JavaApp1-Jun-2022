-- japp1j22_animalhospitaldb

create table if not exists veterinarians (
	diploma_no bigint primary key,
	citizen_id char(36) check(length(citizen_id) = 36) not null,
	first_name varchar(100) not null,
	middle_name varchar(100),
	last_name varchar(100) not null,
	birth_date date not null,
	register_date date default(current_date) not null	
);

create table if not exists owners (
	owner_id serial primary key,
	name varchar(255) not null,
	phone char(14) not null,
	address varchar(512) not null
);

create table if not exists animals (
	animal_id bigint primary key,
	owner_id int references owners(owner_id) not null,
	name varchar(100),
	type varchar(100) not null,
	birth_date date not null,
	sterile bool not null	
);

create table if not exists veterinarians_to_animals (
	veterinary_to_animal_id bigserial primary key,
	animal_id bigint references animals(animal_id) not null,
	diploma_no int references veterinarians(diploma_no) not null,
	datetime timestamp not null,
	description text,
	price double precision default(0.0) not null
);

truncate table veterinarians restart identity cascade;
truncate table owners restart identity cascade;
truncate table animals restart identity cascade;
truncate table veterinarians_to_animals restart identity cascade;



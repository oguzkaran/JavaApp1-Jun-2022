-- japp1j22_animalhospitaldb

create table if not exists veterinarians (
	diploma_no bigint primary key,
	citizen_id char(36) check(length(citizen_id) >= 11) not null,
	first_name varchar(100) not null,
	middle_name varchar(100),
	last_name varchar(100) not null,
	birth_date date not null,
	register_date date default(current_date) not null	
);

create table if not exists owners (
	owner_id serial primary key,
	name varchar(255) not null,
	phone char(14) not null,	address varchar(512) not null
);

create table if not exists animals (
	animal_id serial primary key,
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

create or replace function find_veterinarian_by_year_between(int, int)
    returns table (
                      diploma_no bigint,
                      full_name varchar(300),
                      birth_date date,
                      register_date date
                  )
as '
begin
    return query
        select
            v.diploma_no,
            case
                when v.middle_name isnull then cast(v.first_name || $$ $$ || upper(v.last_name) as varchar(300))
                else cast(v.first_name || $$ $$ || v.middle_name || $$ $$ || upper(v.last_name) as varchar(300))
                end,
            v.birth_date,
            v.register_date
        from veterinarians v where date_part($$year$$, v.register_date) between $1 and $2;
end

' language plpgsql;

create or replace function find_animal_details_by_diploma(bigint)
returns table (
                  animal_id int,
                  animal_name varchar(100),
                  animal_type varchar(100),
                  animal_birth_date date,
                  animal_owner_name varchar(255),
                  animal_owner_phone char(14)
              )
as '
begin
    return query
        select
            a.animal_id as id,
            a.name as animal_name,
            a.type as animal_type,
            a.birth_date as animal_birth_date,
            o.name as owner_name,
            o.phone as owner_phone
        from
            veterinarians_to_animals va inner join animals a on a.animal_id = va.animal_id
                                        inner join owners o on a.owner_id = o.owner_id
        where va.diploma_no = $1;
end

' language plpgsql;

create or replace procedure sp_insert_veterinarian(bigint, char(36), varchar(100), varchar(100), varchar(100), date, date)
language plpgsql
as '
	begin
		insert into veterinarians (diploma_no, citizen_id, first_name, middle_name, last_name, birth_date, register_date)
            values ($1, $2, $3, $4, $5, $6, $7);
    end
';




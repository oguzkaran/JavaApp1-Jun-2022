-- japp1j22_animalhospitaldb

create table if not exists veterinarians (
	diploma_no bigint primary key,
	citizen_id char(36) check(length(citizen_id) >= 11) not null,
	first_name varchar(100) not null,
	middle_name varchar(100),
	last_name varchar(100) not null,
	birth_date date not null,
	register_date date default(current_date) not null
    --,is_active boolean default(true) not null
);

truncate table veterinarians restart identity cascade;

create or replace function find_veterinarians_by_year_between(int, int)
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

create or replace function find_all_veterinarians_with_full_name()
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
        from veterinarians v;
end

' language plpgsql;


create or replace procedure sp_insert_veterinarian(bigint, char(36), varchar(100), varchar(100), varchar(100), date, date)
language plpgsql
as '
    begin
        if $7 is null then
        	insert into veterinarians (diploma_no, citizen_id, first_name, middle_name, last_name, birth_date)
            values ($1, $2, $3, $4, lower($5), $6);
        else
        	insert into veterinarians (diploma_no, citizen_id, first_name, middle_name, last_name, birth_date, register_date)
            values ($1, $2, $3, $4, lower($5), $6, $7);
        end if;
    end;
';






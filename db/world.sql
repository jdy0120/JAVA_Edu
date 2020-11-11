use world;

select * from city;
select name,district from city;
select name from city where CountryCode = 'kor';

select name from city where CountryCode = 'kor' and name like('%p%');

select * from city where 500000 <= population and population <= 1000000;

select * from city where countrycode = 'kor' and population between 100000 and 1000000;

select name,population from city where (countrycode = 'usa' or countrycode = 'kor') and population between 700000 and 1000000;

select name,district from city where countrycode in ('kor','usa','chn') and population >= 1000000;

select * from city;

select countrycode,avg(population),count(countrycode)
from city
group by countrycode
having avg(population) >= 500000;

select * from country;
select code, name, gnp, GNPOLD, GNP+GNPOLD hap
from country;

create table city2(
	cid int auto_increment primary key,
    cname varchar(50) not null,
    country char(3) not null,
    district varchar(20) not null
);

insert into city2(cid,cname,country,district)
	select id,name,countrycode,district from city
	where population >= 500000;
    
create table city3 (select id, name, countrycode, district from city where population >= 500000);
select * from city2;
select * from city3;

select * from country;
select if(gnp < gnpold,'개발실패국가','개발성공국가') c, count('')
from country
group by c;

select ifnull(null,200);
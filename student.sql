use world;

select * from city;
select * from country;

create view v_country
as
	select Code,Name, Continent, Region from country;
    
select * from v_country;


create view v_countryCity
as 
	select c.Code,c.Name,c.Continent,s.ID,s.Name cityName, s.District
	from  country c, city s
    where s.countryCode = c.Code;

select * from v_countryCity;

select rand(), floor(rand()*10) + 1;
select truncate(1234.567,2), truncate(1234.567,-2);
select adddate('2020-02-01', interval 31 day), date_add('2020-02-01',interval -31 day);
select subdate('2020-02-01', interval 31 day), date_sub('2020-02-01',interval -31 day);

select addtime('2020-01-01 23:59:59', '1:1:1'),subtime('2020-01-01 23:59:59','1:1:1');
select addtime('23:59:59','1:1:1'),subtime('23:59:59','1:1:1');

select curdate(),current_date(),current_date;
select curtime(), current_time(),current_time;
select now(),sysdate(),localtime(), localtimestamp();
select year(now()), month('2020-01-05'),day(now());

select timediff('23:59',curtime());

select version();

select * from city,country where (city.countryCode = country.Code);
select * from city where CountryCode = 'KOR';

select * from city inner join country on city.countryCode = country.Code where city.Name = 'seoul';

-- city와 country, countrylanguage 세 테이블을 조인하여 한국의 정보만 출력

select * from countrylanguage;
select city.ID,city.Name,country.Name,country.Code,countrylanguage.language from city,country,countrylanguage where (city.countryCode = country.Code) and (country.Code = countrylanguage.countryCode) and country.Code = 'KOR' and countrylanguage.language <> 'Chinese';

-- t_student : s_id,s_name
-- t_grade : g_id,s_id,g_subject,g_score



create table t_student (
	s_id int auto_increment primary key,
    s_name varchar(10) not null
);
insert into t_student (s_name) values ('김길동');
insert into t_student (s_name) values ('이길동');
insert into t_student (s_name) values ('박길동');
insert into t_student (s_name) values ('최길동');
insert into t_student (s_name) values ('홍길동');


create table t_grade (
	g_id int auto_increment primary key,
    s_id int not null,
    g_subject varchar(10) not null,
    g_score int default 0,
    constraint fk_s_id foreign key(s_id) references t_student(s_id)
);

select * from t_student;

insert into t_grade (s_id,g_subject,g_score) values (1,'DB',60);
insert into t_grade (s_id,g_subject,g_score) values (3,'DB',80);
insert into t_grade (s_id,g_subject,g_score) values (5,'DB',90);

select * from t_grade;

-- t_student와 t_grade를 이용하여 각 학생들의 시험 점수를 출력
-- 학생ID, 학생명, 과목명, 점수
select s.s_id,s.s_name,g.g_subject,g.g_score
from t_student s,t_grade g
where s.s_id = g.s_id;
-- inner join이므로 조건에 맞는 데이터들만 출력

select s.s_id,s.s_name,g.g_subject,g.g_score
from t_student s left outer join t_grade g
on s.s_id = g.s_id;
-- left join이므로 왼쪽의 t_student 테이블의 데이터는 모두 출력하고,
-- 오른쪽의 t_grade 테이블의 데이터는 조건에 맞는 데이터만 출력

select * from t_student s cross join t_grade g;
select * from t_student s, t_grade g;

select s_id,s_name from t_student
union
select g_id,g_subject from t_grade;

select * from t_student where s_name in('전우치','홍길동');
-- s_name의 값들 중 '전우치'나 '홍길동'인 값이 있으면 출력
select * from t_student where s_name not in('전우치','홍길동');
-- s_name의 값들 중 '전우치'도 '홍길동'도 아닌 값이 있으면 출력

select s_id,s_name
from t_student
where s_id not in (
select s_id
from t_grade);
-- 시험을 치지 않은 학생들의 id와 이름을 출력
-- t_student에는 있지만 t_grade에는 업슨ㄴ 학생들의 id와 이름을 출력

show index from t_student;

create table test(
	a int primary key,
    b int unique,
    c int unique,
    d int 
);

insert into test values(2,1,3,1);
insert into test values(5,1,8,2);
insert into test values(3,7,5,3);
insert into test values(1,6,9,0);

select * from test;

show index from test;
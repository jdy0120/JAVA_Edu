use test;

-- test용 쇼핑몰 DB 구축(tm_)
-- 회원 테이블 : 아이디, 비밀번호, 이름, 등록일, 상태
create table tm_member_list(
	ml_id varchar(20) primary key, 	-- 회원 아이디
    ml_pwd varchar(20) not null, 	-- 비밀번호
    ml_name varchar(20) not null, 	-- 회원명
    ml_date datetime default now(), -- 가입일
    ml_status char(1) default 'a' 	-- 상태(a:정상, b:휴면, c:탈퇴)
);

-- 회원 주소록 테이블 : 아이디, 회원 아이디, 우편번호, 주소1, 주소2, 기본주소
create table tm_member_addr (
	ma_id int auto_increment primary key, 	-- 주소 아이디
    ml_id varchar(20) not null, 			-- 회원 아이디
	ma_zip char(5) not null,				-- 우편 주소
    ma_addr1 varchar(100) not null,			-- 주소1
    ma_addr2 varchar(100) not null,			-- 주소2
    ma_basic char(1) default 'b'			-- 기본주소 여부(a:기본, b:일반)
);

insert into tm_member_list (ml_id,ml_pwd,ml_name) values ('test1','1111','홍길동');
insert into tm_member_list (ml_id,ml_pwd,ml_name) values ('test2','1111','전우치');
insert into tm_member_list (ml_id,ml_pwd,ml_name) values ('test3','1111','임꺽정');
insert into tm_member_list (ml_id,ml_pwd,ml_name) values ('test4','1111','김길동');

select * from tm_member_list;

insert into tm_member_addr (ml_id,ma_zip,ma_addr1,ma_addr2,ma_basic) values('test1','12345','서울시','강남구','a');
insert into tm_member_addr (ml_id,ma_zip,ma_addr1,ma_addr2,ma_basic) values('test1','12345','서울시','강남구2','b');
insert into tm_member_addr (ml_id,ma_zip,ma_addr1,ma_addr2,ma_basic) values('test1','12345','서울시','강남구3','b');
insert into tm_member_addr (ml_id,ma_zip,ma_addr1,ma_addr2,ma_basic) values('test2','12345','서울시 강남구','역삼동','a');

select * from tm_member_addr;

-- 회원 정보(아이디, 이름, 주소)를 출력하는 프로시저 작성

delimiter $$
create procedure sp_member()
begin
	select m.ml_id,m.ml_name,a.ma_zip,a.ma_addr1,a.ma_addr2
	from tm_member_list m, tm_member_addr a
	where m.ml_id = a.ml_id and a.ma_basic = 'a';
end $$
delimiter ;

call sp_member();

-- if과련 테스트용 프로시저 sp_ifTest1
-- score의 점수가 60이상이면 'D', 70이상이면 'C', 80이상이면 'B',
-- 90이상이면 'A', 60미만이면 'F'로 출력되도록 작업
-- 단, 학점은 credit이라는 변수를 만들어 저장하고 그 값을 최후에 출력
-- 출력내용 : 점수 ==> ?? / 학점 ==> ?
delimiter $$
create procedure sp_ifTest1()
begin
	declare score int; -- 점수를 저장하기 위한 변수
	declare credit char(1); -- 학점을 저장하기 위한 변수
    set score = 78;
    
    if score >= 90 then
		set credit = 'A';
	elseif score >= 80 then
		set credit = 'B';
	elseif score >= 70 then
		set credit = 'C';
	elseif score >= 60 then
		set credit = 'D';
	else
		set credit = 'F';
	end if;
    select concat('점수 ==> ',score),concat('학점 ==> ',credit);
end $$
delimiter ;
ma_idtm_brand_list
call sp_ifTest1();


select * from tm_member_list;
update tm_member_list set ml_date='2018-01-11 15:21:20'
where ml_id = 'test1';
update tm_member_list set ml_date='2019-03-11 15:21:20'
where ml_id = 'test2';
update tm_member_list set ml_date='2019-01-11 15:21:20'
where ml_id = 'test3';
update tm_member_list set ml_date='2020-03-11 15:21:20'
where ml_id = 'test4';

-- 회원이 가입한지 며칠이 지났는지 출력하는 프로시저
-- 회원ID를 매개변수로 받아 해당 회원의 가입기간을 출력

delimiter $$
create procedure sp_ifTest2(uid varchar(20))
-- 프로시저 실행시 외부에서 데이터를 받아와 uid에 넣음
begin
	declare joinDate datetime; -- 가입일
    declare curDate datetime; -- 오늘 날짜
    declare dayCount int; -- 가입기간
    
    select ml_date into joinDate
		from tm_member_list where ml_id = uid;
	-- 받아 온 uid값을 조건으로 하여 ml_date의 값을 joinDate변수에 넣음
    
	set curDate = now();
    -- curDate변수에 오늘 날짜 및 시간을 넣음
    set dayCount = datediff(curDate, joinDate);
    -- joinDate부터 curDate까지의 기간을 일수로 리턴하여 dayCount에 저장
    
    select concat(uid,'님은 가입한지 ',dayCount, '일이 지났습니다.');
end $$
delimiter ;

call sp_ifTest2('test2');
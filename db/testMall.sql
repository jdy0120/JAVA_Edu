use survey;
-- 관리자 목록 테이블
create table t_admin_list(
	al_idx int auto_increment unique, -- 관리자번호
    al_id varchar(20) primary key, -- 관리자ID
    al_pwd varchar(20) not null, -- 비밀번호
    al_name varchar(20) not null, -- 이름
    al_phone varchar(13) not null, -- 전화번호
    al_email varchar(50) not null, -- 이메일
    al_date datetime default now(), -- 등록일
    al_status char(1) default 'a' -- 상태
);

insert into t_admin_list (al_id,al_pwd,al_name,al_phone,al_email)
values ('sa',1234,'관리자','010-1234-5678','sa@testMall.com');

select * from t_admin_list;
-- 메뉴 목록 테이블
create table t_admin_menu(
	am_idx int auto_increment primary key, -- 메뉴변호
    am_name varchar(20) not null, -- 메뉴명
    am_link varchar(100) not null, -- 메뉴링크 URL
    am_level int default 1, -- 메뉴레벨 (0:메뉴분류,1:메뉴)
    am_date datetime default now(), -- 등록일
    am_status char(1) default 'a' -- 상태(a:사용중 b:사용불가)
);


create table t_admin_pms(
	ap_idx int auto_increment primary key, -- 권한번호
    al_idx int not null,
    am_idx int not null,
    ap_pms char(1) default 'A', -- A:접근불가,B:읽기전용,C:입력가능,D:수정가능,E:삭제가능
    ap_date datetime default now(), -- 등록일
    constraint fk_pms_al_idx foreign key(al_idx) references t_admin_list(al_idx),
    constraint fk_pms_am_idx foreign key(am_idx) references t_admin_menu(am_idx)
);

create table t_member_list(
	ml_id varchar(20) primary key, -- 회원ID
    ml_pwd varchar(20) not null, -- 비밀번호
    ml_name varchar(20) not null, -- 이름
    ml_gender char(1) not null, -- M:남자,F:여자
    ml_birth char(10) not null, -- 생일
    ml_phone varchar(13) not null, -- 전화번호
    ml_email varchar(50) not null, -- 이메일
    ml_point int default 0, -- 보유포인트
    ml_date datetime default now(), -- 가입일
    ml_last datetime default now(), -- 최종로그인
    ml_status char(1) default 'a' -- 상태 a:사용중,b:휴면계정,c:탈퇴
);

insert into t_member_list (ml_id,ml_pwd,ml_name,ml_gender,ml_birth,ml_phone,ml_email) 
values('test1','1234','홍길동','M','1988-05-15','010-1234-5678','hong@testMail.com');
insert into t_member_list (ml_id,ml_pwd,ml_name,ml_gender,ml_birth,ml_phone,ml_email) 
values('test2','1234','전우치','M','1988-05-15','010-1235-5678','jeon@testMail.com');
insert into t_member_list (ml_id,ml_pwd,ml_name,ml_gender,ml_birth,ml_phone,ml_email) 
values('test3','1234','임꺽정','M','1988-05-15','010-1236-5678','lim@testMail.com');
insert into t_member_list (ml_id,ml_pwd,ml_name,ml_gender,ml_birth,ml_phone,ml_email) 
values('test4','1234','최유림','F','1988-05-15','010-1237-5678','choi@testMail.com');
insert into t_member_list (ml_id,ml_pwd,ml_name,ml_gender,ml_birth,ml_phone,ml_email) 
values('test5','1234','조도연','M','1988-05-15','010-1238-5678','cho@testMail.com');

create table t_member_addr(
	ma_idx int auto_increment primary key, -- 주소번호
    ml_id varchar(20), -- 회원ID
    ma_zip char(5) not null, -- 우편번호
    ma_addr1 varchar(50) not null, -- 주소1
    ma_addr2 varchar(50) not null, -- 주소2
    ma_basic char(1) default 'n', -- 기본주소 여부 n:일반주소,y:기본주소
	ma_date datetime default now(), -- 등록일
    constraint fk_addr_ml_id foreign key(ml_id) references t_member_list(ml_id)
);

insert into t_member_addr (ml_id,ma_zip,ma_addr1,ma_addr2,ma_basic)
values ('test1','12345','서울시 강남구','123-45','y');
insert into t_member_addr (ml_id,ma_zip,ma_addr1,ma_addr2)
values ('test1','12346','서울시 성동구','456-7');

create table t_member_point( -- 포인트사용/적립내역
	mp_idx int auto_increment primary key,
    ml_id varchar(20),
    mp_use char(1) default 'a', -- 사용적립여부 a:적립 b:사용
    mp_point int default '0',
    mp_detail varchar(50) not null, -- 내용
    mp_order varchar(20) default '', -- 주문번호or게시글번호
    mp_date datetime default now(), -- 사용일
    constraint fk_point_ml_id foreign key(ml_id) references t_member_list(ml_id)
);

insert into t_member_point(ml_id,mp_point,mp_detail,mp_order)
values ('test1',1000,'가입축하금','가입축하금');
insert into t_member_point(ml_id,mp_point,mp_detail,mp_order)
values ('test2',1000,'가입축하금','가입축하금');
insert into t_member_point(ml_id,mp_point,mp_detail,mp_order)
values ('test3',1000,'가입축하금','가입축하금');
insert into t_member_point(ml_id,mp_point,mp_detail,mp_order)
values ('test4',1000,'가입축하금','가입축하금');
insert into t_member_point(ml_id,mp_point,mp_detail,mp_order)
values ('test5',1000,'가입축하금','가입축하금');

select * from t_member_point;
update t_member_list set ml_point = 1000;

create table t_cata_big( -- 대분류
	cb_idx int primary key,
    cb_name varchar(10) not null,
    cb_date datetime default now()
);

insert into t_cata_big (cb_idx,cb_name) values (11,'대분류1');
insert into t_cata_big (cb_idx,cb_name) values (21,'대분류2');
select * from t_cata_big;

create table t_cata_small( -- 소분류
	cs_idx int primary key,
    cb_idx int not null,
    cs_name varchar(10) not null,
    cs_date datetime default now(),
    constraint fk_cata_cb_idx foreign key (cb_idx) references t_cata_big(cb_idx)
);

insert into t_cata_small (cs_idx,cb_idx,cs_name) values(1101,11,'소분류01');
insert into t_cata_small (cs_idx,cb_idx,cs_name) values(1102,11,'소분류02');
insert into t_cata_small (cs_idx,cb_idx,cs_name) values(2101,21,'소분류03');
insert into t_cata_small (cs_idx,cb_idx,cs_name) values(2102,21,'소분류04');

select * from t_cata_small;

-- 브랜드 테이블
create table t_brand_list( -- 브랜드
	bl_idx int primary key, -- 브랜드번호
    bl_name varchar(10) not null, -- 브랜드명
    bl_date datetime default now() -- 등록일
);

insert into t_brand_list(bl_idx,bl_name) values (11,'A브랜드');
insert into t_brand_list(bl_idx,bl_name) values (12,'B브랜드');
insert into t_brand_list(bl_idx,bl_name) values (13,'C브랜드');

select * from t_brand_list;

















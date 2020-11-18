use test; -- test DB를 사용하겠다는 의미

create table t_member (
	uid varchar(20) primary key, 		-- 회원 아이디
    pwd varchar(20) not null,  			-- 비밀번호
    name varchar(50) not null, 			-- 이름
    phone varchar(13) not null, 		-- 휴대폰 번호
    birth char(10) not null, 			-- 생년월일(yyyy-mm-dd)
    gender char(1) not null, 			-- 성별(m : 남, F : 여)
    email varchar(50) not null, 		-- 이메일
    recommend varchar(10),				-- 추천인 아이디
    ismail char(1) default 'Y',			-- 메일수신 여부(Y : 수신, N : 미수신 )
    issms char(1) default 'Y',			-- SMS수신 여부(Y : 수신, N : 미수신 )
    grade char(1) default 'D',			-- 등급
    point int default 0, 				-- 보유 포인트
    lastvisit datetime default now(), 	-- 최종 방문일
    joindate datetime default now(), 	-- 회원 가입일
    isactive char(1) default 'Y'		 -- 계정 사용여부(Y : 사용, N : 탕퇴, S : 휴먼 )
);


drop table t_address;

create table t_address (
	aid int unsigned auto_increment primary key,
	uid varchar(20),
    zip char(5) not null,
    addr1 varchar(50) not null,
    addr2 varchar(50) not null,
    isprime char(1) default 'N'
);


alter table t_address add constraint fk_t_address_uid foreign key(uid) references t_member(uid) on delete cascade;
-- 특정 테이블에 외래키를 추가하는 구문

-- 임시(temporary) 테이블로서 현재 DB가 꺼지기 전까지만 남아있는 테이블로 잠깐동안 테스트하는 용도로 사용됨
create temporary table tmp (
	uid varchar(20) primary key,
    pwd varchar(20) not null
);

insert into tmp values ('test','1234');

select * from tmp;


create table t_memberlist(
	ml_id varchar(20) primary key,
	ml_pwd varchar(20) not null,			-- 암호
	ml_name varchar(50) not null,			-- 이름
	ml_phone varchar(13) not null,			-- 전화번호
	ml_zip char(5) not null,				-- 우편번호
	ml_addr1 varchar(50) not null,			-- 주소1
	ml_addr2 varchar(50) not null			-- 주소2
);

create table t_productlist (
	pl_id varchar(20) primary key,			-- 상품 아이디
	pl_name varchar(50) not null,			-- 상품명
	pl_price int default 0, 				-- 가격
	pl_origin varchar(20) not null,			-- 원산지
	pl_img1 varchar(50) not null,			-- 상품사진1
	pl_img2 varchar(50), 					-- 상품사진2
	pl_img3 varchar(50), 					-- 상품사진3
	pl_desc varchar(50) not null, 			-- 설명이미지
	pl_stock int default -1,				-- 재고
	pl_isview char(1) default 'N'			-- 게시여부
);

create table t_orderlist(
	ol_id varchar(20) primary key,			-- 주문ID
	ml_id varchar(20),						-- 회원ID
	ol_rname varchar(50) not null,			-- 수취인명
	ol_rphone varchar(13) not null,			-- 수취인전화번호
	ol_rzip char(5) not null,				-- 배송지 우편번호
	ol_raddr1 varchar(50) not null,			-- 배송지 주소1
	ol_raddr2 varchar(50) not null,			-- 배송지 주소2
	ol_payment char(1) default 'a',			-- 결제방식
	ol_pay int default 0,					-- 결제액
	ol_comment varchar(100),				-- 요구사항
	ol_status char(1) default 'a',			-- 주문상태
	ol_date datetime default now(),			-- 주문일
    constraint fk_t_memberlist_id foreign key(ml_id) references t_memberlist(ml_id) on delete cascade
);

create table t_orderdetail(
	od_id int unsigned auto_increment primary key,	-- 주문상세ID
	ol_id varchar(20),								-- 주문ID
	pl_id varchar(20),								-- 상품ID
	od_cnt int default 1, 							-- 상품개수
	od_img varchar(50) not null,					-- 상품이미지
	od_price int default 0,							-- 상품단가
	od_name varchar(100) not null,					-- 상품명
    constraint fk_t_orderlist_id foreign key(ol_id) references t_orderlist(ol_id) on delete cascade,
    constraint fk_t_productlist_id foreign key(pl_id) references t_productlist(pl_id) on delete cascade
);

drop table t_productlist;
drop table t_orderlist;

update t_memberlist
set ml_name = '홍길동'
where ml_id = 'test';

select * from t_memberlist;

delete from t_memberlist where ml_id = 'test2';

select if(30>20,'참입니다.','거짓입니다.') boolean;

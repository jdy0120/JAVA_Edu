use exam;

delimiter $$
create procedure sp_cart_insert(
	mlid varchar(50), plidx int, plname varchar(20),
    plimg1 varchar(20), clprice int, clcnt int,
    plopt varchar(200), clopt varchar(200)
)
begin
	insert into tm_cart_list (ml_id,pl_idx,pl_name,pl_img1,cl_price,cl_cnt,pl_opt,cl_opt)
    values (mlid,plidx,plname,plimg1,clprice,clcnt,plopt,clopt);
end $$
delimiter ;

drop procedure sp_cart_insert;


call sp_cart_insert('test1',1,'남자구두1','1_1.jpg',135000,1,'Size,250,255,260,265,270','260');

select * from tm_cart_list;

delimiter $$
create procedure sp_cart_update(
	clidx int, mlid varchar(50), clcnt int, clopt varchar(200)
)
begin
	update tm_cart_list set cl_cnt = clcnt, cl_opt = clopt
	where cl_idx = clidx and ml_id = mlid;
end $$
delimiter ;
drop procedure sp_cart_update;

call sp_cart_update(1,'test1',2,'270');
select * from tm_cart_list;

delimiter $$
create procedure sp_cart_delete(
	clidx int, mlid varchar(50))
begin
	if clidx = 0 then  -- 전체삭제
		delete from tm_cart_list where ml_id = mlid;
    else -- 개별 삭제
		delete from tm_cart_list where cl_idx = clidx and ml_id = mlid;
	end if;
end $$
delimiter ;
drop procedure sp_cart_delete;

call sp_cart_delete(1,'test1');

select * from tm_cart_list;


-- 주문 테이블 : 주문관련정보(배송지 정보, 결제 정보 등) 를 저장하ㅡㄴ 테이블

create table tm_order_list (
	ol_id varchar(10) primary key, -- 주문번호
    ml_id varchar(20) default 'no', -- 회원ID(비회원이면 'no')
	ol_pwd varchar(20) default '', -- 비밀번호(비회원 전용)
    od_sname varchar(20) not null, -- 주문자명
    ol_sphone varchar(13) not null, -- 주문자 전화번호
    ol_smail varchar(50) not null, -- 주문자 메일
    ol_rname varchar(20) not null, -- 수취인명
    ol_rphone varchar(13) not null, -- 수취인전화번호
    ol_rzip char(5) not null, -- 우편번호
    ol_raddr1 varchar(50) not null, -- 주소1
    ol_raddr2 varchar(50) not null, -- 주소2
    ol_comment varchar(100), -- 요구사항
    ol_usepnt int default 0, -- 사용한 포인트
    ol_savepnt int default 0, -- 적립한 포인트
    ol_payment char(1) default 'a', -- 결제방법(a:카드,b:계좌,...)
    ol_pay int default 0, -- 총 결제액
    ol_date datetime default now(), -- 주문일
    ol_status char(1) default 'b' -- 주문상태(a:입금대기,b:상품준비..)
);

-- 주문번호, 주문자ID, 비회원비밀번호, 주문자명, 주문자 전화번호, 주문자 메인
-- 수취인명, 수취인 전화번호, 배송지 우편번호, 배송지 주소1, 주소2,
-- 총 결제액, 주문상태, 주문일, 결제방법, 요구사항, 사용 포인트, 적립 포인트

create table tm_order_detail(
	od_idx int auto_increment primary key, -- 주문상세ID
    ol_id varchar(10) not null, -- 주문번호
    pl_idx int unsigned not null, -- 상품아이디
    od_cnt int default 1, -- 구매수량
    od_opt varchar(200), -- 옵션
    od_price int default 0, -- 단가
    constraint fk_od_ol_id foreign key (ol_id) references tm_order_list(ol_id),
    constraint fk_od_pl_idx foreign key (pl_idx) references tm_product_list(pl_idx) -- 상품idx 외래키 지정
);

drop table tm_order_detail;
-- 주문상세ID, 주문ID, 상품ID, 구매수량, 옵션, 단가, 

-- 주문테이블에 주문정보를 입력하는 프로시저 sp_ord_list_in를 작성
drop procedure if exists sp_ord_list_in;
delimiter $$
create procedure sp_ord_list_in(
	olid varchar(10),
    mlid varchar(20),
	olpwd varchar(20),
    odsname varchar(20),
    olsphone varchar(13),
    olsmail varchar(50),
    olrname varchar(20),
    olrphone varchar(13),
    olrzip char(5),
    olraddr1 varchar(50),
    olraddr2 varchar(50),
    olcomment varchar(100),
    olusepnt int,
    olsavepnt int,
    olpayment char(1),
    olpay int,
    olstatus char(1)
)
begin
	insert into tm_order_list (ol_id ,ml_id,ol_pwd , od_sname, ol_sphone, ol_smail,ol_rname, ol_rphone,ol_rzip, ol_raddr1, ol_raddr2, ol_comment, ol_usepnt, ol_savepnt, ol_payment, ol_pay, ol_status )
    values (olid ,mlid,olpwd , odsname, olsphone, olsmail,olrname, olrphone,olrzip, olraddr1, olraddr2, olcomment, olusepnt, olsavepnt, olpayment, olpay, olstatus);
end $$
delimiter ;
call sp_ord_list_in('2011160001','test1','','','','','홍길동','010-1234-5678','12345','서울시 강남구 삼성동','123-45','',0,100,'a',135000,'b');
select * from tm_order_list;


-- 주문상세테이블에 주문정보를 입력하는 프로시저 sp_ord_detail_in을 작성
delimiter $$
create procedure sp_ord_detail_in(
	clidx int, mlid varchar(50), clcnt int, clopt varchar(200)
)
begin
	update 
end $$
delimiter ;
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


-- 주문상세테이블에 주문정보를 입력하는 프로시저 sp_ord_detail_in을 작성 insert
delimiter $$
create procedure sp_ord_detail_in(
	olid varchar(10), plidx int, odcnt int, odopt varchar(200), odprice int
)
begin
	insert into tm_order_detail (ol_id,pl_idx,od_cnt,od_opt,od_price) values (olid,plidx,odcnt,odopt,odprice);
end $$
delimiter ;
drop procedure sp_ord_detail_in;

call sp_ord_detail_in('2011160001',1,1,'270',135000);

select * from tm_order_detail;

-- 자유게시판 테이블
create table tm_bbs_free(
	bf_idx int unsigned auto_increment primary key, -- 글번호
    bf_writer varchar(20) not null, -- 작성자명(회원ID)
    bf_pwd varchar(20), -- 비밀번호(비회원일 경우)
    bf_title varchar(100) not null, -- 글제목
    bf_content text not null, -- 글내용
    bf_read int default 0, -- 조회수
    bf_good int default 0, -- 추천수
    bf_bad int default 0, -- 비추천수
    bf_reply int default 0, -- 댓글수
    bf_notice char(1) default 'n', -- 공지글여부(y:공지글,n:일반글)
    bf_status char(1) default 'a', -- 글상태(a:일반,b:삭제글)
    bf_date datetime default now()
);

-- 자유게시판 테이블에 새 글을 입력하는 프로시저 sp_bbs_free_in를 작성
drop procedure sp_bbs_free_in;
delimiter $$
create procedure sp_bbs_free_in(
	bfwriter varchar(20),bfpwd varchar(20),bftitle varchar(100),bfcontent text,bfnotice char(1))
begin
	insert into tm_bbs_free (bf_writer,bf_pwd,bf_title,bf_content,bf_notice)
    values (bfwriter,bfpwd,bftitle,bfcontent,bfnotice);
end $$
delimiter ;
call sp_bbs_free_in('홍길동','1234','제목...','내용...','n');
select * from tm_bbs_free;

-- 자유게시판 테이블의 글을 수정하는 프로시저 sp_bbs_free_up을 작성
drop procedure if exists sp_bbs_free_up;
delimiter $$
create procedure sp_bbs_free_up( bfidx int,
    bftitle varchar(100),
    bfcontent text,
    bfnotice char(1)
)
begin
	update tm_bbs_free set bf_title = bftitle, bf_content = bfcontent,bf_notice = bfnotice
    where bf_idx = bfidx;
end $$
delimiter ;

call sp_bbs_free_up(1,'제목제목..','내용내용..','n');
select * from tm_bbs_free;

-- 자유게시판 테이블의 글을 삭제하는 프로시저 sp_bbs_del을 작성
drop procedure if exists sp_bbs_free_del;
delimiter $$
create procedure sp_bbs_free_del (
	bfidx int
)
begin
	update tm_bbs_free set bf_status = 'b' where bf_idx = bfidx;
end $$
delimiter ;

call sp_bbs_free_del(1);
select * from tm_bbs_free;

-- 자유 게시판 댓글 테이블
create table tm_bbs_free_reply(
	bfr_idx int unsigned auto_increment primary key, -- 댓글번호
	bf_idx int unsigned not null,
    bfr_writer varchar(20) not null, -- 작성자명(회원ID)
    bfr_pwd varchar(20), -- 비밀번호
    bfr_content varchar(500) not null, -- 댓글내용
    bfr_good int default 0, -- 추천
    bfr_bad int default 0, -- 비추천
	bfr_answer int unsigned default 0, -- 대댓글번호(댓글이면 자신의 번호)
    bfr_date datetime default now(), -- 작성일
    bfr_rept char(1) default 'a', -- 신고(a:일반,b:신고)
    bfr_status char(1) default 'a', -- 상태(a:일반,b:신고삭제,c:삭제)
    constraint fk_bfr_bf_idx foreign key (bf_idx) references tm_bbs_free(bf_idx)
);

drop procedure if exists sp_bbs_free_reply_in;
delimiter $$
create procedure sp_bbs_free_reply_in(
	bfridx int,
	bfidx int,
    bfrwriter varchar(20),
    bfrpwd varchar(20),
    bfrcontent varchar(500),
	bfranswer int
)
begin
	declare bfridx int;
	select max(bfr_idx)+1 into bfridx from tm_bbs_free_reply;
    
    -- 댓글 테이블에서 댓글번호 중 가장 큰 값 + 1의 값을 bfridx변수에 넣음
    
    if bfridx is null then -- 처음 댓글이 없으면 1로 댓글번호 지정
		set bfridx = 1;
    end if;
    
    if bfranswer = 0 then -- 대댓글이 아닌 일반 댓글인 경우
		set bfranswer = bfridx;
	end if;
    
	insert into tm_bbs_free_reply (bfr_idx,bf_idx,bfr_writer,bfr_pwd,bfr_content,bfr_answer) values (bfridx,bfidx,bfrwriter,bfrpwd,bfrcontent,bfranswer);
    update tm_bbs_free set bf_reply = bf_reply+1 where bf_idx = bfidx;
end $$
delimiter ;

call sp_bbs_free_reply_in(1,1,'전우치','1234','댓글내용',0);
call sp_bbs_free_reply_in(1,1,'임꺽정','1234','댓글내용2',1);
call sp_bbs_free_reply_in(2,1,'임꺽정','1234','댓글내용22',0);
select * from tm_bbs_free_reply;
select * from tm_bbs_free;

update tm_bbs_free set bf_reply = 0;

select max(bfr_idx) from tm_bbs_free_reply;

-- 자유게시판 댓글테이블의 댓글을 삭제하는 프로시저 sp_bbs_free_reply_del을 잣겅
drop procedure if exists sp_bbs_free_reply_del;
delimiter $$
create procedure sp_bbs_free_reply_del(
	
)
begin
	update 

end $$
delimiter ;
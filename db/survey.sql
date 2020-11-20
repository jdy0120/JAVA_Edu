create database survey;
use survey;

select a.pl_idx, a.pl_name,count(b.pl_idx) 판매횟수, sum(b.od_cnt) 판매개수, year(c.ol_date), month(c.ol_date)
from tm_product_list a, tm_order_detail b, tm_order_list c
where a.pl_idx = b.pl_idx and b.ol_id = c.ol_id
group by a.pl_idx, a.pl_name, year(c.ol_date), month(c.ol_date);
-- 월별(연도 포함) 총 판매횟수 및 개수

select a.pl_idx, a.pl_name,count(b.pl_idx) 판매횟수, sum(b.od_cnt) 판매개수, year(c.ol_date), month(c.ol_date)
from tm_product_list a, tm_order_detail b, tm_order_list c
where a.pl_odx = b.pl_idx and b.ol_id = c.ol_id
group by a.pl_idx, a.pl_name, year(c.ol_date), month(c.ol_date);
-- 월별(연도 포함) 총 판매횟수 및 개수


-- stored function 예제
set global log_bin_trust_function_creators = 1;
-- 함수생성 권한을 부여

drop function if exists testFunc;
delimiter $$
create function testFunc(v1 int, v2 int) returns int
begin
    declare result int;
    set result = v1 + v2;
    return result;
end $$
delimiter ;

select testFunc(10,20); -- 실행

-- 태어난 연도를 인수로 받아 나이를 계산하여 리턴하는 함수 getAgeFunc()작성
drop function if exists getAgeFunc;
delimiter $$
create function getAgeFunc(bYear int) returns int
begin
    declare age int;
    set age = year(now()) - bYear;
    return age;
end $$
delimiter ;
select getAgeFunc(1988);

-- tm_member_list테이블의 생일을 이용하여 회원ID, 이름, 나이를 출력하는 select문 작성
select ml_id, ml_name, getAgeFunc(left(ml_birth, 4)) age
from tm_member_list;

-- 공지글 테스트용 겸 자료실 테이블
create table tm_bbs_pds (
    bp_idx int primary key, -- 글번호
    bp_writer varchar(20) not null, -- 작성자(보통은 관리자ID)
    bp_title varchar(100) not null, -- 제목
    bp_content text not null, -- 내용
    bp_file varchar(20), -- 첨부파일(null허용)
    bp_size int default  0, -- 파일용량
    bp_read int default 0, -- 조회수
    bp_down int default 0, -- 다운로드수
    bp_rate int default 1, -- 평가점수(1~5)
    bp_status char(1) default 'a', -- 글상태(a:일반,b:삭제)
    bp_date datetime default now() -- 작성일
);

-- 작료실 글등록 프로시저 sp_bbs_pds_in 제작
drop procedure if exists sp_bbs_pds_in;
delimiter $$
    create procedure sp_bbs_pds_in(bpidx int, bpwriter varchar(20), bptitle varchar(100), bpcontent text, bpfile varchar(20),bpsize int , bpstatus char(1))
begin
    -- 용량이 5MB 이하일 경우에만 실행
    declare max int;
    declare noticeCnt int; -- 현재 공지글 개수를 저장할 변수
    declare noticeMin int; -- 가장 오래된 공지글의 글번호

    set max = 5* 1024*1024;

    if bpsize <= max then
        -- 공지글은 최대 5개 까지만 등록되도록 작업
        if bpstatus = 'b' then
            select count(*) into noticeCnt
            from tm_bbs_pds where bp_status = 'b';

            if noticeCnt >= 5 then
                select min(bp_idx) into noticeMin
                from tm_bbs_pds where bp_status = 'b';
                -- 가장 오래된 공지글의 글번호를 noticeMin 변수에 저장

                update tm_bbs_pds set bp_status = 'a'
                where  bp_idx = noticeMin;
                -- 가장 오래된 공지글을 일반글로 변환 시킴

            end if;

        end if;
        select max(bp_idx) + 1 into bpidx from tm_bbs_pds;
        -- 새롭게 등록될 글의 글번호 생성


        insert into tm_bbs_pds (bp_idx,bp_writer, bp_title, bp_content, bp_file, bp_size,bp_status)
        values (bpidx,bpwriter, bptitle, bpcontent, bpfile, bpsize,bpstatus);
    end if;
end $$
delimiter ;

call sp_bbs_pds_in ('관리자','엄청 좋은 자료','??','',0,'a');

insert into tm_bbs_pds (bp_idx,bp_writer,bp_title,bp_content,bp_file,bp_size,bp_status)
values (1,'관리자','제목...','내용...','a.jpg','1002','b');

select * from tm_bbs_pds;


-- 설문조사 관련 테이블 : 회원전용으로 모두 객관식이고, 보기는 최대 5개 까지 등록
-- 설문조사 질문 테이블(보기 포함), 설문조사 참여 테이블(회원ID, 선택한 보기)

create table tm_poll_question (
    pq_idx int auto_increment primary key, -- 설문번호
    pq_question varchar(100) not null, -- 질문내용
    pq_ex1 varchar(100) not null, -- 보기1
    pq_ex2 varchar(100) not null, -- 보기2
    pq_ex3 varchar(100), -- 보기3
    pq_ex4 varchar(100), -- 보기4
    pq_ex5 varchar(100), -- 보기5
    pq_sdate datetime default now(), -- 설문시작일
    pq_edate datetime default now(), -- 설문종료일
    pq_status char(1) default 'a', -- 설문상태(a:대기,b:조사중,c:종료,d:보류)
    pq_date datetime default now() -- 등록일
);


-- 설문조사 참여 테이블(회원ID, 선택한 보기)
create table tm_poll_result (
    pr_idx int auto_increment unique,
    -- auto_increment로 지정하는 컬럼은 반드시 key로 지정되어야 함
    -- primary key로 지정안되면 unique키로 지정해야 함
    pq_idx int not null, -- 설문조사 ID
    ml_id varchar(20) not null, -- 참여한 회원ID
    pr_ex int not null, -- 선택한 보기 번호
    pr_date datetime default now(), -- 참여일
    primary key(ml_id,pq_idx),
    -- ml_id와 pq_idx 두 컬럼을 묶어서 PK로 지정
    -- 각각은 값이 중복될 수 있으나 두 값을 묶었을 때는 중복되지 않음
    constraint fk_pr_ml_id foreign key (ml_id) references tm_member_list(ml_id), -- 회원ID외래키 지정
    constraint fk_pr_pq_idx foreign key (pq_idx) references tm_poll_question(pq_idx) -- 설문조사ID 외래키 지정
);

create table t_admin_list(
	al_idx int auto_increment unique,
    al_id varchar(20) primary key,
    al_pwd varchar(20) not null,
    al_name varchar(20) not null,
    al_phone varchar(13) not null,
    al_email varchar(50) not null,
    al_date datetime default now(),
    al_status char(1) default 'a'
);

create table t_admin_menu(
	am_idx int auto_increment unique,
    am_name varchar(20) not null,
    am_link varchar(100) not null,
    am_level int default '1',
    am_date datetime default now(),
    am_status char(1) default 'a'
);

create table t_admin_pms(
	ap_idx int auto_increment primary key,
    al_idx int not null,
    am_idx int not null,
    ap_pms char(1) default 'A' -- A:접근불가,B:읽기전용,C:입력가능,D:수정가능,E:삭제가능
);

create table t_member_list(
	ml_id varchar(20) primary key,
    ml_pwd varchar(20) not null,
    ml_name varchar(20) not null,
    ml_gender char(1) not null, -- M:남자,F:여자
    ml_birth char(10) not null,
    ml_phone varchar(13) not null,
    ml_email varchar(50) not null,
    ml_point int default '0',
    ml_date datetime default now(),
    ml_last datetime default now(),
    ml_status char(1) default 'a' -- a:사용중,b:휴면계정,c:탈퇴
);

create table t_member_addr(
	ma_idx int auto_increment primary key,
    ml_id varchar(20),
    ma_zip char(5) not null,
    ma_addr1 varchar(50) not null,
    ma_addr2 varchar(50) not null,
    ma_basic char(1) default 'n', -- 기본주소 여부 n:일반주소,y:기본주소
	ma_date datetime default now() -- 등록일
);

create table t_member_point( -- 포인트사용/적립내역
	mp_idx int auto_increment primary key,
    ml_id varchar(20),
    mp_use char(1) default 'a', -- 사용적립여부 a:적립 b:사용
    mp_point int default '0',
    mp_detail varchar(50) not null, -- 내용
    mp_order varchar(20) default '', -- 주문번호or게시글번호
    mp_date datetime default now() -- 사용일
);

create table t_cata_big( -- 대분류
	cb_idx int primary key,
    cb_name varchar(10) not null,
    cb_date datetime default now()
);
create table t_cata_small( -- 소분류
	cb_idx int primary key,
    cb_idx int not null,
    cb_name varchar(10) not null,
    cs_date datetime default now()
);

create table t_product_list( -- 상품목록
	pl_id char(10) primary key, 
    cs_idx int,
    bl_idx int,
    pl_orig varchar(20) not null,
    pl_name varchar(50) not null,
    pl_price int default '0',
    pl_cost int default 0,
    pl_discount int default 0,
    pl_opt varchar(200), -- 옵션명1,값1,값2,...,값n/ 옵션명2,값1,값2,값3,...n/ 옵션명3,값1,값2,값3,...
    pl_img1 varchar(50) not null,
    pl_img2 varchar(50),
    pl_img3 varchar(50),
    pl_desc varchar(50) not null,
    pl_deli varchar(50) not null, -- 배송정보 이미지
    pl_stock int default -1, -- 재고량 -1:무제한
    pl_salecnt int default 0,
    pl_review int default 0,
    pl_view char(1) default 'n',
    pl_date datetime default now(),
    al_idx int not null -- 관리자번호
);

create table t_brand_list( -- 브랜드
	bl_idx int primary key,
    bl_name varchar(10) not null,
    bl_date datetime default now()
);

create table t_cart_list( -- 장바구니
	cl_idx int auto_increment primary key,
    cl_buyer varchar(20) not null, -- 회원ID, or 세션ID
    pl_id char(10) not null,
    cl_opt varchar(100),
    cl_cnt int default 1, -- 선택한 수량
    cl_date datetime default now()
);

create table order_list( -- 주문목록
	ol_id char(15) primary key, -- 주문ID
    ol_buyer varchar(20) not null, -- 회원 ID or 세션 ID
    ol_pwd varchar(20) default '', -- 비회원 비밀번호
    ol_bname varchar(20) not null, -- 구매자명
    ol_bphone varchar(13) not null,
    ol_bmail varchar(50) not null, -- 구매자 이메일
    ol_rname varchar(20) not null, -- 수취인 명
    ol_rphone varchar(13) not null, -- 수취인 전화번호
    ol_rzip char(5) not null, -- 수취인 우편번호
	ol_raddr1 varchar(50) not null, -- 수취인 주소1
    ol_raddr2 varchar(50) not null, -- 수취인 주소2
    ol_comment varchar(200) default '', -- 요구사항
    ol_usepnt int default 0, -- 사용 포인트
    ol_savepnt int default 0, -- 적립 포인트
    ol_payment char(1) default 'a', -- 결제방법 a:카트 b:휴대폰 c:계좌이체 d:무통장 e:간편결제
    ol_pay int default 0,
    ol_status char(1) default 'a', -- a:결제대기 b:상품준비중 c:배송중 d:배송완료 e:주문완료 f:반품요청 g:환불요청
    ol_date datetime default now() -- 주문일
);

create table t_order_detail( -- 주문상세
	bl_idx int auto_increment unique,
    ol_id char(15) not null, 
    pl_id char(10) not null,
    od_cnt int default 1, -- 구매수량
    od_opt varchar(100), -- 선택한옵션
    od_price int default 0 -- 구매단가
);

create table t_notice_list( -- 공지사항
	nl_idx int auto_increment primary key,
    nl_title varchar(100) not null,
    nl_content text not null,
    nl_read int default 0, -- 조회수
    nl_date datetime default now(),
    al_idx int not null
);

create table t_qna_list( -- QnA 1:1문의 게시판
	ql_idx int auto_increment primary key,
    ml_id varchar(20), -- 회원 ID
    ql_title varchar(100) not null, -- 질문제목
    ql_content text not null, -- 질문내용
    ql_ip varchar(15) not null, -- 질문자ip주소
    ql_qdate datetime default now(), -- 질문일
    ql_answer text default '', -- 답변내용
    ql_adate datetime, -- 답변일
    al_idx int, -- 관리자 번호
    ql_status char(1) default 'a' -- 상태 a:미답변b:미완료c:완료
);
 
create table t_review_list( -- 후기게시판
	rl_idx int auto_increment primary key, -- 일련번호
    pl_id char(10) not null, -- 상품ID
    ml_id varchar(20), -- 회원ID
    rl_title varchar(100) not null, -- 제목
    rl_content text not null, -- 내용
    rl_img varchar(50), -- 상품이미지
    rl_rate int default 5, -- 1-10 평점
    rl_reply int default 0, -- 댓글개수
    rl_rept char(1) default 'a', -- 신고(a:일반 b:신고 c:처리완료)
    rl_ip varchar(15) not null, -- 등록자IP주소
    rl_date datetime default, now()
    rl_status char(1) default 'a' -- 상태(a:일반글b:삭제글(self) c:삭제글(admin))
);
 
create table t_review_reply( -- 후기 댓글게시판 - mlb파크 형태
	rr_idx int auto_increment primary key, -- 일련번호
	rl_idx int not null, -- 후기게시글 번호
    ml_id varchar(20), -- 회원ID
    rr_content text not null, -- 내용
    rr_rept char(1) default 'a', -- 신고(a:일반 b:신고 c:처리완료)
    rr_ip varchar(15) not null, -- ip주소
    rr_date datetime default now(), -- 등록일
    rr_status char(1) default 'a' -- 상태(a:일반글b:삭제글(self) c:삭제글(admin))
);

create table t_poll_question( -- 공지사항
	pq_idx int auto_increment primary key, -- 일련번호
    pq_question varchar(200) not null, -- 설문내용
    pq_desc text, -- 설문설명
    pq_start datetime, -- 설문시작일
    pq_end datetime,
    pq_date datetime default now(), -- 등록일
    pq_status char(1) default 'a' -- 상태 a:대기중 b:설문조사중 c:종료 d:보류
);
insert into t_poll_question(pq_question,pq_desc)
values ('첫번째 설문내용','');
insert into t_poll_question(pq_question,pq_desc)
values ('두번째 설문내용','');
select * from t_poll_question;


create table t_poll_exam( -- 설문조사 보기
	pe_idx int auto_increment primary key, -- 설문조사 보기번호
    pq_idx int not null, -- 설문조사 번호
    pe_exam varchar(100) not null, -- 보기내용
    pe_seq int not null, -- 보기순서
    pe_date datetime default now(), -- 등록일
    pe_status char(1) default 'a' -- 상태
);
insert into t_poll_exam(pq_idx,pe_exam,pe_seq)
values (1,'1번 보기', 1);
insert into t_poll_exam(pq_idx,pe_exam,pe_seq)
values (1,'2번 보기', 2);
insert into t_poll_exam(pq_idx,pe_exam,pe_seq)
values (1,'3번 보기', 3);
insert into t_poll_exam(pq_idx,pe_exam,pe_seq)
values (2,'2-1번 보기', 1);
insert into t_poll_exam(pq_idx,pe_exam,pe_seq)
values (2,'2-2번 보기', 2);
insert into t_poll_exam(pq_idx,pe_exam,pe_seq)
values (2,'2-3번 보기', 3);
insert into t_poll_exam(pq_idx,pe_exam,pe_seq)
values (2,'2-4번 보기', 4);

select * from t_poll_exam;

create table t_poll_result( -- 설문조사 결과
	pr_idx int auto_increment primary key, -- 일련번호
    ml_id varchar(20) not null, -- 회원ID
    pq_idx int not null, -- 설문조사 번호
    pe_idx int not null, -- 설문조사 보기번호
    pr_date datetime default now() -- 설문참여일
);
insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test1',1,1);
insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test2',1,1);
insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test3',1,2);
insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test4',1,1);
insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test5',1,3);

insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test1',2,4);
insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test2',2,4);
insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test3',2,5);
insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test4',2,4);
insert into t_poll_result (ml_id,pq_idx,pe_idx) values ('test5',2,6);

update t_poll_result set pe_idx = 4 where pr_idx = 6 or pr_idx = 7 or pr_idx = 9;
update t_poll_result set pe_idx = 5 where pr_idx = 8;
update t_poll_result set pe_idx = 6 where pr_idx = 10;

-- 설문ID, 설문내용, 보기순서, 보기내용, 보기선택개수, 
select pq_idx,count(pe_idx)
from t_poll_result
group by pq_idx,pe_idx;


select a.pq_idx,a.pq_question,b.pe_seq,b.pe_exam, c.pe_idx, count(c.pe_idx) 득표율
from t_poll_question a,t_poll_exam b, t_poll_result c
where a.pq_idx = b.pq_idx and b.pe_idx = c.pe_idx
group by a.pq_idx,a.pq_question,b.pe_seq,b.pe_exam,b.pe_idx;


























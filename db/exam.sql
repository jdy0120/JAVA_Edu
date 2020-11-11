use exam;

create table e_studentinfo(
	si_id varchar(20) primary key, 	-- 학번
    si_name varchar(20) not null, 	-- 이름
    si_birth char(10) not null, 	-- 생년월일
    si_phone char(13) not null, 	-- 전화번호
    si_zip char(5) not null, 		-- 우편번호
    si_addr1 varchar(50), 			-- 주소1
    si_addr2 varchar(50), 			-- 주소2
    si_email varchar(50) not null	-- 이메일
);

create table e_subject(
	s_id varchar(20) primary key, 	-- 과목ID
    s_name varchar(20) not null, 	-- 과목명
    s_proname varchar(20) not null 	-- 담당 교수명
);

create table e_point(
	p_num int unsigned auto_increment primary key, 	-- 일련번호
    si_id varchar(20), 								-- 학번
    s_id varchar(20), 								-- 과목ID
    p_score int default 0, 							-- 점수
    p_date datetime default now(), 					-- 시험일
    constraint fk_e_studentinfo_id foreign key(si_id) references e_studentinfo(si_id) on delete cascade,
    constraint fk_e_subject_id foreign key(s_id) references e_subject(s_id) on delete cascade
);

select * from e_studentinfo;
select * from e_subject;
select * from e_point;

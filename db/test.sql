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
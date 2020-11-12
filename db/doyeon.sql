use test;

create table t_class(
	c_id int auto_increment primary key, -- 분류번호
    c_name varchar(20) not null,		-- 분류명
    c_date datetime default now()		-- 분류 등록일
);

drop table t_class;
create table t_goods(
	g_id int auto_increment primary key, -- 상품아이디
    c_id int not null,			-- 분류번호
    g_name varchar(20) not null,			-- 상품명
    g_price int default 0,					-- 가격
    g_date datetime default now(),			-- 상품등록일
    constraint fk_t_class foreign key(c_id) references t_class(c_id) on delete cascade
);


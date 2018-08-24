-- 创建edusys数据库
create database edusys default character set utf8 collate utf8_bin;

-- 切换库
use edusys;

-- 角色信息表 
create table if not exists roleInfo(
	rid int primary key auto_increment, -- 角色编号
	rname varchar(100) not null unique, -- 角色名称
	remark varchar(200) -- 描述	
)engine=InnoDB default charset=utf8;

-- 管理员信息表
create table if not exists adminInfo(
	aid int primary key auto_increment, -- 管理员编号
	aname varchar(100) not null unique, -- 管理员
	pwd varchar(200) not null, -- 管理员密码
	rid int, -- 管理员角色
	photo varchar(200), -- 管理员图片
	remark varchar(200),  -- 描述	
	status int, -- 管理员账号状态 
	constraint FK_adminInfo_rid foreign key(rid) references roleInfo(rid)
)engine=InnoDB default charset=utf8;
alter table adminInfo auto_increment = 1001;

-- 培训方向信息表
--drop table if exists 'train';
create table if not exists train(
	tid int primary key auto_increment, -- 方向id
	tname varchar(100) not null unique, -- 方向名称  J2EE，大数据，前端
	status int
)engine=InnoDB default charset=utf8;

-- 班级信息表
create table if not exists classInfo(
	cid int primary key auto_increment, -- 班级id
	cname varchar(100) not null unique, -- 班级名称
	tid int,             -- 班级方向
	cdate date, -- 开班日期
	semester int, -- 所在学期 1,2,3
	edate date,   -- 结课日期
	status int,   -- 班级状态，已结课
	remark varchar(200),  -- 描述	
	constraint FK_classInfo_tid foreign key(tid) references train(tid)
)engine=InnoDB default charset=utf8;

-- 学生信息表
create table if not exists stuInfo(
	sid int primary key auto_increment, -- 学号
	sname varchar(100) not null,  -- 姓名
	cid int,  -- 所在班级
	pwd varchar(200) not null, -- 密码
	tel varchar(20), -- 联系方式
	cardId varchar(20), -- 身份证号码
	addr varchar(200), -- 家庭住址
	parentName varchar(100), -- 父母姓名
	parentTel varchar(20), -- 父母的联系方式
	photo varchar(200), -- 照片
	cardPositive varchar(200), -- 身份证正面照
	cardNegative varchar(200), -- 身份证背面照
	remark varchar(200), -- 描述
	spare1 varchar(200), -- 备用字段1
	spare2 varchar(200), -- 备用字段2
	status int,  -- 状态
	constraint FK_stuInfo_cid foreign key(cid) references classInfo(cid)
)engine=InnoDB default charset=utf8;

-- 考勤信息表
create table if not exists attendance(
	atid int primary key auto_increment, -- 考勤编号     1. 正常      2. 迟到      3.旷课    4. 病假   5. 事假
	aid int, -- 管理员编号
	cid int, -- 班级编号 
	adate date not null, -- 考勤日期
	timeslot int, -- 考勤时间段 1.上午     2.下午  3.晚上
	content text not null, -- 考勤记录         学号-状态-备注;学号-状态-备注;学号-状态-备注
	remark varchar(200), -- 备注
	spare1 varchar(200), -- 备用字段1
	spare2 varchar(200), -- 备用字段2
	constraint FK_attendance_aid foreign key(aid) references adminInfo(aid),
	constraint FK_attendance_cid foreign key(cid) references classInfo(cid)
)engine=InnoDB default charset=utf8;


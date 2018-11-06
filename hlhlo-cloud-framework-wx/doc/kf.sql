drop table if exists wx_kfaccount;
create table wx_kfaccount(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
	openid varchar(100) COMMENT '用户的唯一标识',
	kf_account varchar(100) COMMENT '完整客服帐号，格式为：帐号前缀@公众号微信号',
	kf_nick varchar(100) COMMENT '客服昵称',
	kf_id varchar(100) COMMENT '客服编号',
	kf_headimgurl varchar(100) COMMENT '客服头像',
	kf_wx varchar(100) COMMENT '如果客服帐号已绑定了客服人员微信号， 则此处显示微信号',
	status int default 0 COMMENT '客服在线状态，目前为：1、web 在线',
	accepted_case int default 0 COMMENT '客服当前正在接待的会话数',
	create_time datetime default now() COMMENT '创建时间',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='客服表';

-- 管理员操作的时候，数据形成，客服就只是取用。
drop table if exists wx_kfsession;
create table wx_kfsession(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
	kfaccountid  bigint(20) COMMENT '表wx_kfaccount的id',
	user_openid varchar(100) COMMENT '用户的openid',
	opercode varchar(10) COMMENT '操作码，2002（客服发送信息），2003（客服接收消息）',
	text varchar(2000) COMMENT '聊天记录',
	time datetime default now() COMMENT '操作时间',
	status int default 1 	COMMENT '当前聊天的客服是否还在接待，1：在接待；0：没再接待。', 
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='客服对应的会话表,聊天记录';

-- 用户详情表
/*drop table if exists wx_kfuser;
create table wx_kfuser(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
	openid varchar(100) COMMENT '用户的唯一标识',
	nickname varchar(100) COMMENT '用户昵称',
	headingurl varchar(100) COMMENT '用户头像',
	unionid varhcar(100) COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT=utf8 COMMENT='客服用户';
*/

insert into wx_kfaccount(kf_account,kf_nick,kf_id,kf_headimgurl,kf_wx) values('test1@test','伦美小客服','1001','','wxid_v1gb0xztu7n821');

insert into wx_kfaccount(kf_account,kf_nick,kf_id,kf_headimgurl,kf_wx) values('test2@test','小七','1002','','wxid_v1gb0xztu7n822');
insert into wx_kfaccount(kf_account,kf_nick,kf_id,kf_headimgurl,kf_wx) values('test3@test','佛系小哥哥','1003','','wxid_v1gb0xztu7n823');
insert into wx_kfaccount(kf_account,kf_nick,kf_id,kf_headimgurl,kf_wx) values('test4@test','哈尔滨小哥','1004','','wxid_v1gb0xztu7n824');

update wx_kfaccount set openid='o36WF0kwKQEOq9-l9bqAiM5Nqlf8' where id=1;
update wx_kfaccount set openid='o36WF0kwKQEOq9-l9bqAiM5Nqlf7' where id=2;
update wx_kfaccount set openid='o36WF0kwKQEOq9-l9bqAiM5Nqlf6' where id=3;
update wx_kfaccount set openid='o36WF0kwKQEOq9-l9bqAiM5Nqlf5' where id=4;
update wx_kfaccount set status=1;

-- 操作码，2002（客服发送信息），2003（客服接收消息）
insert into wx_kfsession(kfaccountid,user_openid,opercode,text) values(1,'1','2003','您好！我想咨询一下');
insert into wx_kfsession(kfaccountid,user_openid,opercode,text) values(1,'1','2002','您好！有什么可以帮助您吗？');
insert into wx_kfsession(kfaccountid,user_openid,opercode,text) values(1,'1','2002','很高兴为您服务？');
insert into wx_kfsession(kfaccountid,user_openid,opercode,text) values(1,'1','2003','1+1等于多少?');
insert into wx_kfsession(kfaccountid,user_openid,opercode,text) values(1,'1','2002','等于2');
insert into wx_kfsession(kfaccountid,user_openid,opercode,text) values(1,'1','2003','1+2等于多少?');







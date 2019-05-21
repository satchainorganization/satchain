CREATE TABLE `星座信息表`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',  
	`星座编号` VARCHAR(32) NOT NULL DEFAULT '',
	`星座名称` VARCHAR(32) DEFAULT '',
	`星座类型` TINYINT(4) COMMENT '1:遥感星座 2:通信星座 3456',
	`业主名` VARCHAR(32) DEFAULT '',
	PRIMARY KEY(`id`),
	UNIQUE KEY `idx_constellatory_uuid` (`星座编号`)
)ENGINE=INNODB DEFAULT CHARSET='utf8';

CREATE TABLE `卫星信息表`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`卫星编号` VARCHAR(32) NOT NULL DEFAULT '',
	`NASA编号` VARCHAR(32) DEFAULT '',
 	`卫星名称` VARCHAR(32) DEFAULT '',
 	`所属星座` VARCHAR(32) DEFAULT '',
 	`卫星类型` TINYINT(4),
 	`遥测频率` VARCHAR(32) DEFAULT '',
 	`遥测ERP值` VARCHAR(32) DEFAULT '',
 	`遥控频率` VARCHAR(32) DEFAULT '',
 	`遥控接收增益` VARCHAR(32) DEFAULT '',
 	`数据下行频率` VARCHAR(32) DEFAULT '',
 	`数据下行ERP值` VARCHAR(32) DEFAULT '',
 	`数据上行频率` VARCHAR(32) DEFAULT '',
 	`数据上行接收增益` VARCHAR(32) DEFAULT '',
 	`业务下行接收增益` VARCHAR(32) DEFAULT '',
 	`业务下行ERP值` VARCHAR(32) DEFAULT '',
 	`业务上行频率` VARCHAR(32) DEFAULT '',
 	`业务上行接收增益` VARCHAR(32) DEFAULT '',
 	`倾角` FLOAT(10,2),
 	`升交点赤径` FLOAT(10,2),
 	`偏心率` FLOAT(10,2),
 	`半长轴` FLOAT(10,2),
 	`近地点角距` FLOAT(10,2),
 	`近地点时刻` DATETIME DEFAULT NULL,
	PRIMARY KEY(`id`),
	UNIQUE KEY `idx_satellite_uuid` (`卫星编号`)
)ENGINE=INNODB DEFAULT CHARSET='utf8';

CREATE TABLE `地面站信息表`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`地面站编号` VARCHAR(32) DEFAULT '',
	`地面站名称` VARCHAR(32) DEFAULT '',
	`地面站类型` TINYINT(4),
	`地面站遥测频率` VARCHAR(32) DEFAULT '',
	`地面站遥测增益` VARCHAR(32) DEFAULT '',
	`地面站遥控频率` VARCHAR(32) DEFAULT '',
	`地面站遥控ERP值` VARCHAR(32) DEFAULT '',
	`数据下行频率` VARCHAR(32) DEFAULT '',
	`数据下行增益` VARCHAR(32) DEFAULT '',
	`数据上行频率` VARCHAR(32) DEFAULT '',
	`数据上行ERP值` VARCHAR(32) DEFAULT '',
	`经度` FLOAT(10,2),
	`纬度` FLOAT(10,2),
	`IP地址` VARCHAR(32) DEFAULT '',
	PRIMARY KEY(`id`),
	UNIQUE KEY `idx_ground_uuid` (`地面站编号`)
)ENGINE=INNODB DEFAULT CHARSET='utf8';

CREATE TABLE `任务分配表`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`任务编号` SMALLINT,
	`地面站编号` VARCHAR(32) DEFAULT '',
	`卫星编号` VARCHAR(32) DEFAULT '',
	`任务类型` TINYINT(4),
	`任务发布时间` DATETIME,
	`计划开始时间` DATETIME,
	`计划截止时间` DATETIME,
	`任务开始时间` DATETIME,
	`任务结束时间` DATETIME,
	`分发标志` TINYINT(4),
	`任务标志` TINYINT(1),
	`ACK` BIGINT(20),
	PRIMARY KEY(`id`),
	UNIQUE KEY `idx_task_uuid` (`任务编号`),
	UNIQUE KEY `idx_ground_uuid` (`地面站编号`),
	UNIQUE KEY `idx_satellite_uuid` (`卫星编号`)
)ENGINE=INNODB DEFAULT CHARSET='utf8';

CREATE TABLE `遥控内容表`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`任务编号` BIGINT(20),
	`任务内容` BLOB,
	PRIMARY KEY(`id`),
	UNIQUE KEY `idx_task_uuid` (`任务编号`)
)ENGINE=INNODB DEFAULT CHARSET='utf8';

CREATE TABLE `系统日志表`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`时间` DATETIME DEFAULT NULL,
	`对象` VARCHAR(32),
	`事件类型` TINYINT(4),
	`参数` VARCHAR(32),
	`备注` VARCHAR(64),
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET='utf8';

CREATE TABLE `用户信息表` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`用户名` VARCHAR(16) DEFAULT '',
	`密码` VARCHAR(16) DEFAULT '',
	`权限` TINYINT(4) default 11,
	`创建时间` DATETIME DEFAULT NULL,
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET='utf8';

CREATE TABLE `监控信息表`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`监控器位置` VARCHAR(32) DEFAULT '',
	`监控器编号` VARCHAR(32) DEFAULT '',
	`监控器连接地址` VARCHAR(32) DEFAULT '',
	PRIMARY KEY(`id`),
	UNIQUE KEY `idx_monitor_uuid` (`监控器编号`)
)ENGINE=INNODB DEFAULT CHARSET='utf8';
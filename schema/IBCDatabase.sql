drop database if exists IBCDatabase;
create database if not exists IBCDatabase default charset utf8;

use IBCDatabase;

# tip i don'know= =
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
#  tip Collate 影响的是排序的规则
#      Engine = InnoDB 则是选择了一个带事务控制（全部执行或全部不执行）引擎，
  `openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci not null UNIQUE,
  `userType` tinyint default 0,
  `isActive` boolean default 0,
  `login_time` DATETIME DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user
-- ----------------------------
# INSERT INTO `user`(username) VALUES ('Luxing');
# INSERT INTO `user`(username) VALUES ('Jerry');
# INSERT INTO `user`(username) VALUES ('Eren');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
    `infoID` int NOT NULL AUTO_INCREMENT,
    `uid` int NOT NULL,
    `version` int NOT NULL,
    `saveTimes` int default 0,
    `loginDay` int default 0,
    `letterCount` int DEFAULT 0,
    PRIMARY KEY (`infoID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user_info
-- ----------------------------
# INSERT INTO `user_info` (uid, version) VALUES (1,1);
# INSERT INTO `user_info` VALUES ('1','1','1','3000','5','0');
-- ----------------------------
-- Table structure for `user_letter`
-- ----------------------------
DROP TABLE IF EXISTS `user_letter`;
CREATE TABLE `user_letter`(
    `ulid` int NOT NULL AUTO_INCREMENT,
    `uid` int NOT NULL ,
    `lid` int NOT NULL ,
    PRIMARY KEY (`ulid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user_letter
-- ----------------------------
# INSERT INTO `user_letter` (uid, lid) VALUES ('1','1');

-- ----------------------------
-- Table structure for `letters`
-- ----------------------------
DROP TABLE IF EXISTS `letters`;
CREATE TABLE `letters`(
    `lid` int NOT NULL AUTO_INCREMENT,
    `uid` int NOT NULL,
    `content` varchar(2000) NOT NULL,
    `created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of letters
-- ----------------------------
# INSERT INTO `letters` (uid, content) VALUES ('1','我是呆滞Letter1');
# INSERT INTO `letters` (uid, content) VALUES ('1','我是呆滞Letter2');
# INSERT INTO `letters` (uid, content) VALUES ('1','我是呆滞Letter3');
-- ----------------------------
-- Table structure for `response`
-- ----------------------------
DROP TABLE IF EXISTS `response`;
CREATE TABLE `response`(
    `rid` INT NOT NULL AUTO_INCREMENT,
    `uid` INT NOT NULL ,
    `lid` INT NOT NULL ,
    `content` varchar(2000) NOT NULL,
    PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of response
-- ----------------------------
# Test GetResponse
INSERT INTO `response` (uid, lid, content) VALUES ('1','1','我是呆滞的第一条评论');
INSERT INTO `response` (uid, lid, content) VALUES ('1','1','我是呆滞的第二条评论');
INSERT INTO `response` (uid, lid, content) VALUES ('1','1','我是呆滞的第三条评论');
-- ----------------------------
-- Table structure for `timers`
-- ----------------------------
DROP TABLE IF EXISTS `timers`;
CREATE TABLE `timers`(
    `tid` INT NOT NULL AUTO_INCREMENT,
    `version` INT NOT NULL UNIQUE ,
#     86400s == 1day
    `livingTime` INT DEFAULT 86400,
    PRIMARY KEY (tid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS=1;
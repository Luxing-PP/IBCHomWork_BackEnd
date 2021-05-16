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
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci default NULL,
  `userType` tinyint default 0,
  `isActive` boolean,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1','Luxing','0','0');

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
    PRIMARY KEY (`infoID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1','1','1','3000','5');
-- ----------------------------
-- Table structure for `user_letter`
-- ----------------------------
DROP TABLE IF EXISTS `user_letter`;
CREATE TABLE `user_letter`(
    `uid` int not null ,
    `lid` int not null ,
    PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_letter
-- ----------------------------
INSERT INTO `user_letter` VALUES ('1','1');

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
INSERT INTO `letters` (lid, uid, content) VALUES ('1','1','我是呆滞XXXXXX');
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
# Null

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
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
-- Records of course
-- ----------------------------
INSERT INTO `user` VALUES ('1','Luxing','123456');
SET FOREIGN_KEY_CHECKS=1;
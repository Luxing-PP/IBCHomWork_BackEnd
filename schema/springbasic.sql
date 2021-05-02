
# i don'know= =
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS=0;

drop database if exists springbasic;
create database if not exists `springbasic` default charset utf8;

use `springbasic`;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
#  tip Collate 影响的是排序的规则
#      Engine = InnoDB 则是选择了一个带事务控制（全部执行或全部不执行）引擎，
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `user` VALUES ('1','Luxing','123456');
SET FOREIGN_KEY_CHECKS=1;
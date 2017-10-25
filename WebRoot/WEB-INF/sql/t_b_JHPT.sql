/*
Navicat MySQL Data Transfer

Source Server         : pzjt
Source Server Version : 50637
Source Host           : 60.205.186.12:3306
Source Database       : pzjt

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-11-03 14:16:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_b_JHPT
-- ----------------------------
DROP TABLE IF EXISTS `t_b_JHPT`;
CREATE TABLE `t_b_jhpt` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `YXT` varchar(225) DEFAULT NULL,
  `MBXT` varchar(225) DEFAULT NULL,
  `YB` varchar(225) DEFAULT NULL,
  `MBB` varchar(225) DEFAULT NULL,
  `SCJL` varchar(225) DEFAULT NULL,
  `XZHS` varchar(225) DEFAULT NULL,
  `GXHS` varchar(225) DEFAULT NULL,
  `CWHS` varchar(225) DEFAULT NULL,
  `ZT` varchar(225) DEFAULT NULL,
  `KSSJ` date DEFAULT NULL,
  `JSSJ` date DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `YXT` (`YXT`),
  UNIQUE KEY `MBXT` (`MBXT`),
  UNIQUE KEY `YB` (`YB`),
  UNIQUE KEY `MBB` (`MBB`),
  UNIQUE KEY `SCJL` (`SCJL`),
  UNIQUE KEY `XZHS` (`XZHS`),
  UNIQUE KEY `GXHS` (`GXHS`),
  UNIQUE KEY `CWHS` (`CWHS`),
  UNIQUE KEY `ZT` (`ZT`),
  UNIQUE KEY `KSSJ` (`KSSJ`),
  UNIQUE KEY `JSSJ` (`JSSJ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_b_JHPT
-- ----------------------------

-- ----------------------------
-- Table structure for tb_bslccflc
-- ----------------------------
DROP TABLE IF EXISTS `tb_bslccflc`;
CREATE TABLE `tb_bslccflc` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bslccflc
-- ----------------------------
INSERT INTO `tb_bslccflc` VALUES ('1', '行政处罚流程', 'tb_bslccflc.png', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_bslcjclc
-- ----------------------------
DROP TABLE IF EXISTS `tb_bslcjclc`;
CREATE TABLE `tb_bslcjclc` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bslcjclc
-- ----------------------------
INSERT INTO `tb_bslcjclc` VALUES ('1', '行政检查流程', 'tb_bslcjclc.png', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_bslcxklc
-- ----------------------------
DROP TABLE IF EXISTS `tb_bslcxklc`;
CREATE TABLE `tb_bslcxklc` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bslcxklc
-- ----------------------------
INSERT INTO `tb_bslcxklc` VALUES ('1', '行政许可流程', 'tb_bslcxklc.png', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_bslczzlc
-- ----------------------------
DROP TABLE IF EXISTS `tb_bslczzlc`;
CREATE TABLE `tb_bslczzlc` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bslczzlc
-- ----------------------------
INSERT INTO `tb_bslczzlc` VALUES ('1', '行政强制流程', 'tb_bslczzlc.png', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_classroom
-- ----------------------------
DROP TABLE IF EXISTS `tb_classroom`;
CREATE TABLE `tb_classroom` (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(20) NOT NULL,
  PRIMARY KEY (`classId`),
  UNIQUE KEY `className` (`className`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_classroom
-- ----------------------------

-- ----------------------------
-- Table structure for tb_fjjtdt
-- ----------------------------
DROP TABLE IF EXISTS `tb_fjjtdt`;
CREATE TABLE `tb_fjjtdt` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_fjjtdt
-- ----------------------------

-- ----------------------------
-- Table structure for tb_fjlbt
-- ----------------------------
DROP TABLE IF EXISTS `tb_fjlbt`;
CREATE TABLE `tb_fjlbt` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_fjlbt
-- ----------------------------

-- ----------------------------
-- Table structure for tb_fjqdym
-- ----------------------------
DROP TABLE IF EXISTS `tb_fjqdym`;
CREATE TABLE `tb_fjqdym` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_fjqdym
-- ----------------------------

-- ----------------------------
-- Table structure for tb_fjrmjx
-- ----------------------------
DROP TABLE IF EXISTS `tb_fjrmjx`;
CREATE TABLE `tb_fjrmjx` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_fjrmjx
-- ----------------------------

-- ----------------------------
-- Table structure for tb_fjyqlj
-- ----------------------------
DROP TABLE IF EXISTS `tb_fjyqlj`;
CREATE TABLE `tb_fjyqlj` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_fjyqlj
-- ----------------------------

-- ----------------------------
-- Table structure for tb_GxzdCwgk
-- ----------------------------
DROP TABLE IF EXISTS `tb_GxzdCwgk`;
CREATE TABLE `tb_gxzdcwgk` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_GxzdCwgk
-- ----------------------------
INSERT INTO `tb_GxzdCwgk` VALUES ('1', '政务公开制度', '第一条　为规范交通运输行政执法行为，深入推进依法行政，保证交通运输行政执法的公开、公正，维护公民、法人和其他组织的合法权益，制定本制度。\r\n第二条　局属各执法单位的行政执法公示工作，应当遵守本制度。\r\n第三条　本制度所称行政执法公示是指局属各执法单位通过一定方式，依法将本机关行政执法信息向社会公开，接受社会监督的行为。\r\n第四条　行政执法公示应当遵循合法、及时、准确、便民的原则。\r\n第五条　局法制教育科负责指导、协调、监督本局行政执法公示工作。\r\n第六条　局属各执法单位应当建立健全行政执法公示工作机制，明确行政执法公示工作的具体科室及人员、工作职责、公示时限、纠错机制、监督措施等。建立完善公示程序，规范公示行为，提高公示效率。\r\n第七条  落实表明身份制度：\r\n（一）交通运输行政执法人员在上路巡查、航道巡查、登船检查、入企检查时必须随身携带执法证件，进行询问、检查、勘验、扣车（船）、强拆等执法活动，要主动出示执法证件，向行政相对人表明身份，公示自己的姓名、单位、执法证号以及监督途径。\r\n（二）在行政审批大厅、运政服务大厅、（路政、海事、航道、港口）政务服务窗口等交通运输行业窗口执法单位，必须在窗口明显位置公示执法人员的身份信息、岗位信息、监督途径。 \r\n第八条　局属各执法单位下列行政执法信息应当公示:\r\n（一）行政执法机关的机构设置、职能、权限、执法人员和依据；\r\n（二）委托及受委托执法的依据、事项、权限、期限、双方权利义务、法律责任；\r\n（三）行政处罚依据、种类、范围、幅度、程序、当事人姓名（名称）、违法事实、处罚决定、执行情况；\r\n（四）行政许可事项、依据、条件、数量、程序、期限、申请人姓名（名称）、许可决定；\r\n（五）行政强制依据、种类、权限、范围、条件、程序、当事人姓名（名称）、事实与理由、结果；\r\n（六）行政征收征用依据；权限、标准、程序，相关补偿、补助费用的发放与使用情况；\r\n（七）行政给付依据、种类、数额、标准、程序、结果；\r\n（八）行政确认依据、事项、条件、程序、期限、费用；\r\n（九）行政裁量标准；\r\n（十）社会信用评价标准，守信激励和失信惩戒情况；\r\n（十一）行政相对人救济途径、方式和期限等权利；\r\n（十二）行政执法机关办公地址、办公时间、联系电话、电子邮箱、网址；\r\n（十三）举报投诉方式、途径和受理反馈程序；\r\n（十四）便民服务、承诺和措施；\r\n（十五）其他依法依规应当公示的行政执法信息。\r\n第九条　行政许可、行政确认等事项，各执法单位应当公示办理情况的动态信息。\r\n第十条　行政执法公示的信息涉及其他行政执法单位的，应当与有关行政执法单位沟通、确认，保证行政执法公示内容的准确性、一致性。\r\n第十一条　各执法单位应当建立健全行政执法公示信息的保密审查机制，明确审查的程序和责任。涉及国家秘密、商业秘密、个人隐私以及依法依规应当保密的，不得公示。\r\n第十二条　行政执法公示主要采用以下方式：\r\n（一）办公场所设置公示栏公示；\r\n（二）行政权力网上公开透明运行系统公示；\r\n（三）政府公共信用信息系统公示。\r\n除前款规定的公示方式外，各执法单位还可以采用发布公告、印发公示册、公示卡或可变情报板信息化工具和微信、微博、手机APP等移动信息载体的辅助方式进行公示。\r\n第十三条　各执法单位应当及时更新公示信息。行政执法信息形成或者变更之日起7个工作日内，应当予以公示。法律、法规、规章另有规定的，从其规定。\r\n第十四条　当事人对公示的行政执法信息要求说明、解释的，相关执法单位应当说明、解释。\r\n第十五条　各执法单位应当加强行政执法信息平台建设，实现执法信息资源共享。要将执法公示制度与行政执法其他制度相衔接，注重发挥公示结果在其他交通运输执法制度、行业形象宣传和社会信用体系建设中的作用。\r\n第十六条　局法制教育科应当建立行政执法公示工作考核、评议制度，定期对行政执法公示工作进行考核。\r\n第十七条　各执法单位违反本制度，有下列情形之一的，局法制教育科应当责令限期改正；情节严重的，由局监察室对直接负责的主管人员和其他直接责任人员依法给予行政处分：\r\n（一）不依法履行行政执法公示义务的；\r\n（二）未及时更新行政执法公示信息的；\r\n（三）将禁止公示的行政执法信息予以公示的；\r\n（四）违反本制度的其他行为。\r\n第十八条　本制度自2017年8月1日起施行，原制度同时废止。', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_GxzdSsfa
-- ----------------------------
DROP TABLE IF EXISTS `tb_GxzdSsfa`;
CREATE TABLE `tb_gxzdssfa` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_GxzdSsfa
-- ----------------------------
INSERT INTO `tb_GxzdSsfa` VALUES ('1', '实施方案', '第一条　为规范交通运输行政执法行为，深入推进依法行政，保证交通运输行政执法的公开、公正，维护公民、法人和其他组织的合法权益，制定本制度。\r\n第二条　局属各执法单位的行政执法公示工作，应当遵守本制度。\r\n第三条　本制度所称行政执法公示是指局属各执法单位通过一定方式，依法将本机关行政执法信息向社会公开，接受社会监督的行为。\r\n第四条　行政执法公示应当遵循合法、及时、准确、便民的原则。\r\n第五条　局法制教育科负责指导、协调、监督本局行政执法公示工作。\r\n第六条　局属各执法单位应当建立健全行政执法公示工作机制，明确行政执法公示工作的具体科室及人员、工作职责、公示时限、纠错机制、监督措施等。建立完善公示程序，规范公示行为，提高公示效率。\r\n第七条  落实表明身份制度：\r\n（一）交通运输行政执法人员在上路巡查、航道巡查、登船检查、入企检查时必须随身携带执法证件，进行询问、检查、勘验、扣车（船）、强拆等执法活动，要主动出示执法证件，向行政相对人表明身份，公示自己的姓名、单位、执法证号以及监督途径。\r\n（二）在行政审批大厅、运政服务大厅、（路政、海事、航道、港口）政务服务窗口等交通运输行业窗口执法单位，必须在窗口明显位置公示执法人员的身份信息、岗位信息、监督途径。 \r\n第八条　局属各执法单位下列行政执法信息应当公示:\r\n（一）行政执法机关的机构设置、职能、权限、执法人员和依据；\r\n（二）委托及受委托执法的依据、事项、权限、期限、双方权利义务、法律责任；\r\n（三）行政处罚依据、种类、范围、幅度、程序、当事人姓名（名称）、违法事实、处罚决定、执行情况；\r\n（四）行政许可事项、依据、条件、数量、程序、期限、申请人姓名（名称）、许可决定；\r\n（五）行政强制依据、种类、权限、范围、条件、程序、当事人姓名（名称）、事实与理由、结果；\r\n（六）行政征收征用依据；权限、标准、程序，相关补偿、补助费用的发放与使用情况；\r\n（七）行政给付依据、种类、数额、标准、程序、结果；\r\n（八）行政确认依据、事项、条件、程序、期限、费用；\r\n（九）行政裁量标准；\r\n（十）社会信用评价标准，守信激励和失信惩戒情况；\r\n（十一）行政相对人救济途径、方式和期限等权利；\r\n（十二）行政执法机关办公地址、办公时间、联系电话、电子邮箱、网址；\r\n（十三）举报投诉方式、途径和受理反馈程序；\r\n（十四）便民服务、承诺和措施；\r\n（十五）其他依法依规应当公示的行政执法信息。\r\n第九条　行政许可、行政确认等事项，各执法单位应当公示办理情况的动态信息。\r\n第十条　行政执法公示的信息涉及其他行政执法单位的，应当与有关行政执法单位沟通、确认，保证行政执法公示内容的准确性、一致性。\r\n第十一条　各执法单位应当建立健全行政执法公示信息的保密审查机制，明确审查的程序和责任。涉及国家秘密、商业秘密、个人隐私以及依法依规应当保密的，不得公示。\r\n第十二条　行政执法公示主要采用以下方式：\r\n（一）办公场所设置公示栏公示；\r\n（二）行政权力网上公开透明运行系统公示；\r\n（三）政府公共信用信息系统公示。\r\n除前款规定的公示方式外，各执法单位还可以采用发布公告、印发公示册、公示卡或可变情报板信息化工具和微信、微博、手机APP等移动信息载体的辅助方式进行公示。\r\n第十三条　各执法单位应当及时更新公示信息。行政执法信息形成或者变更之日起7个工作日内，应当予以公示。法律、法规、规章另有规定的，从其规定。\r\n第十四条　当事人对公示的行政执法信息要求说明、解释的，相关执法单位应当说明、解释。\r\n第十五条　各执法单位应当加强行政执法信息平台建设，实现执法信息资源共享。要将执法公示制度与行政执法其他制度相衔接，注重发挥公示结果在其他交通运输执法制度、行业形象宣传和社会信用体系建设中的作用。\r\n第十六条　局法制教育科应当建立行政执法公示工作考核、评议制度，定期对行政执法公示工作进行考核。\r\n第十七条　各执法单位违反本制度，有下列情形之一的，局法制教育科应当责令限期改正；情节严重的，由局监察室对直接负责的主管人员和其他直接责任人员依法给予行政处分：\r\n（一）不依法履行行政执法公示义务的；\r\n（二）未及时更新行政执法公示信息的；\r\n（三）将禁止公示的行政执法信息予以公示的；\r\n（四）违反本制度的其他行为。\r\n第十八条　本制度自2017年8月1日起施行，原制度同时废止。', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_GxzdZfgs
-- ----------------------------
DROP TABLE IF EXISTS `tb_GxzdZfgs`;
CREATE TABLE `tb_gxzdzfgs` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_GxzdZfgs
-- ----------------------------
INSERT INTO `tb_GxzdZfgs` VALUES ('1', '邳州市交通运输局行政执法公示制度', '第一条　为规范交通运输行政执法行为，深入推进依法行政，保证交通运输行政执法的公开、公正，维护公民、法人和其他组织的合法权益，制定本制度。\r\n第二条　局属各执法单位的行政执法公示工作，应当遵守本制度。\r\n第三条　本制度所称行政执法公示是指局属各执法单位通过一定方式，依法将本机关行政执法信息向社会公开，接受社会监督的行为。\r\n第四条　行政执法公示应当遵循合法、及时、准确、便民的原则。\r\n第五条　局法制教育科负责指导、协调、监督本局行政执法公示工作。\r\n第六条　局属各执法单位应当建立健全行政执法公示工作机制，明确行政执法公示工作的具体科室及人员、工作职责、公示时限、纠错机制、监督措施等。建立完善公示程序，规范公示行为，提高公示效率。\r\n第七条  落实表明身份制度：\r\n（一）交通运输行政执法人员在上路巡查、航道巡查、登船检查、入企检查时必须随身携带执法证件，进行询问、检查、勘验、扣车（船）、强拆等执法活动，要主动出示执法证件，向行政相对人表明身份，公示自己的姓名、单位、执法证号以及监督途径。\r\n（二）在行政审批大厅、运政服务大厅、（路政、海事、航道、港口）政务服务窗口等交通运输行业窗口执法单位，必须在窗口明显位置公示执法人员的身份信息、岗位信息、监督途径。 \r\n第八条　局属各执法单位下列行政执法信息应当公示:\r\n（一）行政执法机关的机构设置、职能、权限、执法人员和依据；\r\n（二）委托及受委托执法的依据、事项、权限、期限、双方权利义务、法律责任；\r\n（三）行政处罚依据、种类、范围、幅度、程序、当事人姓名（名称）、违法事实、处罚决定、执行情况；\r\n（四）行政许可事项、依据、条件、数量、程序、期限、申请人姓名（名称）、许可决定；\r\n（五）行政强制依据、种类、权限、范围、条件、程序、当事人姓名（名称）、事实与理由、结果；\r\n（六）行政征收征用依据；权限、标准、程序，相关补偿、补助费用的发放与使用情况；\r\n（七）行政给付依据、种类、数额、标准、程序、结果；\r\n（八）行政确认依据、事项、条件、程序、期限、费用；\r\n（九）行政裁量标准；\r\n（十）社会信用评价标准，守信激励和失信惩戒情况；\r\n（十一）行政相对人救济途径、方式和期限等权利；\r\n（十二）行政执法机关办公地址、办公时间、联系电话、电子邮箱、网址；\r\n（十三）举报投诉方式、途径和受理反馈程序；\r\n（十四）便民服务、承诺和措施；\r\n（十五）其他依法依规应当公示的行政执法信息。\r\n第九条　行政许可、行政确认等事项，各执法单位应当公示办理情况的动态信息。\r\n第十条　行政执法公示的信息涉及其他行政执法单位的，应当与有关行政执法单位沟通、确认，保证行政执法公示内容的准确性、一致性。\r\n第十一条　各执法单位应当建立健全行政执法公示信息的保密审查机制，明确审查的程序和责任。涉及国家秘密、商业秘密、个人隐私以及依法依规应当保密的，不得公示。\r\n第十二条　行政执法公示主要采用以下方式：\r\n（一）办公场所设置公示栏公示；\r\n（二）行政权力网上公开透明运行系统公示；\r\n（三）政府公共信用信息系统公示。\r\n除前款规定的公示方式外，各执法单位还可以采用发布公告、印发公示册、公示卡或可变情报板信息化工具和微信、微博、手机APP等移动信息载体的辅助方式进行公示。\r\n第十三条　各执法单位应当及时更新公示信息。行政执法信息形成或者变更之日起7个工作日内，应当予以公示。法律、法规、规章另有规定的，从其规定。\r\n第十四条　当事人对公示的行政执法信息要求说明、解释的，相关执法单位应当说明、解释。\r\n第十五条　各执法单位应当加强行政执法信息平台建设，实现执法信息资源共享。要将执法公示制度与行政执法其他制度相衔接，注重发挥公示结果在其他交通运输执法制度、行业形象宣传和社会信用体系建设中的作用。\r\n第十六条　局法制教育科应当建立行政执法公示工作考核、评议制度，定期对行政执法公示工作进行考核。\r\n第十七条　各执法单位违反本制度，有下列情形之一的，局法制教育科应当责令限期改正；情节严重的，由局监察室对直接负责的主管人员和其他直接责任人员依法给予行政处分：\r\n（一）不依法履行行政执法公示义务的；\r\n（二）未及时更新行政执法公示信息的；\r\n（三）将禁止公示的行政执法信息予以公示的；\r\n（四）违反本制度的其他行为。\r\n第十八条　本制度自2017年8月1日起施行，原制度同时废止。', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `passWord` varchar(32) NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`studentId`),
  UNIQUE KEY `userName` (`userName`),
  KEY `FK9007E96A94FB2617` (`classId`),
  CONSTRAINT `FK9007E96A94FB2617` FOREIGN KEY (`classId`) REFERENCES `tb_classroom` (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------

-- ----------------------------
-- Table structure for tb_zfjgcfjg
-- ----------------------------
DROP TABLE IF EXISTS `tb_zfjgcfjg`;
CREATE TABLE `tb_zfjgcfjg` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zfjgcfjg
-- ----------------------------

-- ----------------------------
-- Table structure for tb_zfjgjcjg
-- ----------------------------
DROP TABLE IF EXISTS `tb_zfjgjcjg`;
CREATE TABLE `tb_zfjgjcjg` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zfjgjcjg
-- ----------------------------

-- ----------------------------
-- Table structure for tb_zfjgxkjg
-- ----------------------------
DROP TABLE IF EXISTS `tb_zfjgxkjg`;
CREATE TABLE `tb_zfjgxkjg` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zfjgxkjg
-- ----------------------------

-- ----------------------------
-- Table structure for tb_zfjj1
-- ----------------------------
DROP TABLE IF EXISTS `tb_zfjj1`;
CREATE TABLE `tb_zfjj1` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zfjj1
-- ----------------------------

-- ----------------------------
-- Table structure for tb_zfjj2
-- ----------------------------
DROP TABLE IF EXISTS `tb_zfjj2`;
CREATE TABLE `tb_zfjj2` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zfjj2
-- ----------------------------

-- ----------------------------
-- Table structure for tb_zfjj3
-- ----------------------------
DROP TABLE IF EXISTS `tb_zfjj3`;
CREATE TABLE `tb_zfjj3` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zfjj3
-- ----------------------------

-- ----------------------------
-- Table structure for tb_zfqxjcsx
-- ----------------------------
DROP TABLE IF EXISTS `tb_zfqxjcsx`;
CREATE TABLE `tb_zfqxjcsx` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zfqxjcsx
-- ----------------------------

-- ----------------------------
-- Table structure for tb_zfqxqlsx
-- ----------------------------
DROP TABLE IF EXISTS `tb_zfqxqlsx`;
CREATE TABLE `tb_zfqxqlsx` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zfqxqlsx
-- ----------------------------

-- ----------------------------
-- Table structure for tb_zfqxzrsx
-- ----------------------------
DROP TABLE IF EXISTS `tb_zfqxzrsx`;
CREATE TABLE `tb_zfqxzrsx` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zfqxzrsx
-- ----------------------------

-- ----------------------------
-- Table structure for tb_ztyjdfhsc
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztyjdfhsc`;
CREATE TABLE `tb_ztyjdfhsc` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztyjdfhsc
-- ----------------------------
INSERT INTO `tb_ztyjdfhsc` VALUES ('1', '邳州市地方海事处', '1、《中华人民共和国水污染防治法》\\n\r\n2、《中华人民共和国内河交通安全管理条例》\\n\r\n3、《中华人民共和国船员条例》\\n\r\n4、《江苏省内河交通管理条例》\\n\r\n5、《江苏省水上搜寻救助条例》\\n\r\n6、《江苏省内河水域船舶污染防治条例》\\n', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_ztyjgkglc
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztyjgkglc`;
CREATE TABLE `tb_ztyjgkglc` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztyjgkglc
-- ----------------------------
INSERT INTO `tb_ztyjgkglc` VALUES ('1', '邳州市港口管理处', '1、《中华人民共和国港口法》\\n\r\n2、《江苏省港口条例》\\n', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_ztyjglglz
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztyjglglz`;
CREATE TABLE `tb_ztyjglglz` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztyjglglz
-- ----------------------------
INSERT INTO `tb_ztyjglglz` VALUES ('1', '邳州市公路管理站', '1、《中华人民共和国公路法》\r\n2、《公路安全保护条例》\r\n3、《江苏省公路条例》', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_ztyjhdglz
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztyjhdglz`;
CREATE TABLE `tb_ztyjhdglz` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztyjhdglz
-- ----------------------------
INSERT INTO `tb_ztyjhdglz` VALUES ('1', '邳州市航道管理站', '1、《中华人民共和国航道法》\\n\r\n2、《江苏省航道管理条例》\\n', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_ztyjjtgczl
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztyjjtgczl`;
CREATE TABLE `tb_ztyjjtgczl` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztyjjtgczl
-- ----------------------------
INSERT INTO `tb_ztyjjtgczl` VALUES ('1', '邳州市交通工程质量监督站', '接受委托执法，行使交通运输局相关法律法规', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_ztyjjtysgls
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztyjjtysgls`;
CREATE TABLE `tb_ztyjjtysgls` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztyjjtysgls
-- ----------------------------
INSERT INTO `tb_ztyjjtysgls` VALUES ('1', '邳州市交通运输管理所', '1、《中华人民共和国道路运输条例》\\n\r\n2、《江苏省道路运输条例》\\n\r\n3、《徐州市出租汽车客运条例》\\n', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_ztyjjtysj
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztyjjtysj`;
CREATE TABLE `tb_ztyjjtysj` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztyjjtysj
-- ----------------------------
INSERT INTO `tb_ztyjjtysj` VALUES ('1', '邳州市交通运输局', '1、《中华人民共和国招标投标法》\\n\r\n2、《中华人民共和国公路法》\\n\r\n3、《中华人民共和国航道法》\\n\r\n4、《中华人民共和国港口法》\\n\r\n5、《建设工程质量管理条例》\\n\r\n6、《建设工程勘察设计管理条例》\\n', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_ztyjxzjt
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztyjxzjt`;
CREATE TABLE `tb_ztyjxzjt` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Person` (`Person`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztyjxzjt
-- ----------------------------
INSERT INTO `tb_ztyjxzjt` VALUES ('1', '邳州市乡镇交通运输综合管理所', '执行运管、公路、海事、航道、港口相关法律法规。', '2017-10-10', '邳州市交通运输局');

-- ----------------------------
-- Table structure for tb_ztzddfhsc
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztzddfhsc`;
CREATE TABLE `tb_ztzddfhsc` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Nszfks` varchar(20) NOT NULL,
  `Zfxz` varchar(20) NOT NULL,
  `Zfrs` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  `keShi` varchar(20) NOT NULL,
  `xingZhi` varchar(20) NOT NULL,
  `renShu` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Nszfks` (`Nszfks`),
  UNIQUE KEY `Zfxz` (`Zfxz`),
  UNIQUE KEY `Zfrs` (`Zfrs`),
  UNIQUE KEY `Person` (`Person`),
  UNIQUE KEY `keShi` (`keShi`),
  UNIQUE KEY `xingZhi` (`xingZhi`),
  UNIQUE KEY `renShu` (`renShu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztzddfhsc
-- ----------------------------
INSERT INTO `tb_ztzddfhsc` VALUES ('1', '邳州市地方海事处', '内设执法科室：航监科 船检科 法制科\r\n执法性质：法律法规授权组织\r\n执法人数：107\r\n工作职责： \r\n 1、宣传贯彻执行国家有关水上交通安全法律、法规、规章，依法实施现场监督管理，查处违反水上交通安全管理的行为；\r\n  2、实施辖区防治船舶污染水域监督管理；\r\n  3、负责水上交通事故和船舶污染水域事故的调查处理工作。', '2017-10-10', '航监科\\n船检科\\n法制科', '法律法规授权组织', '107', '邳州市交通运输局', '航监科\\n船检科\\n法制科', '法律法规授权组织', '107');

-- ----------------------------
-- Table structure for tb_ztzdgkglc
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztzdgkglc`;
CREATE TABLE `tb_ztzdgkglc` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Nszfks` varchar(20) NOT NULL,
  `Zfxz` varchar(20) NOT NULL,
  `Zfrs` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  `keShi` varchar(20) NOT NULL,
  `xingZhi` varchar(20) NOT NULL,
  `renShu` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Nszfks` (`Nszfks`),
  UNIQUE KEY `Zfxz` (`Zfxz`),
  UNIQUE KEY `Zfrs` (`Zfrs`),
  UNIQUE KEY `Person` (`Person`),
  UNIQUE KEY `keShi` (`keShi`),
  UNIQUE KEY `xingZhi` (`xingZhi`),
  UNIQUE KEY `renShu` (`renShu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztzdgkglc
-- ----------------------------
INSERT INTO `tb_ztzdgkglc` VALUES ('1', '邳州市港口管理处', '内设执法科室：安全监督科 规划科 港政执法中队\r\n执法性质：法律法规授权组织\r\n执法人数：38\r\n工作职责：  \r\n  1、编制港口总体规划；负责对全市港口的岸线、陆域、水域实施统一管理；负责组织对全市港口公用基础设施的建设、维护和管理工作；\r\n 2、负责对全市港口建设市场秩序、经营秩序、安全生产秩序、环境保护秩序等实施监督和管理。', '2017-10-10', '安全监督科\\n规划科\\n港政执法中队', '法律法规授权组织', '38', '邳州市交通运输局', '安全监督科\\n规划科\\n港政执法中队', '法律法规授权组织', '38');

-- ----------------------------
-- Table structure for tb_ztzdglglz
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztzdglglz`;
CREATE TABLE `tb_ztzdglglz` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Nszfks` varchar(20) NOT NULL,
  `Zfxz` varchar(20) NOT NULL,
  `Zfrs` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  `keShi` varchar(20) NOT NULL,
  `xingZhi` varchar(20) NOT NULL,
  `renShu` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Nszfks` (`Nszfks`),
  UNIQUE KEY `Zfxz` (`Zfxz`),
  UNIQUE KEY `Zfrs` (`Zfrs`),
  UNIQUE KEY `Person` (`Person`),
  UNIQUE KEY `keShi` (`keShi`),
  UNIQUE KEY `xingZhi` (`xingZhi`),
  UNIQUE KEY `renShu` (`renShu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztzdglglz
-- ----------------------------
INSERT INTO `tb_ztzdglglz` VALUES ('1', '邳州市公路管理站', '内设执法科室：路政科 超限治理科\r\n执法性质：法律法规授权组织\r\n执法人数：49\r\n工作职责：\r\n  负责全市国省干线公路建设、养护、路政管理、通行费征收和县道养护管理工作。', '2017-10-10', '路政科\\n超限治理科', '法律法规授权组织', '49', '邳州市交通运输局', '路政科\\n超限治理科', '法律法规授权组织', '49');

-- ----------------------------
-- Table structure for tb_ztzdhdglz
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztzdhdglz`;
CREATE TABLE `tb_ztzdhdglz` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Nszfks` varchar(20) NOT NULL,
  `Zfxz` varchar(20) NOT NULL,
  `Zfrs` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  `keShi` varchar(20) NOT NULL,
  `xingZhi` varchar(20) NOT NULL,
  `renShu` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Nszfks` (`Nszfks`),
  UNIQUE KEY `Zfxz` (`Zfxz`),
  UNIQUE KEY `Zfrs` (`Zfrs`),
  UNIQUE KEY `Person` (`Person`),
  UNIQUE KEY `keShi` (`keShi`),
  UNIQUE KEY `xingZhi` (`xingZhi`),
  UNIQUE KEY `renShu` (`renShu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztzdhdglz
-- ----------------------------
INSERT INTO `tb_ztzdhdglz` VALUES ('1', '邳州市航道管理站', '内设执法科室：航政科\r\n执法性质：法律法规授权组织\r\n执法人数：17\r\n工作职责：\r\n  1、为航道畅通提供维护、管理保障；\r\n  2、负责航道养护、航道行政管理与执法、相关规费征收管理与稽查、相关科研与设计及航运建设项目管理等。', '2017-10-10', '航政科', '法律法规授权组织', '17', '邳州市交通运输局', '航政科', '法律法规授权组织', '17');

-- ----------------------------
-- Table structure for tb_ztzdjtgczl
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztzdjtgczl`;
CREATE TABLE `tb_ztzdjtgczl` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Nszfks` varchar(20) NOT NULL,
  `Zfxz` varchar(20) NOT NULL,
  `Zfrs` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  `keShi` varchar(20) NOT NULL,
  `xingZhi` varchar(20) NOT NULL,
  `renShu` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Nszfks` (`Nszfks`),
  UNIQUE KEY `Zfxz` (`Zfxz`),
  UNIQUE KEY `Zfrs` (`Zfrs`),
  UNIQUE KEY `Person` (`Person`),
  UNIQUE KEY `keShi` (`keShi`),
  UNIQUE KEY `xingZhi` (`xingZhi`),
  UNIQUE KEY `renShu` (`renShu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztzdjtgczl
-- ----------------------------
INSERT INTO `tb_ztzdjtgczl` VALUES ('1', '邳州市交通工程质量监督站', '内设执法科室：质量监督科 安全监管科\r\n执法性质：受委托执法组织\r\n执法人数：4\r\n工作职责：\r\n  1、负责邳州市交通工程的质量监督；\r\n  2、负责全市交通工程交竣工验收质量鉴定及优质工程评选申报；\r\n  3、负责全市交通工程施工、设计、监理单位资质管理。', '2017-10-10', '质量监督科\\n安全监管科', '受委托执法组织', '4', '邳州市交通运输局', '质量监督科\\n安全监管科', '受委托执法组织', '4');

-- ----------------------------
-- Table structure for tb_ztzdjtysgls
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztzdjtysgls`;
CREATE TABLE `tb_ztzdjtysgls` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Nszfks` varchar(20) NOT NULL,
  `Zfxz` varchar(20) NOT NULL,
  `Zfrs` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  `keShi` varchar(20) NOT NULL,
  `xingZhi` varchar(20) NOT NULL,
  `renShu` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Nszfks` (`Nszfks`),
  UNIQUE KEY `Zfxz` (`Zfxz`),
  UNIQUE KEY `Zfrs` (`Zfrs`),
  UNIQUE KEY `Person` (`Person`),
  UNIQUE KEY `keShi` (`keShi`),
  UNIQUE KEY `xingZhi` (`xingZhi`),
  UNIQUE KEY `renShu` (`renShu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztzdjtysgls
-- ----------------------------
INSERT INTO `tb_ztzdjtysgls` VALUES ('1', '邳州市交通运输管理所', '内设执法科室：客运科 货运科 维修科 驾培科\r\n执法性质：法律法规授权组织\r\n执法人数：285\r\n工作职责：\r\n  1、做好运输市场的调查研究和预测，制订本市运输行业发展规划，参与站、场枢纽规划建设；\r\n  2、负责全市道路交通运输、搬运装卸和运输服务业的行业管理，会同有关部门规划和管理运输市场；  \r\n  3、负责全市机动车维修市场、机动车综合性能检测站、机动车驾驶员培训和驾驶学校的行业管理；\r\n  4、按管理权限审批客运、货运、机动车维修、搬运装卸、运输服务、机动车驾驶员培训的开业、停业、歇业申请及合理统筹安排县（市）内客运线路，核发道路运输经营许可证和配发道路营运证。', '2017-10-10', '客运科\\n货运科\\n维修科\\n驾培科', '法律法规授权组织', '285', '邳州市交通运输局', '客运科\\n货运科\\n维修科\\n驾培科', '法律法规授权组织', '285');

-- ----------------------------
-- Table structure for tb_ztzdjtysj
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztzdjtysj`;
CREATE TABLE `tb_ztzdjtysj` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Nszfks` varchar(20) NOT NULL,
  `Zfxz` varchar(20) NOT NULL,
  `Zfrs` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  `keShi` varchar(20) NOT NULL,
  `xingZhi` varchar(20) NOT NULL,
  `renShu` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Nszfks` (`Nszfks`),
  UNIQUE KEY `Zfxz` (`Zfxz`),
  UNIQUE KEY `Zfrs` (`Zfrs`),
  UNIQUE KEY `Person` (`Person`),
  UNIQUE KEY `keShi` (`keShi`),
  UNIQUE KEY `xingZhi` (`xingZhi`),
  UNIQUE KEY `renShu` (`renShu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztzdjtysj
-- ----------------------------
INSERT INTO `tb_ztzdjtysj` VALUES ('1', '邳州市交通运输局', '内设执法科室：法制教育科 安全科 工程科\r\n执法性质：法定行政机关\r\n执法人数：19\r\n工作职责：\r\n  1、组织编制全市综合运输体系规划；组织拟订并监督实施公路、航道、港口、地方铁路和交通物流业等行业规划和计划；负责编制城市公共交通发展规划，拟订城市公共交通和出租车行业规范并实施监督；\r\n  2、负责全市交通运输基础设施建设和维护的行业管理工作；负责交通工程的质量监督；\r\n  3、承担全市道路、水路运输市场监管职责；负责城市公共交通和出租汽车行业管理，指导城乡客运一体化建设；\r\n  4、负责全市路政、运政、航政、港政等行政执法工作；负责本市通航水域及其他水域、港口的水上安全监督、内河救助打捞、水上交通事故的调查处理工作。', '2017-10-10', '法制教育科\\n安全科\\n工程科', '法定行政机关', '19', '邳州市交通运输局', '法制教育科\\n安全科\\n工程科', '法定行政机关', '19');

-- ----------------------------
-- Table structure for tb_ztzdxzjt
-- ----------------------------
DROP TABLE IF EXISTS `tb_ztzdxzjt`;
CREATE TABLE `tb_ztzdxzjt` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Content` longtext,
  `Date` varchar(20) NOT NULL,
  `Nszfks` varchar(20) NOT NULL,
  `Zfxz` varchar(20) NOT NULL,
  `Zfrs` varchar(20) NOT NULL,
  `Person` varchar(20) NOT NULL,
  `keShi` varchar(20) NOT NULL,
  `xingZhi` varchar(20) NOT NULL,
  `renShu` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Date` (`Date`),
  UNIQUE KEY `Nszfks` (`Nszfks`),
  UNIQUE KEY `Zfxz` (`Zfxz`),
  UNIQUE KEY `Zfrs` (`Zfrs`),
  UNIQUE KEY `Person` (`Person`),
  UNIQUE KEY `keShi` (`keShi`),
  UNIQUE KEY `xingZhi` (`xingZhi`),
  UNIQUE KEY `renShu` (`renShu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ztzdxzjt
-- ----------------------------
INSERT INTO `tb_ztzdxzjt` VALUES ('1', '邳州市乡镇交通运输综合管理所', '内设执法科室：业务科 安全科 法制科\r\n执法性质：法律法规授权组织\r\n执法人数：146\r\n工作职责：\r\n  1、负责乡镇道路客货运输组织协调工作；\r\n  2、负责辖区内乡道的路政巡查和乡道两侧建筑控制区的管理工作；\r\n  3、负责等外级航道上码头建设管理、装卸经营秩序维护。对等外级航道上发生的交通运输违法行为进行制止、教育，并协助地方海事机构实施查处。', '2017-10-10', '业务科\\n安全科\\n法制科', '法律法规授权组织', '146', '邳州市交通运输局', '业务科\\n安全科\\n法制科', '法律法规授权组织', '146');

/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80046
 Source Host           : localhost:3306
 Source Schema         : k6platform_db

 Target Server Type    : MySQL
 Target Server Version : 80046
 File Encoding         : 65001

 Date: 24/08/2026 18:33:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `telephone` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `portrait_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (1, 'admin', '男', '6ad4664ba23eac71b5ef5e826ea0c6cd', '123@qq.com', '18999999999', '湖北省黄冈市', 'public/61ea081810024fb38ba0e89b8a2dc2a6507k.png');
INSERT INTO `tb_admin` VALUES (2, 'xia', '男', 'e10adc3949ba59abbe56e057f20f883e', '111@qq.com', '13119999999', '广州', '7271a1b3675440cc8ab01c4cf5e8438d61k.png');
INSERT INTO `tb_admin` VALUES (3, 'zhansan', '女', '74e59720dd08b1db45f7152d082c5051', 'qwqw@qq.com', '18999999999', '北京', 'd4b04e4167cf4fdf9701661655d3a327123.png');
INSERT INTO `tb_admin` VALUES (4, '帆帆帆帆', '女', 'c26be8aaf53b15054896983b43eb6a65', 'qq@qq.com', '13116666666', '倒是方便v但是', '0ef55ea992c74518b8b52229eeef57ee507k.png');

-- ----------------------------
-- Table structure for tb_companydepartment
-- ----------------------------
DROP TABLE IF EXISTS `tb_companydepartment`;
CREATE TABLE `tb_companydepartment`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introducation` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `departmentmanager` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `telephone` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `grade_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_companydepartment
-- ----------------------------
INSERT INTO `tb_companydepartment` VALUES (6, '技术部', '120', '介绍自我而非个人哥哥v额v', '王经理', '18995787173', '12@qq.com', '南京片区区');
INSERT INTO `tb_companydepartment` VALUES (7, '运维部', '10', '介绍：运维稳健输入法让对方vDVD发', '刘越', '13111111111', '44@22.com', '深圳');
INSERT INTO `tb_companydepartment` VALUES (8, '运维部', '10', '介绍：运维稳健', '刘越', '13111111111', '44@22.com', '深圳');
INSERT INTO `tb_companydepartment` VALUES (9, '运维部1', '10', '介绍：运维稳健', '刘越', '13111111111', '44@22.com', '深圳');
INSERT INTO `tb_companydepartment` VALUES (10, '运维部2', '10', '介绍：运维稳健', '刘越', '13111111111', '44@22.com', '深圳');

-- ----------------------------
-- Table structure for tb_k6script
-- ----------------------------
DROP TABLE IF EXISTS `tb_k6script`;
CREATE TABLE `tb_k6script`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creator` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creator_time` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `script` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_k6script
-- ----------------------------
INSERT INTO `tb_k6script` VALUES (1, '脚本111111', '啦啦啦1111', NULL, '{\r\n	\"shopCode\": \"05\",\r\n	\"bizCo}');
INSERT INTO `tb_k6script` VALUES (2, '地方v的', '打发打发', NULL, '{\r\n	\"shopCode\": \"05\",\r\n	\"bizCode\": \"SOP\",\r\n	\"language\": \"zh-TW\",\r\n	\"regionCode\": \"050\",\r\n	\"countryCode\": \"HK\",\r\n	\"shopType\": \"ONLINE\",\r\n	\"platform\": \"WEB\",\r\n	\"channel\": \"INT\",\r\n	\"purchaserAda\": \"9300\",\r\n	\"loginAda\": \"9300\",\r\n	\"formVersion\": \"\",\r\n	\"formVersionType\": 1,\r\n	\"route_code\": \"/sopDetail\",\r\n	\"source_type\": \"referrer_domain\",\r\n	\"mk_anonymous_id\": \"6fce449f-f76f-45e5-9b92-c80b988fc9cf\",\r\n	\"mk_client_session_id\": \"aa366b41-8f2c-49ad-be27-cb46c7f04f96\",\r\n	\"mk_landing_url\": \"http://dev.amway.com.hk/login?redirectUrl=https%3A%2F%2Fdev.amway.com.hk%2Fcart\",\r\n	\"mk_referrer\": \"https://dev.amway.com.hk/cart\",\r\n	\"mk_referrer_domain\": \"dev.amway.com.hk\",\r\n	\"settlementItems\": [{\r\n		\"skuName\": \"紐崔萊多寶營養片(補充裝)\",\r\n		\"skuCode\": \"1695\",\r\n		\"quantity\": 2\r\n	}, {\r\n		\"skuName\": \"什莓味蛋白質粉\",\r\n		\"skuCode\": \"325\",\r\n		\"quantity\": 1\r\n	}]\r\n}{\r\n	\"shopCode\": \"05\",\r\n	\"bizCode\": \"SOP\",\r\n	\"language\": \"zh-TW\",\r\n	\"regionCode\": \"050\",\r\n	\"countryCode\": \"HK\",\r\n	\"shopType\": \"ONLINE\",\r\n	\"platform\": \"WEB\",\r\n	\"channel\": \"INT\",\r\n	\"purchaserAda\": \"9300\",\r\n	\"loginAda\": \"9300\",\r\n	\"formVersion\": \"\",\r\n	\"formVersionType\": 1,\r\n	\"route_code\": \"/sopDetail\",\r\n	\"source_type\": \"referrer_domain\",\r\n	\"mk_anonymous_id\": \"6fce449f-f76f-45e5-9b92-c80b988fc9cf\",\r\n	\"mk_client_session_id\": \"aa366b41-8f2c-49ad-be27-cb46c7f04f96\",\r\n	\"mk_landing_url\": \"http://dev.amway.com.hk/login?redirectUrl=https%3A%2F%2Fdev.amway.com.hk%2Fcart\",\r\n	\"mk_referrer\": \"https://dev.amway.com.hk/cart\",\r\n	\"mk_referrer_domain\": \"dev.amway.com.hk\",\r\n	\"settlementItems\": [{\r\n		\"skuName\": \"紐崔萊多寶營養片(補充裝)\",\r\n		\"skuCode\": \"1695\",\r\n		\"quantity\": 2\r\n	}, {\r\n		\"skuName\": \"什莓味蛋白質粉\",\r\n		\"skuCode\": \"325\",\r\n		\"quantity\": 1\r\n	}]\r\n}{\r\n	\"shopCode\": \"05\",\r\n	\"bizCode\": \"SOP\",\r\n	\"language\": \"zh-TW\",\r\n	\"regionCode\": \"050\",\r\n	\"countryCode\": \"HK\",\r\n	\"shopType\": \"ONLINE\",\r\n	\"platform\": \"WEB\",\r\n	\"channel\": \"INT\",\r\n	\"purchaserAda\": \"9300\",\r\n	\"loginAda\": \"9300\",\r\n	\"formVersion\": \"\",\r\n	\"formVersionType\": 1,\r\n	\"route_code\": \"/sopDetail\",\r\n	\"source_type\": \"referrer_domain\",\r\n	\"mk_anonymous_id\": \"6fce449f-f76f-45e5-9b92-c80b988fc9cf\",\r\n	\"mk_client_session_id\": \"aa366b41-8f2c-49ad-be27-cb46c7f04f96\",\r\n	\"mk_landing_url\": \"http://dev.amway.com.hk/login?redirectUrl=https%3A%2F%2Fdev.amway.com.hk%2Fcart\",\r\n	\"mk_referrer\": \"https://dev.amway.com.hk/cart\",\r\n	\"mk_referrer_domain\": \"dev.amway.com.hk\",\r\n	\"settlementItems\": [{\r\n		\"skuName\": \"紐崔萊多寶營養片(補充裝)\",\r\n		\"skuCode\": \"1695\",\r\n		\"quantity\": 2\r\n	}, {\r\n		\"skuName\": \"什莓味蛋白質粉\",\r\n		\"skuCode\": \"325\",\r\n		\"quantity\": 1\r\n	}]\r\n}{\r\n	\"shopCode\": \"05\",\r\n	\"bizCode\": \"SOP\",\r\n	\"language\": \"zh-TW\",\r\n	\"regionCode\": \"050\",\r\n	\"countryCode\": \"HK\",\r\n	\"shopType\": \"ONLINE\",\r\n	\"platform\": \"WEB\",\r\n	\"channel\": \"INT\",\r\n	\"purchaserAda\": \"9300\",\r\n	\"loginAda\": \"9300\",\r\n	\"formVersion\": \"\",\r\n	\"formVersionType\": 1,\r\n	\"route_code\": \"/sopDetail\",\r\n	\"source_type\": \"referrer_domain\",\r\n	\"mk_anonymous_id\": \"6fce449f-f76f-45e5-9b92-c80b988fc9cf\",\r\n	\"mk_client_session_id\": \"aa366b41-8f2c-49ad-be27-cb46c7f04f96\",\r\n	\"mk_landing_url\": \"http://dev.amway.com.hk/login?redirectUrl=https%3A%2F%2Fdev.amway.com.hk%2Fcart\",\r\n	\"mk_referrer\": \"https://dev.amway.com.hk/cart\",\r\n	\"mk_referrer_domain\": \"dev.amway.com.hk\",\r\n	\"settlementItems\": [{\r\n		\"skuName\": \"紐崔萊多寶營養片(補充裝)\",\r\n		\"skuCode\": \"1695\",\r\n		\"quantity\": 2\r\n	}, {\r\n		\"skuName\": \"什莓味蛋白質粉\",\r\n		\"skuCode\": \"325\",\r\n		\"quantity\": 1\r\n	}]\r\n}{\r\n	\"shopCode\": \"05\",\r\n	\"bizCode\": \"SOP\",\r\n	\"language\": \"zh-TW\",\r\n	\"regionCode\": \"050\",\r\n	\"countryCode\": \"HK\",\r\n	\"shopType\": \"ONLINE\",\r\n	\"platform\": \"WEB\",\r\n	\"channel\": \"INT\",\r\n	\"purchaserAda\": \"9300\",\r\n	\"loginAda\": \"9300\",\r\n	\"formVersion\": \"\",\r\n	\"formVersionType\": 1,\r\n	\"route_code\": \"/sopDetail\",\r\n	\"source_type\": \"referrer_domain\",\r\n	\"mk_anonymous_id\": \"6fce449f-f76f-45e5-9b92-c80b988fc9cf\",\r\n	\"mk_client_session_id\": \"aa366b41-8f2c-49ad-be27-cb46c7f04f96\",\r\n	\"mk_landing_url\": \"http://dev.amway.com.hk/login?redirectUrl=https%3A%2F%2Fdev.amway.com.hk%2Fcart\",\r\n	\"mk_referrer\": \"https://dev.amway.com.hk/cart\",\r\n	\"mk_referrer_domain\": \"dev.amway.com.hk\",\r\n	\"settlementItems\": [{\r\n		\"skuName\": \"紐崔萊多寶營養片(補充裝)\",\r\n		\"skuCode\": \"1695\",\r\n		\"quantity\": 2\r\n	}, {\r\n		\"skuName\": \"什莓味蛋白質粉\",\r\n		\"skuCode\": \"325\",\r\n		\"quantity\": 1\r\n	}]\r\n}{\r\n	\"shopCode\": \"05\",\r\n	\"bizCode\": \"SOP\",\r\n	\"language\": \"zh-TW\",\r\n	\"regionCode\": \"050\",\r\n	\"countryCode\": \"HK\",\r\n	\"shopType\": \"ONLINE\",\r\n	\"platform\": \"WEB\",\r\n	\"channel\": \"INT\",\r\n	\"purchaserAda\": \"9300\",\r\n	\"loginAda\": \"9300\",\r\n	\"formVersion\": \"\",\r\n	\"formVersionType\": 1,\r\n	\"route_code\": \"/sopDetail\",\r\n	\"source_type\": \"referrer_domain\",\r\n	\"mk_anonymous_id\": \"6fce449f-f76f-45e5-9b92-c80b988fc9cf\",\r\n	\"mk_client_session_id\": \"aa366b41-8f2c-49ad-be27-cb46c7f04f96\",\r\n	\"mk_landing_url\": \"http://dev.amway.com.hk/login?redirectUrl=https%3A%2F%2Fdev.amway.com.hk%2Fcart\",\r\n	\"mk_referrer\": \"https://dev.amway.com.hk/cart\",\r\n	\"mk_referrer_domain\": \"dev.amway.com.hk\",\r\n	\"settlementItems\": [{\r\n		\"skuName\": \"紐崔萊多寶營養片(補充裝)\",\r\n		\"skuCode\": \"1695\",\r\n		\"quantity\": 2\r\n	}, {\r\n		\"skuName\": \"什莓味蛋白質粉\",\r\n		\"skuCode\": \"325\",\r\n		\"quantity\": 1\r\n	}]\r\n}');
INSERT INTO `tb_k6script` VALUES (3, 'AllChannelQuery接口', '夏老师', NULL, 'import http from \'k6/http\';\r\nimport { check } from \'k6\';\r\nimport { SharedArray } from \'k6/data\';\r\n\r\n// import { htmlReport } from \"https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js\";\r\n\r\n\r\n// export function handleSummary(data) {\r\n//   return { \"D:/k6-v1.4.2-windows-amd64/xia.html\": htmlReport(data) };  \r\n// }\r\n\r\n\r\n//配置测试参数\r\nexport const options = {\r\n    vus: 1,           // 虚拟用户数\r\n    duration: \'21s\',    // 测试持s续时间\r\n\r\n};\r\n\r\n\r\nexport default function () {\r\n    const url = \'http://10.159.235.45/search/AllChannelQuery\';\r\n\r\n    const payload = JSON.stringify({\r\n        \"pageSize\": 10,\r\n		   \"startTime\": null,\r\n        \"endTime\": null,\r\n        \"skuCodes\": [],\r\n        \"pageNo\": 1\r\n    });\r\n\r\n    const params = {\r\n        headers: {\r\n            \'Connection\': \'keep-alive\',\r\n            \'jws\': \'eyJhbGciOiJSUzUxMiM1Ms4rSVkI1YT6nqUwPDC_4lVxsHURjnhpgVywK2kpgFDc\',\r\n            \'Content-Type\': \'application/json\',\r\n            \'CHANNEL_ID\': \'5os\',\r\n            \'User-Agent\': \'Apache-HttpClient/4.5.13 (Java/1.8.0_202)\',\r\n        },\r\n    };\r\n\r\n    const res = http.post(url, payload, params);\r\n\r\n    // 验证响应\r\n    check(res, {\r\n        \'status is 200\': (r) => r.status === 200,\r\n        \'response has data\': (r) => r.json().data !== undefined\r\n    });\r\n\r\n    // 打印响应（可选）\r\n    //console.log(JSON.stringify(res.body));\r\n}');

-- ----------------------------
-- Table structure for tb_operations
-- ----------------------------
DROP TABLE IF EXISTS `tb_operations`;
CREATE TABLE `tb_operations`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `tno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `telephone` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `clazz_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `portrait_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_operations
-- ----------------------------
INSERT INTO `tb_operations` VALUES (5, '1233', 'yw', '男', 'e10adc3949ba59abbe56e057f20f883e', '547879@qq.com', '13119559057', '北京同和街道', '运维部', '7781059a44144295b701d553309c4706123.png');
INSERT INTO `tb_operations` VALUES (7, 'xia', '士大夫VS的', '女', '123456', '547879@qq.com', '13119559057', '武当山脚下128号', '运维部', '5e785e695d65404bbb48082348d95b40e4b21ffd-3718-4e7e-aa9b-4dcbaeeef742.png');

-- ----------------------------
-- Table structure for tb_report
-- ----------------------------
DROP TABLE IF EXISTS `tb_report`;
CREATE TABLE `tb_report`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `concurrency` int NULL DEFAULT NULL,
  `successrate` double NULL DEFAULT NULL,
  `tps` double NULL DEFAULT NULL,
  `rt` double NULL DEFAULT NULL,
  `creator` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `portrait_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_report
-- ----------------------------
INSERT INTO `tb_report` VALUES (1, 'addgoods接口报告', NULL, 50, 100, 123, 2.3, NULL, 'd4b04e4167cf4fdf9701661655d3a327123.png');

-- ----------------------------
-- Table structure for tb_tester
-- ----------------------------
DROP TABLE IF EXISTS `tb_tester`;
CREATE TABLE `tb_tester`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `telephone` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `portrait_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introducation` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_tester
-- ----------------------------
INSERT INTO `tb_tester` VALUES (1, NULL, 'tester1', '女', 'e10adc3949ba59abbe56e057f20f883e', NULL, '189995787173', '武汉蔡甸', '7271a1b3675440cc8ab01c4cf5e8438d61k.png', '软件测试人员：熟悉java 编程，性能测试');

SET FOREIGN_KEY_CHECKS = 1;

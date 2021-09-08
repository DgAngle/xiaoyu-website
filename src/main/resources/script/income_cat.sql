DROP TABLE IF EXISTS `income_cat`;
CREATE TABLE `income_cat`  (
                              `incomeCatId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收入分类主键',
                              `incomeCatName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入分类名称',
                              `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
                              `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
                              `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                              PRIMARY KEY (`incomeCatId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收入分类表' ROW_FORMAT = DYNAMIC;

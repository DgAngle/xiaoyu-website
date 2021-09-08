DROP TABLE IF EXISTS `income`;
CREATE TABLE `income`  (
                          `incomeId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收入主键',
                          `incomeCatId` bigint(20) NULL DEFAULT NULL COMMENT '收入分类主键',
                          `incomeName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入名称',
                          `incomeMoney` decimal(18, 2) NULL DEFAULT NULL COMMENT '收入金额',
                          `incomeDate` datetime NULL DEFAULT NULL COMMENT '收入时间',
                          `incomeContent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入内容',
                          `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
                          `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                          `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                          PRIMARY KEY (`incomeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收入表' ROW_FORMAT = DYNAMIC;
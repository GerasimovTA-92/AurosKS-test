CREATE DATABASE `test_task` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `k_pacs` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `title` varchar(255) DEFAULT NULL,
                          `description` varchar(2000) DEFAULT NULL,
                          `creation_date` varchar(10) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `k_pacs_sets` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `title` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `k_pacs_sets_k_pacs` (
                                      `k_pacs_set_id` bigint DEFAULT NULL,
                                      `k_pac_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

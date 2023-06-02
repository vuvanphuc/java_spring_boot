CREATE TABLE IF NOT EXISTS `tbl_posts` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(300) NOT NULL UNIQUE,
  `description` VARCHAR(500) DEFAULT NULL,
  `image` VARCHAR(300) DEFAULT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created_by` VARCHAR(36) DEFAULT NULL,
  `updated_by` VARCHAR(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
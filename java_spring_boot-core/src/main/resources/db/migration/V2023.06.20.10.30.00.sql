CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(256) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `address` VARCHAR(256) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created_by` VARCHAR(36) DEFAULT NULL,
  `updated_by` VARCHAR(36) DEFAULT NULL,
  `deleted_at` DATETIME DEFAULT NULL,
  `deleted_by` VARCHAR(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
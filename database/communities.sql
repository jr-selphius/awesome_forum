CREATE TABLE communities (
  id              BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  community_id    CHAR(36)            NOT NULL,
  title           VARCHAR(255)        NOT NULL,
  updated_at      TIMESTAMP(3)        NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  UNIQUE KEY u_community_id (community_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE posts (
  id              BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  post_id         CHAR(36)            NOT NULL,
  content         TEXT                NOT NULL,
  thread_id       CHAR(36)            NOT NULL,
  user_id         CHAR(36)            NOT NULL,
  updated_at      TIMESTAMP(3)        NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  UNIQUE KEY u_post_id (post_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

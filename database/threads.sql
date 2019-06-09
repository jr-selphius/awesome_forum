CREATE TABLE threads (
  id              BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  thread_id       CHAR(36)            NOT NULL,
  subject         VARCHAR(100)        NOT NULL,
  user_id         CHAR(36)            NOT NULL,
  community_id    CHAR(36)            NOT NULL,
  updated_at      TIMESTAMP(3)        NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  UNIQUE KEY u_thread_id (thread_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

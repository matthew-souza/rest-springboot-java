CREATE TABLE IF NOT EXISTS movies (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  title       VARCHAR(50) NOT NULL,
  synopsis    VARCHAR(500) NOT NULL,
  director    VARCHAR(50) NOT NULL
);
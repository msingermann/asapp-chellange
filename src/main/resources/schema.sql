CREATE TABLE IF NOT EXISTS users
(
    id
    SERIAL
    PRIMARY
    KEY,
    username
    varchar
(
    255
) NOT NULL UNIQUE,
    password varchar
(
    255
) NOT NULL
    );
-- An INTEGER PRIMARY KEY becomes the actual key used in the B-tree that stores your table. So no index is required for efficient operation.
CREATE UNIQUE INDEX IF NOT EXISTS name_index
    ON users(username);

CREATE TABLE IF NOT EXISTS messages
(
    id
    SERIAL
    PRIMARY
    KEY,
    sender
    INTEGER
    NOT
    NULL,
    recipient
    INTEGER
    NOT
    NULL,
    type
    VARCHAR
(
    16
) NOT NULL,
    metadata VARCHAR
(
    255
) NOT NULL,
    timestamp TIMESTAMPTZ DEFAULT NOW
(
) NOT NULL
    );

CREATE TABLE IF NOT EXISTS tokens
(
    token VARCHAR
(
    36
) PRIMARY KEY,
    user_id INTEGER NOT NULL,
    timestamp TIMESTAMPTZ DEFAULT NOW
(
) NOT NULL
    );
-- SQLite

-- CREATE INDEX IF NOT EXISTS name_index
--     ON messages(recipient);
--
-- CREATE TABLE IF NOT EXISTS tokens (
--     token VARCHAR(36) PRIMARY KEY,
--     user INTEGER NOT NULL,
--     timestamp DATETIME DEFAULT (DATETIME('now')) NOT NULL
-- );
--
-- CREATE TABLE IF NOT EXISTS users (
--                                      id INTEGER PRIMARY KEY AUTOINCREMENT,
--                                      username varchar(255) NOT NULL UNIQUE,
--     password varchar(255) NOT NULL
--     );
-- -- An INTEGER PRIMARY KEY becomes the actual key used in the B-tree that stores your table. So no index is required for efficient operation.
-- CREATE UNIQUE INDEX IF NOT EXISTS name_index
--     ON users(username);
--
-- CREATE TABLE IF NOT EXISTS messages (
--                                         id INTEGER PRIMARY KEY AUTOINCREMENT,
--                                         sender INTEGER NOT NULL,
--                                         recipient INTEGER NOT NULL,
--                                         type VARCHAR(16) NOT NULL,
--     metadata VARCHAR(255) NOT NULL,
--     timestamp DATETIME DEFAULT (DATETIME('now')) NOT NULL
--     );
--
-- CREATE INDEX IF NOT EXISTS name_index
--     ON messages(recipient);
--
-- CREATE TABLE IF NOT EXISTS tokens (
--     token VARCHAR(36) PRIMARY KEY,
--     user INTEGER NOT NULL,
--     timestamp DATETIME DEFAULT (DATETIME('now')) NOT NULL
--     );

CREATE TABLE users {
    id_user TEXT NOT NULL,
    login TEXT NOT NULL UNIQUE.
    password TEXT NOT NULL,
    role TEXT NOT NULL,
    CONSTRAINT pkid_user PRIMARY KEY(id_user)
};
CREATE TABLE "user"(
    "id" BIGINT NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    "email" VARCHAR(100) NOT NULL,
    "password" VARCHAR(100) NOT NULL,
    "date" TIMESTAMP(0) NOT NULL
);
ALTER TABLE
    "user" ADD PRIMARY KEY("id");
CREATE TABLE "qoute"(
    "id" BIGINT NOT NULL,
    "content" VARCHAR(200) NOT NULL,
    "date" TIMESTAMP(0) NOT NULL,
    "user_id" BIGINT NOT NULL,
    "vote_id" BIGINT NOT NULL
);
ALTER TABLE
    "qoute" ADD PRIMARY KEY("id");
CREATE TABLE "vote"(
    "id" BIGINT NOT NULL,
    "score" BIGINT NOT NULL,
    "graph" TEXT NOT NULL
);
ALTER TABLE
    "vote" ADD PRIMARY KEY("id");
ALTER TABLE
    "qoute" ADD CONSTRAINT "qoute_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "user"("id");
ALTER TABLE
    "qoute" ADD CONSTRAINT "qoute_vote_id_foreign" FOREIGN KEY("vote_id") REFERENCES "vote"("id");
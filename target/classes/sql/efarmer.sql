CREATE TABLE IF NOT EXISTS public."user"
(
    phone "char" NOT NULL,
    firstname "char",
    lastname "char",
    firmname "char",
    address "char",
    emailid "char",
    CONSTRAINT user_pkey PRIMARY KEY (phone)
)

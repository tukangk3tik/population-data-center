CREATE TABLE IF NOT EXISTS users (
    id int NOT NULL,
    email varchar(50),
    password varchar(100),
    version bigint,
    created_at timestamp,
    updated_at timestamp,
    deleted_at timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS persons (
    id_number varchar(20) NOT NULL,
    full_name varchar(50) NOT NULL,
    place_of_birth varchar(100),
    date_of_birth date,
    gender smallint NOT NULL,
    blood_group varchar(5),
    address text NOT NULL,
    religion varchar(50),
    marital_status varchar(20),
    profession varchar(50),
    citizenship varchar(50),
    phone_number varchar(20),
    version bigint,
    created_at timestamp,
    updated_at timestamp,
    deleted_at timestamp,
    PRIMARY KEY (id_number)
);

-- PREPOPULATED DATABASE
INSERT INTO persons VALUES (
    '1207232810950003',
    'Damar Smitt',
    'Medan, Indonesia',
    '1995-03-27',
    1,
    'AB',
    'Jl. Guru Sinumba No. 12',
    'Aliran Kepercayaan',
    'Belum Menikah',
    'Software developer',
    'WNI',
    '+6282235465728',
    0,
    NOW(),
    null,
    null
)
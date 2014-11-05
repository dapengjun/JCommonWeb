create table c_name_value_t(
    id int(4) primary key auto_increment,
    name varchar(16),
    value varchar(32)
);
create table p_user_t(
    id int(4) primary key auto_increment,
    name varchar(16),
    password varchar(32)
);
create table usuarios(
id bigint not null  auto_increment,
mail varchar(200) not null,
clave varchar(200) not null,
primary key(id)
);

create table topicos(
id bigint not null auto_increment,
usuario_id bigint not null,
titulo varchar(300) not null,
mensaje text not null,
fecha datetime not null,
primary key(id),

constraint fk_topicos_usuario_id foreign key (usuario_id) references usuarios (id)



);
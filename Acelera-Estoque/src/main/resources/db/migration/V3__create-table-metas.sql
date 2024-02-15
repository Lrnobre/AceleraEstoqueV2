create table quantidades(

   id bigint not null auto_increment,
   produto_id bigint not null,
   mes_referencia date not null,
   quantidade integer not null,


   primary key(id),
   constraint fk_metas_produto_id foreign key(produto_id) references produtos(id)
);
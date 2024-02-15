create table vendas(

   id bigint not null auto_increment,
   produto_id bigint not null,
   cpf_cliente varchar(11) not null,
   data_venda date not null,
   quantidade integer not null,


   primary key(id),
   constraint fk_vendas_produto_id foreign key(produto_id) references produtos(id),
   constraint fk_vendas_cpf_cliente foreign key(cpf_cliente) references clientes(cpf)
);
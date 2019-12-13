insert into usuario
  (cpf, data_de_nascimento, email, nome, senha)
values
  ('00000001', '1994-05-20 18:00:00', 'teste@gmail.com', 'Teste', '1234');

insert into cidade
  (descricao, sigla)
values
  ('Aracaju', 'AJU');

insert into bairro
  (descricao, sigla, cidade_id)
values
  ('Jabotiana', 'JBT', 1);

insert into marca
  (descricao)
values
  ('Caloi');

insert into modelo
  (descricao, marca_id)
values
  ('City Tour Sport', 1);
  
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
  ('Aspen', 1);



insert into bicicleta
  (ano, status, marca_id, modelo_id, usuario_cpf)
values
  ('2018', 'SEM_RESTRICAO', 1, 1, 1);

insert into ocorrencia
  (data_do_fato, data_registro_ocorrencia, descricao, tipo, titulo, bairro_id, bicicleta_codigo, cidade_id, usuario_cpf)
VALUES
  ('2018-05-20 18:00:00', '2018-05-21 18:00:00', 'Assalto', 'ROUBO', 'Assalto', 1, 1, 1, 1);

  
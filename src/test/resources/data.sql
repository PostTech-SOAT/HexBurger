INSERT INTO CLIENTE (CPF, NOME, EMAIL) VALUES
                                           ('12345678900', 'João', 'joao@email.com'),
                                           ('98765432108', 'Fernando', 'fernando@email.com'),
                                           ('45678912305', 'Gabriel', 'gabriel@email.com');

INSERT INTO PRODUTO (ID, NOME, DESCRICAO, VALOR, CATEGORIA) VALUES
                                           ('5c4c83cb-f1e8-4182-8601-281323f00111', 'Hex Burger', 'Pão e Hambuguer no formato hexagonal', 15.00, 'LANCHE'),
                                           ('2b68f2cc-75c5-4ed7-a712-0a6a6443127b', 'Hex Burger Duplo', 'Pão e dois Hambugueres no formato hexagonal', 27.00, 'LANCHE'),
                                           ('92ffdcbf-f74c-4b05-93c5-be96ef1d9326', 'Hex Chicken', 'Pão e Hambuguer de frango no formato hexagonal', 18.00, 'LANCHE'),
                                           ('84ee2567-fe65-455b-bf23-9543d4e86be1', 'Hex Cola', 'Refrigerante sabor cola', 6.00, 'BEBIDA'),
                                           ('a1fe5443-3bc7-4cb0-8ffe-a1dc0bf8768c', 'Água', 'Água', 4.00, 'BEBIDA'),
                                           ('f55f733e-aeb3-4955-87d7-b521895cae80', 'Hex Fries', 'Batatas fritas crocantes', 8.00, 'ACOMPANHAMENTO'),
                                           ('8c722a6a-57d6-4ea1-9d98-79e78835837b', 'Hex Nuggets', 'Nuggets no formato hexagonal', 12.00, 'ACOMPANHAMENTO'),
                                           ('7cbc859a-a702-4f64-9f81-2136c338338c', 'Hex Gelatto', 'Sorvete de creme 200ml', 15.00, 'SOBREMESA'),
                                           ('f4cc8aa2-2670-4e12-b3ed-ec281fa50411', 'Hex Donut', 'Donut no formato hexagonal', 8.00, 'SOBREMESA');

INSERT INTO PRODUTO_PEDIDO (ID, NOME, DESCRICAO, VALOR, CATEGORIA) VALUES
                                           ('69d8ffc2-e77c-45e2-8245-3a86664e1f5d', 'Hex Burger', 'Pão e Hambuguer no formato hexagonal', 15.00, 'LANCHE'),
                                           ('1c365852-b801-4081-965f-c4a27c92377c', 'Hex Cola', 'Refrigerante sabor cola', 6.00, 'BEBIDA'),
                                           ('236c13a3-b3f2-4114-96f1-75c9a9d72ea3', 'Hex Fries', 'Batatas fritas crocantes', 8.00, 'ACOMPANHAMENTO'),
                                           ('faf7413f-5a19-4b1c-a751-84254ab20722', 'Hex Gelatto', 'Sorvete de creme 200ml', 15.00, 'SOBREMESA');

INSERT INTO COMBO (ID, VALOR_TOTAL) VALUES
                                           ('2b8be9d3-2f01-47c7-ba47-8a621869a4ec', 44.00);

INSERT INTO combo_produtos_pedido (ecombo_id, produtos_pedido_id) VALUES
                                                                      ('2b8be9d3-2f01-47c7-ba47-8a621869a4ec', '69d8ffc2-e77c-45e2-8245-3a86664e1f5d'),
                                                                      ('2b8be9d3-2f01-47c7-ba47-8a621869a4ec', '1c365852-b801-4081-965f-c4a27c92377c'),
                                                                      ('2b8be9d3-2f01-47c7-ba47-8a621869a4ec', '236c13a3-b3f2-4114-96f1-75c9a9d72ea3'),
                                                                      ('2b8be9d3-2f01-47c7-ba47-8a621869a4ec', 'faf7413f-5a19-4b1c-a751-84254ab20722');
INSERT INTO PEDIDO (ID, CODIGO, ID_EXTERNO_PAGAMENTO, QR_CODE, STATUS, STATUS_PAGAMENTO, CLIENTE_CPF, VALOR_TOTAL, DATA_PEDIDO) VALUES
                                           ('9c3e7112-ac5c-413a-9e24-22688bf60976', '1', null, null, 'RECEBIDO', 'AGUARDANDO', '12345678900', 44.00, '2024-10-30 12:00:00');

INSERT INTO pedido_combos (epedido_id, combos_id) VALUES
                                           ('9c3e7112-ac5c-413a-9e24-22688bf60976', '2b8be9d3-2f01-47c7-ba47-8a621869a4ec');
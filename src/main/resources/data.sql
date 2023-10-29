--tb_user (ba1)
INSERT INTO TB_USER VALUES(1,'ANDREA');
INSERT INTO TB_USER VALUES(2,'NAVID');

--tb_card (bed)
INSERT INTO TB_CARD VALUES(1, 2, '1112-2222-333333-44-5','2024-12-31');
INSERT INTO TB_CARD VALUES(2, 1, '1111-2222-333333-44-5','2023-12-31');

--tb_doctor (bau)
INSERT INTO TB_DOCTOR  VALUES(1,'DR JOSE DAS COVES');
INSERT INTO TB_DOCTOR  VALUES(2,'DRA MARIA DAS ALMAS');
INSERT INTO TB_DOCTOR  VALUES(3,'DIO CLINIC');

--tb_itens (br8)
INSERT INTO TB_ITEM VALUES (1, '10101012', 'CONSULTA EM CONSULTORIO (NO HORARIO NORMAL OU PREESTABELECIDO)');
INSERT INTO TB_ITEM VALUES (2, '10101039', 'CONSULTA EM PRONTO ATENDIMENTO');
INSERT INTO TB_ITEM VALUES (3, '40301400', 'HEMOGRAMA');
INSERT INTO TB_ITEM VALUES (4, '40304361', 'CALCIO TOTAL');

--tb_transaction (bea)
INSERT INTO TB_TRANSACTION VALUES(1, '1112-2222-333333-44-5', '70011', '2',  '2024-12-31',  'CONSULTA', '10101012' )





-- {
--   "nameUser": "andrea",
--   "transaction": {
--     "number": "1234",
--     "dateTime": "20231019 17:46:00",
--     "type": "001"
--   },
--   "itens": [
--     {
--       "code": "40301630",
--       "quantity": 1,
--       "status": "2"
--     },
--     {
--       "code": "40304361",
--       "quantity": 1,
--       "status": "2"
--     },
--     {
--       "code": "40301400",
--       "quantity": 1,
--       "status": "2"
--     }
--   ],
--   "doctor": {
--     "code": "123",
--     "name": "dio clinic"
--   },
--   "cardUser": {
--     "number": "1236",
--     "validity": "2023-12-31"
--   }
-- }

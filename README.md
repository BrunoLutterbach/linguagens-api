# Endpoint - Reverter Endereço

### Funcionalidade
#
O objetivo do endpoint é alterar o endereço de entrega do cliente no Air, quando a mudança de endereço for cancelada na Sydle;

### URL - Homologação
#
##### Token: Token Padrão
#### URL BASE
```
https://nds-teste.sumicity.net.br:8020
```

### URL - Produção
#
##### Token: Token Padrão
#### URL BASE

```
https://api.sumicity.net.br:7070
```
#
| Método      | Rota        | Descrição | JSON Exemplo |
| ----------- | ----------- | ---------- | ----------  |
| PUT| /contrato/{idContrato}/reverter-endereco       | Realiza a alteração de endereço para o informado no JSON |  <pre>{<br> "logradouroTipo": "CLT_RUA",<br> "cidadeId": 116, <br> "logradouro": "Rua Oito"<br> "bairro": "Centro",<br> "cep": "11676-505",<br> "numero": "21",<br> "complemento": "Casa 2",<br> "referencia": "Padaria",<br> "ativo": true,<br> "unidade": "CNB",<br> "ftta": false,<br> "condominioId": null<br>}</pre>|

 | Nome  | Tipo |
| --- |-------------|
|logradouroTipo| String|    
|cidadeId| Long|
|logradouro| String|
|bairro| String|
|cep| String|
|numero| String|
|complemento| String|








# Controle De Gastos
 API RESTful feita para ter um controle de gastos de suas despesas.
 
Essa aplicação possibilita que o usuário possa guardar em um banco de dados as informações de despesas que faz no seu cotidiano para que assim possa ter um controle sobre o que gastou, qual o valor, tipo de gasto e se já foi pago ou não(No caso da compra ser em cartão de crédito).

Primeiramente existem campos no qual o usuário deve preencher, são eles: 
1° Descrição: aqui voçê pode falar mais especificamente sobre o que foi aquela despesa.
exemplo: "Blusa da Marca x"
2° Categoria: Para identificar melhor suas despesas são disponibilizados tipos específicos(Alimentação, Moradia, Saúde, Transporte, Lazer, Outros)
3º Valor: Nesse campo preencha conforme o valor da despesa.
4º Situação: Nesse campo são disponibilizados tipos específicos para identificar se sua despesa está paga ou pendente.
Depois disso é só salvar sua despesa. São gerados um ID unico e a data do dia do registo no momento que for salvo, para que sua despesa seja única e que possa saber em que data ela foi salva. 

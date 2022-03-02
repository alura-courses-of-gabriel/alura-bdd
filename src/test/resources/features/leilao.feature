#language: pt
  @leilao
  Funcionalidade: Cadastro de leilao
    Cenario: Um ususario logado pode cadastrar um leilao
      Dado um usuario logado
      Quando acessa a pagina de novo leilao
      E preenche o formulario com dados validos
      Entao volta para a pagina de leiloes
      E novo leilao aparece na lista de leiloes
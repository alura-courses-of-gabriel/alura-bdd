#language: pt
  Funcionalidade: Apenas usuarios cadastrados podem se logar
    Cenario: Um usuario valido consegue logar
      Dado o usuario valido
      Quando realizar login
      Entao é redirecionado para a pagina de leiloes

    Cenario: Um usuario invalido nao consegue logar
      Dado o usuario invalido
      Quando tenta se logar
      Entao continua na pagina de login
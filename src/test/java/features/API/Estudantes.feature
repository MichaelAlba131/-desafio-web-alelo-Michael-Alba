@MichaelAlba @testeSovos
Feature: SovosTest

  @Positivo
  Scenario Outline: "<cenary>"
    Given crio um novo estudante "<criacao>"
    And atualizo o nome e email "<atualizacao>"
    Then consulto todos os cadastros na base "<consulta>"


    Examples:
      | cenary                                                   | criacao | atualizacao | consulta |
      | 001 - API - Consulta de Estudantes                       | False   | False       | True     |
      | 002 - API - Criação de Estudante                         | True    | False       | True     |
      | 003 - API - Atualização de Estudante                     | False   | True        | True     |
      | 004 - API - Criação, Atualização e Consulta de Estudante | True    | True        | True     |


  @Negativo
  Scenario Outline: "<cenary>"
    Given crio um novo estudante "<criacao>""<CPF_Duplicado>"
    And atualizo o nome e email "<atualizacao>"
    Then consulto todos os cadastros na base "<consulta>"


    Examples:
      | cenary                                         | criacao | atualizacao | consulta | CPF_Duplicado |
      | 004 - API - Criação com mesmo CPF de Estudante | True    | False       | False    | True          |




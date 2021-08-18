@MichaelAlba @testeSovos
Feature: SovosTest

  Scenario Outline: "<cenary>"
    Given I navigate to URL
    And I fill the CEP and search "<CEP>""<FilterSearchCEP>"
    And I validate the information returned with the JSON file "<Validation>"

    Examples:
      | cenary                                                        | CEP      | FilterSearchCEP       | Validation |
      | 001 - Validation the CEP is Correct                           | 13230430 | Localidade/Logradouro | ID1        |
      | 002 - Validation the CEP Public place is Incorrect            | 13230430 | Localidade/Logradouro | ID2        |
      | 003 - Validation the CEP Neighborhood is Incorrect            | 13230430 | Localidade/Logradouro | ID3        |
      | 004 - Validation the CEP Location is Incorrect                | 13230430 | Localidade/Logradouro | ID4        |
      | 005 - Validation the CEP is Incorrect                         | 13230430 | Localidade/Logradouro | ID5        |
      | 006 - Validation the CEP returned more that one public places | 13230430 | Localidade/Logradouro | ID6        |







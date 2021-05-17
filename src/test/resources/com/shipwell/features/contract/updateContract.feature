#language: en

Feature: As shipwell I want to be able to update an existing contract
  As a Ship
  I want to update a contract

  @contractUpdate @contractUpdateSuccess @test @contract
  Scenario Outline: I Update an existing contract
    Given shipwell active contract with id <contract_id>
    And shipwell wants update a contract with shipwell auth <companyAuth>, <userIdAuth>
    When shipwell try makes the update of the contract with <active>, <contract_id>, <clientId>, <clientSecret>, <grant_type>, <scope>
    Then validate status and contract update correctly with active in <active>

    Examples:
      |companyAuth|userIdAuth|clientId                         | clientSecret                                      | grant_type        | scope       |active|contract_id|
      |      0020  |   gbhytrd| 7mo5roip0ovkpb1vhma6f2vnv4      |inuj0606dj6v6eatjbl3esg9mej3c5qn0v0cgua2o37c7ldq97e|client_credentials | null        |false |  354      |

  @contractUpdate @contractUpdateDoesntExist @test @contract
  Scenario Outline: I update a contract that doesn't exist
    Given shipwell wants update a contract with shipwell auth <companyAuth>, <userIdAuth>
    When shipwell try makes the update of the contract with <active>, <contract_id>, <clientId>, <clientSecret>, <grant_type>, <scope>
    Then validate status and contract update fail <contract_id>

    Examples:
      |companyAuth|userIdAuth|clientId                         | clientSecret                                      | grant_type        | scope       |active|contract_id|
      |      007  |   gbhytrd| 7mo5roip0ovkpb1vhma6f2vnv4      |inuj0606dj6v6eatjbl3esg9mej3c5qn0v0cgua2o37c7ldq97e|client_credentials | null        |false |  0000      |



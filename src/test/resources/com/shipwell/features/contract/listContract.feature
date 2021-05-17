#language: en

Feature: As shipwell I want to have a create contract endpoint so that I am able to create new contracts linking them to existing carriers
  As a Shipwell
  I want to create new contract
  to make an alliance between the company and Shipwell

  @contractList @contractListSuccess @test @contract
  Scenario Outline: I list company contracts
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try to list company <companyId> contracts
    Then validate status and company contracts <companyId>

    Examples:
    |companyAuth|userIdAuth|companyId|
    |      001  |   gbhytrd|  001    |

 @contractList @contractListDontExist @test @contract
  Scenario Outline: I list contracts of company that dont exist
    Given shipwell wants create a new contract with shipwell auth <companyAuth>, <userIdAuth>
    When shipwell try to list company <companyId> contracts
    Then validate status and empty company contracts <companyId>

   Examples:
     |companyAuth|userIdAuth|companyId|
     |      123  |   gbhytrd|  123123123    |
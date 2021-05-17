#language: en

Feature: As shipwell I want to update a company

  @companyUpdate @companyUpdateSuccess @test @company
  Scenario Outline: I update company successfully
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the update of the company with <companyId>, <companyName>
    Then validate status and company updated correctly <companyId>, <companyName>

    Examples:
      |companyAuth|userIdAuth|companyId |companyName|
      |   007     |gbhytrd   | 007      |  Test00123  |

  @companyUpdate @companyUpdateDontExists @test @company
  Scenario Outline: I create company when the company dont exists
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the update of the company with <companyId>, <companyName>
    Then validate status and the company dont exists <companyId>

    Examples:
      |companyAuth|userIdAuth|companyId |companyName|
      |   123     |gbhytrd   | 32132132 |  Test002  |


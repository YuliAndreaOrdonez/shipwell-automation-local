#language: en

Feature: As shipwell I want to create a company

  @companyCreate @companyCreateSuccess @test @company
  Scenario Outline: I create company success
    Given delete company <companyId>
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the company with <companyId>, <companyName>
    Then validate status and company created correctly <companyId>, <companyName>

    Examples:
      |companyAuth|userIdAuth|companyId |companyName|
      |   123     |gbhytrd   | 004      |  Test004  |
      |   123     |gbhytrd   | 005      |  Test005  |
      |   123     |gbhytrd   | 006      |  Test006  |

  @companyCreate @companyCreateAlreadyExist @test @company
  Scenario Outline: I create company when the company already exists
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the company with <companyId>, <companyName>
    Then validate status and the company already exists <companyId>

    Examples:
      |companyAuth|userIdAuth|companyId |companyName|
      |   123     |gbhytrd   | 001      |  Test001  |


#language: en

Feature: As shipwell I want to have a create carrier
  As a Shipwell
  I want to create new carrier

  @carrierCreate @carrierCreateSuccess @test @carrier
  Scenario Outline: I create carrier when success
    Given delete carrier <scacCode>
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the carrier with <name>, <scacCode>, <rating>, <booking>, <tracking>, <imaging>, <authorizationMethod>, <contentType>, <clientId>, <clientSecret>, <grant_type>, <scope>, <authenticationMethod>, <authorizationKey> data
    Then validate status and carrier created correctly <name>, <scacCode>
    Examples:
      |companyAuth|userIdAuth|name      |scacCode   |rating|booking|tracking|imaging|authorizationMethod|contentType| clientId  | clientSecret  | grant_type      | scope       |authenticationMethod|authorizationKey|
      | 123       |gbhytrd   |CONVOY1    |CIAN1       |true  |false   |false    |false   |                   |           |           |               |                 | null        |                    |                |
      | 123       |gbhytrd   |UBER1      |UFLB1      |true |true   |false    |false   |                   |           |           |               |                 |             |                    |                |
      | 123       |gbhytrd   |COYOTE1    |CLLQ1       |true  |true   |true    |true   |                   |           |           |               |                 |             |                    |                |


  @carrierCreate @carrierCreateAlreadyExist @test @carrier
  Scenario Outline: I create carrier when carrier already exists
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the carrier with <name>, <scacCode>, <rating>, <booking>, <tracking>, <imaging>, <authorizationMethod>, <contentType>, <clientId>, <clientSecret>, <grant_type>, <scope>, <authenticationMethod>, <authorizationKey> data
    Then validate status and carrier not created because it already exists <scacCode>
    Examples:
      |companyAuth|userIdAuth|name      |scacCode   |rating|booking|tracking|imaging|authorizationMethod|contentType| clientId  | clientSecret  | grant_type      | scope       |authenticationMethod|authorizationKey|
      | 123       |gbhytrd   |COYOTE    |CLLQ       |true  |true   |true    |true   |                   |           |           |               |                 |             |                    |                |
#language: en

Feature: As shipwell I want to update a carrier
  As a Shipwell
  I want to update a carrier

  @carrierUpdate @carrierUpdateSuccess @test @carrier
  Scenario Outline: I update carrier
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the update of the carrier with <name>, <scacCode>, <rating>, <booking>, <tracking>, <imaging>, <authorizationMethod>, <contentType>, <clientId>, <clientSecret>, <grant_type>, <scope>, <authenticationMethod>, <authorizationKey> data
    Then validate status and carrier updated correctly <name>, <scacCode>
    Examples:
      |companyAuth|userIdAuth|name      |scacCode   |rating|booking|tracking|imaging|authorizationMethod|contentType| clientId  | clientSecret  | grant_type      | scope       |authenticationMethod|authorizationKey|
      | 123       |gbhytrd   |CONVOY3    |CIAN2       |true  |false   |false    |false   |                   |           |           |               |                 | null        |                    |                |

  @carrierUpdate @carrierUpdateDontExist @test @carrier
  Scenario Outline: I update carrier that dont exists
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the update of the carrier with <name>, <scacCode>, <rating>, <booking>, <tracking>, <imaging>, <authorizationMethod>, <contentType>, <clientId>, <clientSecret>, <grant_type>, <scope>, <authenticationMethod>, <authorizationKey> data
    Then validate status and carrier not updated because it dont exists <scacCode>
    Examples:
      |companyAuth|userIdAuth|name      |scacCode   |rating|booking|tracking|imaging|authorizationMethod|contentType| clientId  | clientSecret  | grant_type      | scope       |authenticationMethod|authorizationKey|
      | 123       |gbhytrd   |CONVOY3    |CIAN2123      |true  |false   |false    |false   |                   |           |           |               |                 | null        |                    |                |
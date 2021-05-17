#language: en

Feature: As shipwell I want to have a create contract endpoint so that I am able to create new contracts linking them to existing carriers
  As a Shipwell
  I want to create new contract
  to make an alliance between the company and Shipwell

  @contractCreate @contractCreateSuccess @test @contract
  Scenario Outline: I create contract when success
    Given i delete contract for company <companyId>
    And shipwell wants create a new contract with shipwell auth <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the contract with <clientId>, <clientSecret>, <grant_type>, <scope>, <active>, <companyId>, <scacCode>
    Then validate status and contract created correctly

    Examples:
    |companyAuth|userIdAuth|clientId                         | clientSecret                                      | grant_type        | scope       |active|companyId|scacCode  |
    |      008  |   gbhytrd| 7mo5roip0ovkpb1vhma6f2vnv4      |inuj0606dj6v6eatjbl3esg9mej3c5qn0v0cgua2o37c7ldq97e|client_credentials | null        |true  |  008    |CIAN4      |
    |      009  |   gbhytrd| Q86ffsVQ8fKgv2drdOvtLVBfkOPT2w51|pn7i6HipcKxunkuP1gonwDw2idQPnZhewck5b9rc           |client_credentials |freight.loads|true  |  009    |UFLB4    |
    |      0010  |   gbhytrd| SHIPWELLTX                      |wBBbcmjMqMWfwFsx                                   |client_credentials |ExternalApi  |true  |  0010    |CLLQ4      |

 @contractCreate @contractAlreadyExist @test @contract
  Scenario Outline: I create contract when the contract exists
    Given shipwell wants create a new contract with shipwell auth <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the contract with <clientId>, <clientSecret>, <grant_type>, <scope>, <active>, <companyId>, <scacCode>
    Then validate status and contract was not created because the contract already exists

   Examples:
     |companyAuth|userIdAuth|clientId                         | clientSecret                                      | grant_type        | scope       |active|companyId|scacCode  |
     |      001  |   gbhytrd| 7mo5roip0ovkpb1vhma6f2vnv4      |inuj0606dj6v6eatjbl3esg9mej3c5qn0v0cgua2o37c7ldq97e|client_credentials | null        |true  |  001    |CIAN      |

  @contractCreate @contractCompanyNotExist @test @contract
  Scenario Outline: I create contract when the company not exist
    Given shipwell wants create a new contract with shipwell auth <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the contract with <clientId>, <clientSecret>, <grant_type>, <scope>, <active>, <companyId>, <scacCode>
    Then validate status and contract was not created because the company does not exist

    Examples:
      |companyAuth|userIdAuth|clientId                         | clientSecret                                      | grant_type        | scope       |active|companyId|scacCode  |
      |      123  |   gbhytrd| SHIPWELLTX                      |wBBbcmjMqMWfwFsx                                   |client_credentials |ExternalApi  |true  |  789    |CLLQ      |

  @contractCreate @contractNotCarrier @test @contract
  Scenario Outline: I create contract when the carrier not exist
    Given shipwell wants create a new contract with shipwell auth <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the contract with <clientId>, <clientSecret>, <grant_type>, <scope>, <active>, <companyId>, <scacCode>
    Then validate status and contract was not created because the carrier does not exist

   Examples:
     |companyAuth|userIdAuth|clientId                         | clientSecret                                      | grant_type        | scope       |active|companyId|scacCode  |
     |      123  |   gbhytrd| SHIPWELLTX                      |wBBbcmjMqMWfwFsx                                   |client_credentials |ExternalApi  |true  |  123    | YYYY      |

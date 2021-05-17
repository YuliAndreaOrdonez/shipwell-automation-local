#language: en

Feature: As shipwell I want to have a create rating
  As a Shipwell
  I want to create new rating

  @ratingCreate @ratingCreateSuccess @test @rating
  Scenario Outline: I create rating when success
    Given delete quote <shipmentId>
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the rating to carrier with shipment <shipmentId>, <scac>, <shipperId>, <quoteId>
    Then validate status and rating created correctly

    Examples:
      |companyAuth|userIdAuth|shipmentId|scac |shipperId   |quoteId     |
      |    001    |gbhytrd   |TESTONLY  | CIAN|demo-shipper|demo-shipper|
      |    003    |gbhytrd   |TESTONLY1 | CLLQ|demo-shipper|demo-shipper|
      |    002    |gbhytrd   |TESTONLY2 | UFLB| TESTONLY   |abc123      |


  @ratingCreate @ratingCreateCompanyWithoutContract @test @rating
  Scenario Outline: I create rating when company is not associated to contract
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the rating to carrier with shipment <shipmentId>, <scac>, <shipperId>, <quoteId>
    Then validate status and it is not created correctly because there is no contract associated with the company <companyAuth>

    Examples:
      |companyAuth|userIdAuth|shipmentId |scac |shipperId   |quoteId     |
      |    011    |gbhytrd   |TESTONLY   | CIAN|demo-shipper|demo-shipper|

  @ratingCreate @ratingCreateCompanyNonExists @test @rating
  Scenario Outline: I create rating when company does not exist
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When  shipwell try makes the creation of the rating to carrier with shipment <shipmentId>, <scac>, <shipperId>, <quoteId>
    Then validate status and it is not created correctly because the companyId does not exists

    Examples:
      |companyAuth|userIdAuth|shipmentId |scac |shipperId   |quoteId     |
      |    4656   |gbhytrd   |TESTONLY2   | CIAN|demo-shipper|demo-shipper|


  @ratingCreate @ratingCreateRepeatedShipmentId @test @rating
  Scenario Outline: I create rating shipmentId is repeated
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When  shipwell try makes the creation of the rating to carrier with shipment <shipmentId>, <scac>, <shipperId>, <quoteId>
    Then validate status and it is not created correctly beacuse shipmentId is repeated

    Examples:
      |companyAuth|userIdAuth|shipmentId |scac |shipperId   |quoteId     |
      |    007    |gbhytrd   |TESTONLYR  | CIAN|demo-shipper|demo-shipper|

  @ratingCreate @ratingCreateCarrierWithRatingFalse @test @rating
  Scenario Outline: I create rating when carrier has rating in false
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the rating to carrier with shipment <shipmentId>, <scac>, <shipperId>, <quoteId>
    Then validate status and rating is not created

    Examples:
      |companyAuth|userIdAuth|shipmentId |scac |shipperId   |quoteId     |
      |    012    |gbhytrd   |TESTONLY   | CIAN20|demo-shipper|demo-shipper|
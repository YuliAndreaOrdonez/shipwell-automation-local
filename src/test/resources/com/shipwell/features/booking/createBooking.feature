#language: en

Feature: As shipwell I want to have a create booking
  As a Shipwell
  I want to create new booking

  @bookingCreate @bookingCreateSuccess @test @booking
  Scenario Outline: I create booking when success
    Given shipwell delete booking for company <companyId>
    And shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the booking to carrier <carrier> <shipmentId>
    Then validate status and booking created correctly

    Examples:
      |companyAuth|userIdAuth|carrier|shipmentId|companyId|
      |    003    |   gbhytrd| CLLQ  | TESTONLY1|003      |


  @bookingCreate @bookingAlreadyExist @test @booking
  Scenario Outline: I create booking when it already exists
    And shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try makes the creation of the booking to carrier <carrier> <shipmentId>
    Then validate status and booking was not created because it already exist

    Examples:
      |companyAuth|userIdAuth|carrier|shipmentId|
      |    007    |   gbhytrd| CLLQ  | TESTONLY17 |


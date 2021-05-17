#language: en

Feature: As shipwell I want to get a file

  @imagingGet @imagingGetSuccess @test @imaging
  Scenario Outline: I get a file
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try to get a file <type>, <shipmentId>, <carrier>
    Then validate status and file <type>

    Examples:
      |companyAuth|userIdAuth|type          |shipmentId |carrier |
      |    003    | gbhytrd  |VendorInvoice | TESTONLY1 |  CLLQ  |

  @imagingGet @imagingGetFileNotExist @test @imaging
  Scenario Outline: I get a file and fail
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try to get a file <type>, <shipmentId>, <carrier>
    Then validate status and get file failed

    Examples:
      |companyAuth|userIdAuth|type          |shipmentId |carrier |
      |    003    | gbhytrd  |invalidType | TESTONLY1 |  CLLQ  |




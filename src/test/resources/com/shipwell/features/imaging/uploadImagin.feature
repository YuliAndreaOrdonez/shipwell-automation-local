#language: en

Feature: As shipwell I want to upload a file

  @imagingUpload @imagingUploadSuccess @test @imaging
  Scenario Outline: I upload a file
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try to upload a file <file>, <type>, <extension>, <shipmentId>, <carrier>
    Then validate status and imagine created correctly

    Examples:
      |companyAuth|userIdAuth|file         |type          |extension|shipmentId |carrier |
      |    003    | gbhytrd  | image.zip   |VendorInvoice |   Zip   | TESTONLY1 |  CLLQ  |

  @imagingUpload @imagingUploadShipmentIdDoesntExists @test @imaging
  Scenario Outline: I upload a file with shipment id that doesnt exist
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try to upload a file <file>, <type>, <extension>, <shipmentId>, <carrier>
    Then validate status and imagine was not created correctly <shipmentId>

    Examples:
      |companyAuth|userIdAuth|file         |type          |extension|shipmentId |carrier |
      |    003    | gbhytrd  | image.zip   |VendorInvoice |   Zip   | TESTONLY112 |  CLLQ  |


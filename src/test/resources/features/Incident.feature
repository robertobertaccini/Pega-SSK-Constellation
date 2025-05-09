Feature: Incident

	@incident
  Scenario Outline: Incident
    Given A User logs in as customer
    When I create a new incident
    And I select incident type "Product faulty or unsafe" with subtype "Product not as described"
    Then I search by "Category" having category like "Chocollate" and cost 100
    When i select the "Chocollate Pirates" product
    And i provide contact info with manual address
    And i select "Refund" for resolution method 
    Then i review the case and submit
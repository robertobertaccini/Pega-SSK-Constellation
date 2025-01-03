	Feature: Sample feature to create a case type

  #author : ABCD
  @TC-02 @smoke
  Scenario: Sample Scenario to create a case type
    Given A User logs in as admin for testapp
    When user navigates to cases explorer
    And creates a new case type "MyTestCaseType"
    Then the new case type should be created
    When user saves the case type
    Then the case type should be saved successfully without any errors
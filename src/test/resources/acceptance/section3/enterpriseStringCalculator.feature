Feature: Enterprise String Calculator acceptance tests

  Scenario: Empty string
    Given initialize calculator
    When line number  is
    Then sum should be equal 0

  Scenario: One positive number
    Given initialize calculator
    When line number 1 is
    Then sum should be equal 1

  Scenario: Two positive numbers
    Given initialize calculator
    When line number 1,2 is
    Then sum should be equal 3

  Scenario: One positive number and One negative number
    Given initialize calculator
    When line number 1,-1 is
    Then should throw exception with message 'negatives not allowed: -1'

  Scenario: Two negative numbers
    Given initialize calculator
    When line number -1,-2 is
    Then should throw exception with message 'negatives not allowed: -1, -2'

  Scenario: Ignore number bigger then 1000
    Given initialize calculator
    When line number 1001 is
    Then sum should be equal 0

  Scenario: Just ignore numbers bigger then 1000
    Given initialize calculator
    When line number 1,1001,1002 is
    Then sum should be equal 1

  Scenario: Positive numbers include ZERO
    Given initialize calculator
    When line number 0 is
    Then sum should be equal 0

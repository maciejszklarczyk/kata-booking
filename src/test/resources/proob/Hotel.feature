Feature: Hotel
  Background:
    Given there is a hotel

  Scenario: Book free room
    Given there is a free room
    When person A books it
    Then it is booked by person a
    And it can no longer be booked
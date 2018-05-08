Feature: Hotel

  Background:
    Given there is a hotel

  Scenario: Book free room
    Given there is a free room
    When person A books it
    Then it is booked by person a
    And it can no longer be booked

  Scenario: Cancel booking
    Given person A has a booking
    When he cancels his booking
    Then the room becomes free

  Scenario: List booking
    Given there are a list of free rooms with some bookings made
    When the list of bookings is displayed
    Then each room points to a person booking it or is it available

  Scenario: Hold booking
    Given person a owes person b 99$
    And person b owes person c 41$
    When person a borrows person c 30$
    Then person a owes person b 69$
    And person b owes person c 11$

  Scenario: Print booking history for a room
    Given multiple people booked the same room
    When a booking history is printed
    Then the list of historical bookings display name of people booking and time the booking was made or canceled
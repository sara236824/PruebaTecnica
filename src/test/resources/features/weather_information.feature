#autor: Sara Padilla

Feature: Weather Information
  I need, as a user, to be able to consult the weather from the api in order to ensure the quality of the service.


  Scenario Outline: Successful consult weather information by name of city
    Given the user consulted latitude and longitude of the "<city>" with  "<key>"
    When the user sends the weather consult by city requests with the  "<key>"
    Then the user sees the weather in "<city>"
    Examples:
      | city     | key                              |
      | Medellín | 9144972807d3a861a62dd82dbbba0d8d |
      | Zocca    | 9144972807d3a861a62dd82dbbba0d8d |
      | London   | 9144972807d3a861a62dd82dbbba0d8d |


  Scenario Outline: Consult weather information with empty city
    Given the user consulted latitude and longitude of the "<city>" with  "<key>"
    Then The user will see the failed message
    Examples:
      | city | key                              |
      |      | 9144972807d3a861a62dd82dbbba0d8d |


  Scenario Outline: Successful consult  weather information by latitude and longitude
    When the user sends the weather consult with "<lat>" and "<lon>" and  "<key>"
    Then the user sees that "<lat>" and "<lon>" for the weather in "<city>"  is correct
    Examples:
      | city      | key                              | lat   | lon    |
      | Zocca     | 9144972807d3a861a62dd82dbbba0d8d | 44.34 | 10.99  |
      | La Merced | 9144972807d3a861a62dd82dbbba0d8d | 4.65  | -74.08 |


  Scenario Outline: Consult  weather information with empty latitud
    When the user sends the weather consult with "<lat>" and "<lon>" and  "<key>"
    Then The user will see the failed latitud message
    Examples:
      | key                              | lat | lon    |
      | 9144972807d3a861a62dd82dbbba0d8d |     |        |
      | 9144972807d3a861a62dd82dbbba0d8d | ada | -74.08 |

  Scenario Outline: Consult  weather information with empty longitude
    When the user sends the weather consult with "<lat>" and "<lon>" and  "<key>"
    Then The user will see the failed longitude message
    Examples:
      | key                              | lat  | lon |
      | 9144972807d3a861a62dd82dbbba0d8d | 4.65 | ada |


  Scenario Outline: Successful consult of weather information in Json format
    When the user sends the weather consult with "<lat>" and "<lon>" and  "<key>"
    Then the user sees the weather in Json format
    Examples:
      | key                              | lat   | lon   |
      | 9144972807d3a861a62dd82dbbba0d8d | 44.34 | 10.99 |


  Scenario Outline: Successful consult of weather information in XML format
    When the user sends the consult of weather in XML format with the "<city>"  and  "<key>"
    Then the user sees the weather in xml format
    Examples:
      | key                              | city  |
      | 9144972807d3a861a62dd82dbbba0d8d | Zocca |




Feature: API automaton over Demo Pet Store
Background: I want to test different API operations on this API

@post
Scenario Outline: Creating a new user
		When I hit the API with <id> <username> details
		Then I verify success status code
		Then I verify response body is not blank

	Examples:
			| id   | username |
			| 101  | AP0106   |

@get
Scenario Outline: Fetching the details of newly added user
		When I hit API with <username> username
		Then I verify success status code
		Then I verify response body is not blank
	
	Examples:
			| username |
			| AP0106   |
       
      
@get
 Scenario Outline: Fetching all pets with status sold
    When I hit get API with <status> status
    Then I verify success status code 
    Then I verify response body is not blank
    Then I store values from <status> response body
 
   Examples: 
      | status    |
      | sold      |
      
      
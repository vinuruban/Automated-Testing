Feature: Testing SwaggerUI-hotels - 'http://localhost:8090/example/v1/hotels'

Scenario Outline: Test 'Post' requests using table
	Given a valid RequestSpec
	When a post request with city "<city>", id "<id>", l1 "<line1>", l2 "<line2>", name "<state>" and rating "<zip>" is sent
	Then the response will have Status Code of "<statusCode>"

	Examples:
	| city | id | line1 | line2 | state | zip |
	| Manchester | 1 | 23 twl lane | harrow | dunnoe | cvafa |
	| Glasgow | 2 | 23 ewdf lane | tooting | dunnoe | fsdfd |
	| York | 3 | 324 asdas lane | ealing | dunnoe | asfaf |

Scenario: Test 'Get all' request
	Given a valid RequestSpec
	When a get request is sent
	Then the response will have Status Code of 200

Scenario: Test 'Put' request
	Given a valid RequestSpec
	When a Put request is entered to update id 7's line1
	Then the response will have Status Code of 204

Scenario Outline: Test 'Delete' request
	Given a valid RequestSpec
	When a Delete request is sent for id "<id>"
	Then the response will have Status Code of 204

	Examples:
	| id |
	| 58 |
	| 59 |
	| 60 |
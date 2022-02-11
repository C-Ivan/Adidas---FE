Adidas Tech Challenge - QA - FE
Iván Cañete

The challenge is implemented in the adidasFrontEndExercise.feature

The other features contains a set of extra test cases

-------------------------------------------------------------------------------

Commands to execute the tests from the terminal:

To run only the challenge:
mvn clean test -D cucumber.filter.tags="@challenge"

To run all the tests:
mvn clean test


-------------------------------------------------------------------------------

The reports are automatically generated after each execution, a new folder will be created in the root of the project, with the following format:
CucumberExtent-Reports {date} {hour}

Inside this folder will be a Spark.html file with said report (In IntelliJ I have to manually refresh the project to see the generated folder)

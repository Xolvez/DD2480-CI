# Assignment 2 - DD2480 - Continous Integration

## Building and testing the backend

In order to be able to build and run the tests, a few tools are needed.

- Mongodb
- Maven
- Java version 19

To build and run the server, make sure MongoDB is running and then run the following command inside the backend directory:
`mvn clean spring-boot:run`

To run the tests, use the following command inside the backend directory:
`mvn test`

## Running and testing the frontend

In order to run and test the frontend, npm is needed. With npm installed, enter the frontend directory and run:
`npm install`

This will install the packages required to run the frontend.

To run the tests, use the following command in the same directory.
`npm test`

To start the frontend application, run the following command:
`npm start`

This will start the frontend app on port 3000, and the application can be accessed at
`http://localhost:3000`

If port 3000 is already in use, React will ask if you want to run the app on another port instead. If you choose to do this, the frontend application may be unable to fetch the events from the backend server, since some browsers block cors requests to servers not configured with the Access-Control-Allow-Origin header. The server is currently configured to set this header for requests made by "http://localhost:3000", so if another port is used for the frontend, it may not work. Since the backend uses a local database, it will be empty anyway when you start up the server for the first time.

## Compilation/test execution implementation and testing
The CI server supports compiling and executing the automated tests of the group project. Testing is triggered as webhook, on the branch where the change has been made, as specified in the HTTP payload. Currently, the server only does this if a commit is made to a branch called "assessment". The compilation/testing is done using methods of the RepoCloner and ProcessGenerator classes in the utils directory. These methods are unit tested on a previous branch called "test", which is set to compile successfully but fail a single dummy test case. This branch is compiled and tested by calling "mvn test".
 
## Statement of contributions
Daniel Ericsson: Commits by HelloDane. Created multiple backend interfaces/functions. Implemented and tested functions for cloning and compiling repos. Code review. Wrote parts of the documentation, such as statements of contributions.

Marcus Friberg: Commits by Xolvez. Created multiple backend interfaces/functions. Set up the project skeleton with Spring and created the frontend using React. Code review. Wrote several parts of the documentation.

Siyang Yang: Commits by Kawbat. Created multiple backend interfaces/functions. Code review. Created GithubRequest class, build endpoints, email functionality. Wrote parts of the documentation, such as Essence state.

## Essence standard assessment
According to the Essence standard, there are five states that describe a team and its progress. They are Seeded, Formed, Collaborating, Performing, and Adjourned.

We have fulfilled the state “Seeded” by defining the mission requirement and constraints. We have a fixed-size team, and the responsibilities of team members are outlined.

We have fulfilled the state “Formed” by making sure every team member understands the team organization, individual roles, and the way to perform the work. We use Discord to share information and hold online meetings. Each team member commits to working on the team as defined.

We have fulfilled the state “Collaborating” by having open and honest communication between team members, trusting each other, and focusing on achieving the team mission. The team makes regular meetings to update the process and is working as one cohesive unit.

Finally, we are currently in the "Performing" state, since the team is achieving effective progress with minimal reworking, and wasted work is identified and eliminated continuously. The team continuously adapts to the changing context and solves problems.

We have not yet reached the “Adjourned” state, since we still need to put further effort to complete the mission. For example, we need more time to improve the details of our documentation on how to set up the environment and dependencies for the project, and how to get the project running. We are going to reach this state after we hand in the assignment.

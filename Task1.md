# Task 1
Imagine the following situation. You need to establish a QA process in a cross-functional team.
The team builds a front-end application using REST APIs.
#### 1. *Where would you start? What would be your first steps?*

1. Clarify requirements as much as it is possible in the very beginning and define what aspects are to be tested
2. Gather a team
3. While the team members are writing test cases for the first phase of testing, you as a QA lead create a master test-plan with description of OS, browsers and devices, milestones, features-to-test, types and levels of testing, tools, team roles, possible risks and their solving, etc.
4. Communicate with a developer lead and sync the test plan and the dev plan to avoid possible risk of unsynchronization between them - both should be tied to each other

#### 2. *Which process would you establish around testing new functionality? How would youwant the features to be tested?*

As it was mentioned above, the test plan and the developer plan should be tied to each other. The features are tested just after they have been  implemented (by this time the test cases have been already written). In the end of every iteration the regression testing is performed. If the project is long enough (and/or regression is planned to be performed often) then test automation engineers automate the test cases in order as much regression can be provided in a not manual way as it is possible.
So shortly testing process looks the following way in every iteration: creating test cases -> feature testing -> bugs verifying and test cases upgrade if needed  -> regression testing. 

#### 3. *Which tools would you suggest using to help your team with a daily work?*

1. For team members collaboration, keeping and discussing the requirements it would be nice to have some collaboration tool like Confluence.
2. For bug tracking - JIRA.
3. Some test case management tool either integrated to the bug-tracker one or not (e.q. Zephyr plugin to Jira, TestRail, etc.)
4. For manual API testing - something like Postman, Fiddler, etc.
5. For Continuous Integration it would be great to have a special tool like Jenkins or TeamCity.

#### 4. *If you would do a test automation which techniques or best practices would you use the application?*

1. Test not only UI but API as well.
2. For UI automation use Page Object pattern.
3. Use implicitly waits for UI automation.
4. Give easily understandable names to all methods and variables.
5. Use framework with clear reportings, detailed logs, screenshots for fails.
6. Use Continuous Integration for test automation.
7. Think about BDD framework.

### Author
 **Alexander Ognev** 

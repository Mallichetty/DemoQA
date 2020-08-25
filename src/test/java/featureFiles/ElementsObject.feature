Feature: Validation of DemoQA Site

@tests
Scenario: Open the DemoQA site and Enter the Details retrived from WebTables
Given User is in HomeScreen
When User navigated to Elements Objects
Then User should fetch the webTable values and store it in a array
Then User should use the same array values to add the new User

@tests
Scenario: Open different Window tabs 
Given User is already on the DemoQA site
When User navigated to Alerts objects
Then User should click the Browser window button
And User should Open the New tab and close it
And User should Open the New window and close it
And User should Open the New Window Message and close it

@tests
Scenario: Switching between Frames
When User is already on the Alerts objects
Then User should click on the Framelink Click
And User should switch to Frame1 and get the frame text1
And User should switch to Frame2 and get the frame text2

@tests
Scenario: Filling Form
Given User is on Home Page
When User Navigated to Forms Object
Then User should click on formlink
And User should click on PracticeForm link
And User should set the field values
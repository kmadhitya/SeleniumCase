Feature: Create Edit and Delete Opportunity record

Scenario Outline: Verify if a User can create an Opportunity successfully
#Given I launch the browser and login to the Salesforce application
Given I click on the AppLauncher
And I click on Sales
And I click on Opportunity label
When I click on New button
And I enter Opportunity Name <OpportunityName>
And I select CloseDate As Today
And I select Stage As Needs Analysis <Stage>
And I click on Save button
Then I verify the Toast Message <ToastMessage>
And I verify the Opportunity Name <OpportunityName>

Examples:
| OpportunityName                        | Stage            | ToastMessage                                                     |
| 'Salesforce Automation by Adhitya123'  | 'Needs Analysis' | 'Opportunity "Salesforce Automation by Adhitya123" was created.' |

Scenario Outline: Verify if a User can edit an Opportunity successfully
#Given I launch the browser and login to the Salesforce application
Given I click on the AppLauncher
And I click on Sales
And I click on Opportunity label
When I open the Opportunity
And I edit the Opportunity
And I clear and select Date
And I select Stage as Perception Analysis
And I select Delivery Status from None to In progress
And I click on Save button
Then I select Details tab
And I verify Close Date
And I verify the Stage value <Stage>

Examples:
| Stage                 |
| 'Perception Analysis' |

Scenario Outline: Verify if a User can delete an Opportunity successfully
#Given I launch the browser and login to the Salesforce application
Given I click on the AppLauncher
And I click on Sales
And I click on Opportunity label
When I search the Opportunity using <OpportunityName>
And I open the Opportunity
And I click on delete Opportunity
And I click on confirm delete
And I click on clear Search Text
And I search the Opportunity using <OpportunityName>
Then I should see No Items Displayed Message <message>

Examples:
| OpportunityName  | message                |
| 'Adhitya'        | 'No items to display.' |
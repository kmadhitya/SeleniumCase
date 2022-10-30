Feature: Create Edit and Delete Account record

Scenario Outline: Verify if a User can create an Account successfully
#Given I launch the browser and login to the Salesforce application
Given I click on the AppLauncher
And I click on Sales
And I click on Account label
And I click on New button
When I enter Account Name <AccountName>
And I select Ownership as Public
And I click on Save button
Then I verify the Account Name <AccountName>


Examples:
| AccountName   |
| 'Adhitya123'  |

Scenario Outline: Verify if a User can edit an Account successfully
#Given I launch the browser and login to the Salesforce application
Given I click on the AppLauncher
And I click on Sales
And I click on Account label
And I open first Account
When I edit the Account
And I enter Phone <Phone>
And I select Type as Technology Partner
And I select Industry as HealthCare
And I enter Billing Address <BillingAddress>
And I enter Shipping Address <ShippingAddress>
And I select Customer Priority as Low
And I select SLA as Silver
And I select Active as No
And I select Upsell Opty as No
And I click on Save button
And I select Account Details tab
Then I verify the Type <Type>


Examples:
| Phone        | BillingAddress        | ShippingAddress        | Type                 |
| '9090009090' | '101 Billing Address' | '201 Shipping Address' | 'Technology Partner' |

Scenario Outline: Verify if a User can edit an Account successfully
#Given I launch the browser and login to the Salesforce application
Given I click on the AppLauncher
And I click on Sales
And I click on Account label
And I search the Account <SearchText>
When I open first Account
And I delete Account
And I confirm Delete Account
And I click on clear Search Text
And I search the Account <SearchText>
Then I should see No Items Displayed Message <ExpectedText>


Examples:
| SearchText  | ExpectedText           |
| 'Adhitya'   | 'No items to display.' |


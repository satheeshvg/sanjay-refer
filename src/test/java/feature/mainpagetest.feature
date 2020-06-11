Feature: iphonelandingpage Test cases

Scenario: Check the stock availability and colour selection
Given user navigates to the url "https://www.amazon.com" and prerequisites are set
When user searches for "iphone" and clicks on the specific iphone
Then mainpage should have the stock unavailability text
And selected colour must be displayed in the colour column
And close the browser














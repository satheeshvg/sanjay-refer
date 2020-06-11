@two
Feature: iphonelandingpage Test cases

Scenario: Check the no of checkbox in brandcolumn, search result and the no of links in footer
Given user navigates to the url "https://www.amazon.com" and prerequisites are set
When user searches for "iphone"
Then iphonelanding page should have 12 checkbox in brand column
And search result should be "iphone"
And footer should have 36 links
And close the browser













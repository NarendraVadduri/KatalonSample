import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

'Navigating to HelixSense\r\n'
WebUI.navigateToUrl(GlobalVariable.Url)

WebUI.waitForPageLoad(GlobalVariable.MediumWaitTime)

WebUI.verifyElementVisible(findTestObject('HelixSenseWebApp/Page_Login/input_Enter Account IDAlias_accountId'))

WebUI.sendKeys(findTestObject('HelixSenseWebApp/Page_Login/input_Enter Account IDAlias_accountId'), GlobalVariable.QA_AccountID)

WebUI.waitForElementVisible(findTestObject('HelixSenseWebApp/Page_Login/button_Next_AccountPage'), GlobalVariable.MediumWaitTime)

WebUI.click(findTestObject('HelixSenseWebApp/Page_Login/button_Next_AccountPage'))

WebUI.waitForElementVisible(findTestObject('HelixSenseWebApp/Page_Login/input_Username or Email_username'), GlobalVariable.MediumWaitTime)

WebUI.sendKeys(findTestObject('HelixSenseWebApp/Page_Login/input_Username or Email_username'), GlobalVariable.Username)

WebUI.sendKeys(findTestObject('HelixSenseWebApp/Page_Login/input_Password_password'), GlobalVariable.Password)

WebUI.delay(3)

WebUI.click(findTestObject('HelixSenseWebApp/Page_Login/button_Login'))

//if(WebUI.verifyElementPresent(findTestObject('HelixSenseWebApp/Page_Login/button_No'),3, FailureHandling.OPTIONAL))
//{
//	WebUI.click(findTestObject('HelixSenseWebApp/Page_Login/button_No'))
//}
WebUI.waitForElementVisible(findTestObject('HelixSenseWebApp/Page_Login/h3_All Buildings'), GlobalVariable.MediumWaitTime)

String labelAllBuildingsTextActual = WebUI.getText(findTestObject('HelixSenseWebApp/Page_Login/h3_All Buildings'))

WebUI.verifyMatch(labelAllBuildingsTextActual, LoginSuccess, false)

if (WebUI.verifyElementVisible(findTestObject('HelixSenseWebApp/Page_Login/button_Ok'), FailureHandling.OPTIONAL)) {
	
	'Click on ok button'
	WebUI.click(findTestObject('HelixSenseWebApp/Page_Login/button_Ok'))
}
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.openBrowser('')

WebUI.navigateToUrl('https://p4p-qa-bg.aws.paradise4paws.com/login/?next=/reservations/add/%3Fparent_id%3D97779')

WebUI.setText(findTestObject('object_login/input_emailuser'), 'jegchavez@gmail.com')

WebUI.setEncryptedText(findTestObject('object_login/input_passworduser'), 'vRRrCeg9Qho=')

WebUI.click(findTestObject('object_login/btn_login'))

WebUI.navigateToUrl('https://p4p-qa-bg.aws.paradise4paws.com/accounts/profile/#/parents/97779/')

WebUI.click(findTestObject('object_pay/a_Add Pet'))

WebUI.click(findTestObject('object_newpet/btn_cat'))

WebUI.setText(findTestObject('null'), 'Caty')

WebUI.selectOptionByValue(findTestObject('object_pay/select_Male          Female'), 
    'M', true)

WebUI.setText(findTestObject('object_pay/input__weight'), '22')

WebUI.selectOptionByValue(findTestObject('object_pay/select_YesNo'), 
    'boolean:true', true)

WebUI.setText(findTestObject('object_pay/input__form-control ng-pristine ng-untouche_ac6102'), 
    'Abyssinian')

WebUI.click(findTestObject('object_pay/button_Save'))


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

WebUI.delay(3)

WebUI.verifyElementClickable(findTestObject('object_profile/a_addPet'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('object_profile/a_addPet'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('object_profile/a_addReservation'))

WebUI.click(findTestObject('object_profile/a_createInvoice'))

WebUI.click(findTestObject('object_newpet/btn_cat'))

WebUI.setText(findTestObject('object_newpet/input__petName'), 'Titi')

WebUI.selectOptionByValue(findTestObject('object_newpet/input__breed'), 'M', true)

WebUI.setText(findTestObject('object_newpet/input__petWeight'), '22')

WebUI.selectOptionByValue(findTestObject('object_newpet/select_spayed'), 'boolean:true', true)

WebUI.setText(findTestObject('Object Repository/Page_Paradise 4 Paws  Dog Boarding Cat Boar_145431/input__form-control ng-pristine ng-untouche_ac6102'), 
    'bengal')

WebUI.click(findTestObject('object_newpet/btn_save'))

WebUI.click(findTestObject('Object Repository/Page_Paradise 4 Paws  Dog Boarding Cat Boar_145431/div_Titi'))

WebUI.click(findTestObject('Object Repository/Page_Paradise 4 Paws  Dog Boarding Cat Boar_145431/input__form-control ng-pristine ng-untouche_033636'))


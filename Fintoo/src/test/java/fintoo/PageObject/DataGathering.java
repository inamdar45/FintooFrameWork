package fintoo.PageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import fintoo.Testcases.BaseClass;
import fintoo.Utilities.functions;

public class DataGathering {
 public	int t=1;
   public String text;
	 WebDriver driver;
	 public By fintooCard = By.xpath("//button[@ng-click='addItemToCartPlan(plan)']");
	public By scoreCard =By.xpath("//h2[text()='Your Score Card ']");
	public By myPlan = By.xpath("(//span[text()='My plans'])[1]");
	public By knowYourRiskLink =By .id("tab-btn3");
	public By yourFamilyLink =By .id("tab-btn4");
	public By continueButton01 =By.xpath("(//a[text()='Continue'])[1]");
	public By addDataButton= By.xpath("//button[text()='Add data']");
   public By aboutYouLink= By.xpath("//a[text()=' About You']");
	public By incomeTaxLink= By.xpath("//td[text()='Income tax']");
	public By incomeAndExpenseLink= By.xpath("//td[text()='Income & Expenses']");
	public By goalsLink= By.xpath("//td[text()='Goals']");
	public By insuranceLink= By.xpath("//a[text()=' Insurance']");
	public By assetAndLiabilitiesLink= By.xpath("//li[@class='assets-liabilities navigation-icon']");
	public By retirementLink= By.xpath("//td[text()='Retirement']");
	public	By documentLink= By.xpath("//a[text()=' My Documents']");
	// Your Info locators
	public	By firstName= By.xpath("//input[@ng-model='user.first_name']");
	public By lastName= By.xpath("//input[@ng-model='user.last_name']");
	public By residentialAddress= By.id("addresscombine");
	public By pinCode= By.xpath("//input[@name='pin_code']");
	public By emailAddress = By.xpath("//input[@ng-model='user.email']");
	public By panNo= By.xpath("//input[@name='pan']");
	public By mobileNo= By.xpath("//input[@name='mobile']");
	public By alternateMobileNo = By.xpath("//input[@name='alternate_mobile']");
	public By dOB =By.xpath("//input[@ng-model='user.dob']");
	public By age = By.id("age");
	public By saveAddMoreAssetsLib = By.xpath("(//button[text()='Save & Add More'])[1]");
	public By saveAddMoreLiabilities = By.xpath("(//button[text()='Save & Add More'])[3]");
	public By saveLiabilities = By.id("liabilitySavebtn");
	public By salaryRange=By.xpath("//label[contains(text(),'"+ text +" ')]");
	public By occupation = By.xpath("(//span[@class='ui-selectmenu-text'])[1]");
	public 	By gender= By.xpath("(//label[contains(text(),'Male')])[1]");
	public 	By retirementAge = By.id("retirement_age");
	public 	By lifeExpectancy = By.xpath("//input[@name='life_expectancy']");
	public 	By remark = By.xpath("(//input[@name='remark'])[1]");
	public By saveAndContinue=By.xpath("//button[text()='Save & Continue']");
	public By calenderYear = By.xpath("//select[@class='ui-datepicker-year']");
	public By calenderMonth = By.xpath("//select[@class='ui-datepicker-month']");
	public By date = By.xpath("(//a[text()='10'])[2]");
	public By saveAddMoreButton = By.id("incomeSavebtn");
	public By familySaveAddMoreButton = By.id("familySavebtn");
	public By expenseSaveAddMoreButton=By.id("expensesSavebtn");
	public By firstNameErrorMsg = By.id("first_name-error");
	public By lastNameErrorMsg = By.id("last_name-error");
	public By resAddressErrorMsg = By.id("addresscombine-error");
	public By pinCodeErrorMsg = By.id("pin_code-error");
	public By panNoErrorMsg = By.id("pan-error");
	public By dobErrorMsg = By.xpath("//span[text()='Please enter date of birth']");
	public By occupationErrorMsg = By.xpath("//span[text()='Please select occupation']");
	public By alternateNoErrorMsg = By.id("alternate_mobile-error");
	public By retirementAgeErrorMsg = By.id("retirement_age-error");
	public By familyRetirementAgeErrorMsg = By.id("fretirement_age-error");
	public By lifeExpectancyAgeErrorMsg = By.id("life_expectancy-error");
	public By familyLifeExpectancyAgeErrorMsg = By.id("flife_expectancy-error");
	//Locators for know your risk
	
	public By currentStageOfLife=By.xpath("//label[contains(text(),'Single with few financial burdens.')]");
	//public By nextButton = By.xpath("//button[text()='Next']");
	public By nextButton1 = By.xpath("(//button[text()='Next'])[1]");
	public By nextButton2 = By.xpath("(//button[text()='Next'])[2]");
	public By nextButton3 = By.xpath("(//button[text()='Next'])[3]");
	public By nextButton4 = By.xpath("(//button[text()='Next'])[4]");
	public By nextButton5 = By.xpath("(//button[text()='Next'])[5]");
	public By nextButton6 = By.xpath("(//button[text()='Next'])[6]");
	public By nextButton7 = By.xpath("(//button[text()='Next'])[7]");
	public By nextButton8 = By.xpath("(//button[text()='Next'])[8]");
	public By nextButton9 = By.xpath("(//button[text()='Next'])[9]");
	public By saveButton= By.xpath("//button[text()='Save']");
	public By dataGatheringSaveButton1 = By.xpath("(//button[text()='Save'])[1]");
	public By dataGatheringSaveButton2= By.xpath("(//button[text()='Save'])[2]");
	public By dataGatheringSaveButton3= By.xpath("(//button[text()='Save'])[3]");
	public By dataGatheringSaveButton4= By.xpath("(//button[text()='Save'])[4]");
	public By dataGatheringSaveButton5= By.xpath("(//button[text()='Save'])[5]");
	public By dataGatheringSaveButton6= By.xpath("(//button[text()='Save'])[6]");
	public By dataGatheringSaveButton7= By.xpath("(//button[text()='Save'])[7]");
	public By dataGatheringSaveButton8= By.xpath("(//button[text()='Save'])[8]");
	public By dataGatheringSaveButton9= By.xpath("(//button[text()='Save'])[9]");
	public By dataGatheringSaveButton10= By.xpath("(//button[text()='Save'])[10]");
	public By dGContinueButton = By.xpath("(//a[@class='next-btn form-arrow'])[1]");
	public By familyContinueButton = By.xpath("(//a[@class='next-btn form-arrow'])[2]");
	public By saveUpdate = By.id("svgStepValuekyb");
	public By familyDetailLable =By.xpath("//h3[text()='Family Details']");
	public By signOffButton = By.id("report_signoffbtn");
	public By dataGatheringButton = By.xpath("//span[text()='Data gathering']");
	public By beforeFamilyPopUp = By.xpath("//section[@id='about_you_complete_popup']//div[1]/div[2]/ul//button");
	//Locators for Your Family
	public By familyFirstName =By.xpath("//input[@ng-model='family.first_name']");
	public By familyLastName =By.xpath("//input[@ng-model='family.last_name']");
	public By familyDob =By.xpath("//input[@ng-model='family.dob']");
	public By familyRetirementAge = By.id("fretirement_age");
	public By familyLifeExpectancy = By.id("flife_expectancy");
	public By earningStatus = By.xpath("//label[@for='earning1']");
	public By spouseLabel = By.xpath("//label[contains(.,'Spouse')]");
	public By sonLabel = By.xpath("//label[contains(.,'Son')]");
	public By daughterLabel = By.xpath("//label[contains(.,'Daughter')]");
	public By fatherLabel = By.xpath("//label[contains(.,'Father')]");
	public By motherLabel = By.xpath("//label[contains(.,'Mother')]");
	public By hufLabel = By.xpath("//label[contains(.,'HUF')]");
	public By othersLabel = By.xpath("//label[contains(.,'Others')]");
	
	
	//Locators for Income & Expenses
	//Income
	//public By natureOfPayment = By.xpath("");
	public By incomeTab = By.id("tab-btn1");
	public By expenseTab = By.id("tab-btn2");
	public By incomeAndExpenseButton = By.xpath("//a[@ng-href='/datagathering/income-expenses']");
	 public By buttonExpenses= By.xpath("//a[text()='Expenses']");
	 public By incomeNameText = By.id("incomeformstart");
	 public By incomeValueText = By.xpath("//input[@ng-model='income.income_amount']");
	 public By incomeFrom = By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div[4]/div/section/div[1]/div[2]/div/div/div/div[2]/div/div/form/div[3]/div/div/span[1]");
	 public By incomeFromSelf = By.xpath("(//div[text()=' Self '])[1]");
	 public By sliderFixedVariableToggleButton = By.xpath("(//span[@class='slider round'])[1]");
	 public By sliderOneTimeOrRecurringToggleButton = By.xpath("(//span[@class='slider round'])[2]");
	 public By incomeEndDate = By.xpath("//input[@name='income_end_date1']");
	 public By incomeStartDate = By.xpath("//input[@name='income_start_date']");
	 public By annualGrowthSlider = By.xpath("(//span[@role='slider'])[1]");
	 public By salaryIncomeButton = By.xpath("(//label[contains(.,'Salary & Bonus')])[2]");
	 public By salaryIncomeButton1 = By.xpath("(//label[contains(.,'Salary & Bonus')])[1]");
	 public By postOfficeMISButton = By.xpath("//label[contains(.,'Post Office MIS')]");
	 public By businessButton = By.xpath("//label[contains(.,'Business')]");
	 public By rentalButton = By.xpath("//label[contains(.,'Rental')]");
	 public By giftsButton = By.xpath("//label[contains(.,'Gifts')]");
	 public By pensionButton = By.xpath("//label[contains(.,'Pension')]");
	 public By otherButton = By.xpath("//label[contains(.,'Other')]");
	 public By incomeNameErrorMsg = By.id("incomeformstart-error");
	 public By incomeValueErrorMsg = By.id("income_amount-error");
	 public By memberErrorMsg = By.xpath("//span[text()='Please select a member']");
	 public By endDateErrorMsg = By.xpath("//span[text()='Please select date']");
	 public By incomeStartDateRecurErrMsg = By.id("income_start_date-error");
	 public By uptoEndDateRecurErrMsg = By.xpath("//span[text()='Please select upto']");
	 public By recurringSlider = By.xpath("(//span[@class='slider round'])[2]");
	 public By houseRentButton = By.xpath("//label[contains(.,'House Rent')]");
	 
	 
	 public By houseExpenseButton1 = By.xpath("(//label[contains(.,'House Expenses')])[2]");
	 public By houseExpenseButton = By.xpath("(//label[contains(.,'House Expenses')])[1]");
	 public By incomeExpPopUp = By.xpath("//section[@id='inc_exp_complete_popup']//div[1]/div[2]/ul//button");
	 //public By houseRentButton = By.xpath("//label[contains(.,'House Rent')]");
	 public By emiButton = By.xpath("//label[contains(.,'EMI')]");
	 public By clubMembershipButton = By.xpath("//label[contains(.,'Club Membership and Subscriptions')]");
	 public By educationExpenseButton = By.xpath("//label[contains(.,'Education Expense')]");
	 public By hotelButton = By.xpath("//label[contains(.,'Hotel, Leisure and Entertainment')]");
	 public By domesticVacationButton = By.xpath("//label[contains(.,'Domestic Vacation')]");
	 public By giftButton = By.xpath("//label[@for='type-18']");
	 public By medicalButton = By.xpath("//label[contains(.,'Medical')]");
	 public By otherButtonExpense = By.xpath("//label[@for='type-20']");
	 public By expenseNameErrorMsg = By.id("expenseformstart-error");
	 public By expenseValueErrorMsg = By.id("expenses_amount-error");
	 public By expenseMemberErrorMsg = By.xpath("(//span[text()='Please select a member'])[2]");
	// public By expensememberErrorMsg = By.xpath("//span[text()='Please select a member']");
	// public By expenseEndDateErrorMsg = By.xpath("//span[text()='Please select date']");
	 public By expenseSlider = By.xpath("(//span[@class='slider round'])[5]");
	 public By expenseStartDateErrorMsg = By.id("expenses_start_date-error");
	 public By expenseEndDateErrorMsg = By.id("expenses_start_date-error");
	 public By expenseNameText = By.id("expenseformstart");
	 public By expenseValueText = By.xpath("//input[@name='expenses_amount']");
	 public By expenseForDropDown = By.xpath("(//span[@role='combobox'])[2]");
     public By expToggleFixVar =By.xpath("(//span[@class='slider round'])[3]");
     public By expToggleMandWishful =By.xpath("(//span[@class='slider round'])[4]");
     public By expToggleOneRecurr =By.xpath("(//span[@class='slider round'])[5]");
     public By expenseEndDate =By.cssSelector("[name='expenses_end_date1']");
     public By expenseStartDate = By.id("expenses_start_date");
     
     //Locators for goals
     public By goalLink=By.id("tick_goal_id");
     public By educationButton=By.xpath("//label[@for='type-2']");
     public By marriageButton=By.xpath("//label[@for='type-3']");
     public By vehicleButton=By.xpath("//label[@for='type-4']");
     public By propertyButton=By.xpath("//label[@for='type-5']");
     public By vacationButton=By.xpath("//label[@for='type-1']");
     public By emergencyButton=By.xpath("//label[@for='type-6']");
     public By goalOthersButton=By.xpath("//label[@for='type-7']");
     public By goalNameErrorMsg=By.id("formstart-error");
     public By goalSelectMemberErrormsg=By.xpath("//select[@name='goal_for_member']/preceding-sibling::span");
     public By goalCurrentValueErrMsg=By.id("goal_current_value-error");
     public By setPriorityErrMsg=By.xpath("//select[@name='goal_priority']/preceding-sibling::span");
     public By goalEndDateErrMsg=By.xpath("//input[@name='goal_end_date1']/preceding-sibling::span");
     public By goalStartDateerrMsg=By.id("goal_start_date-error");
     public By goalSaveAndAddMore = By.id("goalSavebtn");
     public By oneTimeRecurrSlider=By.xpath("//input[@name='goal_isRecurring']/following-sibling::span");
     public By goalNameTxt = By.xpath("//input[@name='goal_name']");
	 public By goalForSelect= By.xpath("//select[@name='goal_for_member']/following-sibling::span[1]");
	 public By goalPresentValueTxt = By.xpath("//input[@name='goal_current_value']");
	 public By goalEduTypeSelect= By.xpath("//select[@name='goal_eduType']/following-sibling::span[1]");
	 //public By goalEduTypeSelect= By.xpath("//select[@name='goal_eduType']");
	 public By goalPrioritySelect= By.xpath("//select[@name='goal_priority']/following-sibling::span[1]");
	 public By criticalNonCriticalToggle=By.xpath("(//span[@class='slider round'])[1]");
	 public By oneTimeRecurrToggle=By.xpath("(//span[@class='slider round'])[2]");
	 public By goalStartDate = By.xpath("//input[@name='goal_start_date']");
	 public By goalEndDate = By.xpath("//input[@name='goal_end_date']");
	 public By oneTGoalDate =By.xpath("//input[@name='goal_end_date1']");
	 public By goalsPopUp = By.xpath("//section[@id='goal_complete_popup']//div[1]/div[2]/ul//button");
	 
	 //Locators for Assets and Liabilities
	 public By assetPopUp = By.xpath("//section[@id='asset_liab_complete_popup']//div[1]/div[2]/ul//button");
	 public By assetEquityTab =By.id("cd_equity");
	 public By assetDebtTab =By.id("cd_debt");
	 public By assetRealEstateTab =By.id("cd_real_estate");
	 public By assetLiquidTab =By.id("cd_liquid");
	 public By assetAlternateTab =By.id("cd_alternate");
	 public By assetGoldTab =By.id("cd_gold");
	 public By assetUploadTab =By.id("cd_upload");
	 public By equityShareTab = By.id("equity-1");
	 public By equityMFTab = By.id("equity-2");
	 public By equityPMSTab = By.id("equity-3");
	 public By equityUnlistedTab = By.id("equity-4");
	 public By equityESOPTab = By.id("equity-5");
	 public By equityFurAndOptTab = By.id("equity-6");
	 public By equityOthersTab = By.id("equity-7");
	 public By uploadCASButton=By.id("upload_cas_opt");
	 public By manualEquityButton=By.id("manual_form_opt");
	 
	 public By selectShareErrMsg = By.id("scheme_equityshare-error");
	 public By selectShareMFErrMsg = By.id("scheme_equitymf-error");
	 public By debtShareMFErrMsg = By.id("scheme_debtmf-error");
	 public By liquidShareMFErrMsg = By.id("scheme_liquidmf-error");
	 public By goldShareMFErrMsg = By.id("scheme_goldmf-error");
	 public By assetNameErrMsg =By.id("asset_name-error");
	 public By investmentForErrMsg =By.xpath("(//span[@class='error-msg'])[2]");
	 public By numofSharesErrMsg = By .id("asset_units-error");
	 public By purchasePriceErrMsg = By .id("asset_purchase_amount-error");
	 public By currentUnitPriceErrMsg = By .id("asset_current_unit_price-error");
	 public By sipCurrentPriceErrMsg = By .id("cnav-error");
	 public By sipEndDateErrMsg = By.xpath("(//span[@class='error-msg'])[7]");
	 public By sipAmountErrMsg = By.id("asset_amount-error");
	 public By oneTRecurrSliderAsset1 = By.xpath("(//span[@class='slider round'])[1]");
	 public By oneTRecurrSliderAsset = By.xpath("//span[text()='One Time']/following::span[1]");
	 public By debtFixedDeposit = By.id("debt-1");
	 public By debtGOVScheme = By.id("debt-2");
	 public By debtMF = By.id("debt-3");
	 public By debtPostOfficeSch = By.id("debt-4");
	 public By debtGOVBond = By.id("debt-5");
	 public By debtDebentures = By.id("debt-6");
	 public By debtPPF = By.id("debt-7");
	 public By debtGratutity = By.id("debt-8");
	 public By debtSuperannuation = By.id("debt-9");
	 public By debtNSC = By.id("debt-10");
	 public By debtPensionScheme = By.id("debt-11");
	 public By debtCapitalGainBonds = By.id("debt-12");
	 public By debtOthers = By.id("debt-13");
	 public By debtAssetPurchasedateErrMsg= By.xpath("//span[text()='Please select asset purchase date']");
	 public By debtSipEndDateErrMsg = By.xpath("(//span[@class='error-msg'])[6]");
	 public By debtMaturityDateErrMsg = By.xpath("//span[text()='Please select maturity date']");
	 public By assetNameTxt =By.xpath("//input[@name='asset_name']");
	 public By investmentAmounTxt = By.xpath("//input[@name='asset_purchase_amount']");
	 public By currentUnitTxt = By.xpath("//input[@name='asset_units']");
	 public By currentNavTxt= By.xpath("//input[@name='asset_current_unit_price']");
	 public By linkGoalSelectOpt = By.xpath("//span[text()='Select option']");
	 public By debtMaturityDate =By.xpath("//input[@name='asset_maturity_date']");
	 public By debtMaturityAmount =By.xpath("//input[@name='totalmaturityamount']");
	 //Locators for Real Estate
	 public By residentialLink =By.id("real-estate-1");
	 public By commercialLink =By.id("real-estate-2");
	 public By agriculturalLandLink =By.id("real-estate-3");
	 public By holidaysLink =By.id("real-estate-4");
	 public By constructionPropertyLink =By.id("real-estate-5");
	 public By landLink =By.id("real-estate-6");
	 public By otherLink =By.id("real-estate-9");
	 public By investmentForRealEstate = By.xpath("//label[text()='Investment for']");
	 public By addAssetValueTxt =By.xpath("//input[@Name='asset_amount']");
	 public By pincodeTxt =By.xpath("//input[@name='asset_pin_code']");
	 public By pincodeErrMsg= By.id("asset_pin_code-error");
	 //Locators for Liquid Category
	 public By holderName =By.xpath("//label[text()='Name of holder']");
	 public By assetPurchaseDate = By.xpath("//input[@name='asset_purchase_date']");
	 public By startSearchDropDown =By.xpath("//input[@type='search']");
	 public By investmentForLiquid = By.xpath("//label[text()='Who is this investment for?']");
	 public By investmentFor = By.xpath("//select[@name='asset_member_id']//following::span[1]");
	public By investmentForDebt =By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div[4]/div/section/div[1]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div[1]/div[1]/div[2]/div/span[1]");
	//public By investmentForDebtMf=By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div[4]/div/section/div[1]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div[1]/div[2]/div/span[1]"); 
	 public By nameOfHolderLiab= By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div[4]/div/section/div[2]/div/div[2]/div/div/div/div[2]/div/div/form/div[2]/div[2]/div/span[1]");
	public By sipEndDate = By.xpath("//label[text()='SIP end date']");
	 public By cashBalanceTab =By.id("cash-1");
	 public By bankBalanceTab =By.id("cash-2");
	 public By liquidFundsTab =By.id("cash-3");
	 public By othersTab =By.id("cash-4");
	 public By sipEndDateTxt=By.xpath("//input[@name='asset_mf_end_date']");
	 //Locators for Alternate Category
	 public By artInvestmentTab = By.id("alternate-1");
	 public By wineInvestmentTab = By.id("alternate-2");
	 public By carsTab = By.id("alternate-4");
	 public By commoditityTab = By.id("alternate-6");
	 public By currencyTab = By.id("alternate-7");
	 public By alternateOthersTab = By.id("alternate-5");
	 //Locators for Gold
	 public By physicalGoldTab = By.id("gold-1");
	 public By goldETFTab = By.id("gold-2");
	 public By goldMFTab = By.id("gold-3");
	 public By goldBondTab = By.id("gold-4");
	 public By goldOtherTab = By.id("gold-5");
	 public By goldKaratTxt =By.xpath("//input[@name='asset_gold_karat']");
	 //Locators for Upload 
	 public By camsKarvyTab = By.xpath("//label[contains(.,'CAMS/ Karvey')]");
	 public By cdslTab = By.xpath("//label[contains(.,'CDSL')]");
	 public By nsdlTab = By.xpath("//label[contains(.,'NSDL')]");
	 public By uploadPassTxt=By.xpath("//input[@name='ecash_passkey']");
	 public By uploadPassErrMsg=By.id("ecash_passkey-error");
	 public By camsLink = By.xpath("//u[text()='CAMS']");
	 public By camsEmailTxt =By.id("mat-input-1");
	 public By camsPassTxt =By.id("mat-input-3");
	 public By camsConfirmPassTxt =By.id("mat-input-4");
	 public By camsSubmitButton = By.xpath("//button[text()='Submit']");
	 public By camsEmailErrMsg=By.id("mat-error-12");
	 public By camsPasswordErrMsg=By.id("mat-error-13");
	 public By camsConfirmPassErrMsg=By.id("mat-error-14");
	 public By camsDisclaimerAccept =By.xpath("(//div[@class='mat-radio-outer-circle'])[1]");
	 public By camsDisclaimerProceed = By.xpath("//input[@value='PROCEED']");
	 public By camsStatementLink =By.xpath("//span[text()='CAS - CAMS+KFintech+FTAMIL']");
	 public By camsFileUploadErrMsg = By.xpath("//span[@class='dz-error-messagecash error-msg']");
	 public By incorrectPdfErrMsg =By.id("error-msg");
	 // Locators for Liabilities
	 public By liabilitiesTab= By.xpath("//a[text()='Liabilities']");
	 public By housingTab =By.id("type-11");
	 public By creditCardTab =By.id("type-12");
	 public By carTab =By.id("type-13");
	 public By businessTab =By.id("type-14");
	 public By otherPropertyLoanTab =By.id("type-15");
	 public By personnalTab =By.id("type-18");
	 public By consumerTab =By.id("type-16");
	 public By familyAndFriendTab =By.id("type-17");
	 public By liabilitiesNameTxt = By.xpath("//input[@name='liability_name']");
	 public By liabNameErrMsg = By.id("formstart-error");
	 public By nameHolderDropDown=By.xpath("//label[text()='Name of the holder']");
	 public By nameHolderErrMsg =By.xpath("//span[text()='Please select name of liability holder']");
	 public By currentOutstandingamtTxt =By.xpath("//input[@name='outstandingamount']");
	 public By outstandingAmtErrMsg = By.id("outstandingamount-error");
	 public By liabilitiesEndDate = By.xpath("//input[@name='enddate']");
	 public By liabEndDateErrMsg = By.xpath("//span[text()='Please select end date']");
	 public By currentEMITxt = By.xpath("//input[@name='current_emi']");
	 public By currentEMIErrMsg = By.id("current_emi-error");
	 //Insurance Module
	 public By termPlanTab = By.id("type-2");
	 public By ulipTab = By.id("type-3");
	 public By endownmentTab = By.id("type-4");
	 public By guranteeIncomePlanTab = By.id("type-5");
	 public By generalPlanTab = By.id("type-1");
	 public By mediClaimTab = By.id("type-6");
	 public By pensionPlanTab = By.id("type-7");
	 public By otherPlanTab = By.id("type-8");
	 public By insurancePlanNameTxt =By.xpath("//input[@name='insurance_name']");
	 public By insPlanNameErrMsg =By.id("insurance_name-error");
	 public By insuranceForDropDown =By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div/form/div[2]/div[2]/div/span[1]");
	 public By insuranceForErrMsg=By.xpath("//span[text()='Please select member name']");
	 public By insPremiumAmountTxt =By.xpath("//input[@name='insurance_premium_amount']");
	 public By insPremiumAmountErrMsg=By.id("insurance_premium_amount-error");
	 public By insSumAssuredTxt=By.xpath("//input[@name='insurance_sum_assured']");
	 public By insSumAssuredErrMsg=By.id("insurance_sum_assured-error");
	 public By insMaturityAmountTxt =By.xpath("//input[@name='insurance_maturity_amount']");
	 public By insSurrenderValueTxt =By.xpath("//input[@name='insurance_surrender_value']");
	 public By insPremiumPaymentEndDateErrMsg=By.id("insurance_payment_enddate-error");
	 public By insPolicyEndDateErrMsg =By.xpath("//input[@name='insurance_policy_enddate']/preceding::span[1]");
	 public By ulipErrMsg= By.id("ulip_data-error");
	 public By typeInsuranceErrMsg=By.xpath("//span[text()='This field is required.']");
	 public By recurringTxt =By.xpath("//span[text()='Recurring']");
	 public By insuranceEndDateErrMsg=By.xpath("//span[text()='Please select end date']");
	 public By insRecurringAmterrMsg=By.id("insurance_recurring_amount-error");
	 public By insurancePurchaseDate = By.xpath("//input[@name='insurance_purchase_date']");
	 public By insurancePremiumPayEndDate = By.xpath("//input[@name='insurance_payment_enddate']");
	 public By insurancePolicyEndDate = By.xpath("//input[@name='insurance_policy_enddate']");
	 public By insLinkToGoalDropDown =By.xpath("//label[text()='Link to Goal']/preceding::span[4]");
	 public By insRecurrStartDateDropdown=By.xpath("//input[@name='insurance_start_date']");
	 public By insRecurrEndDateDropdown=By.xpath("//input[@name='insurance_end_date']");
	 public By insRecurrAmount = By.xpath("//input[@name='insurance_recurring_amount']");
	 public By insTypeDropDown =By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div/form/div[3]/div[2]/div[2]/div/span[1]");
	 public By insTypeDropDownText= By.xpath("//label[text()='Type of Insurance']");
	 public By recurringReturn01 = By.xpath("//label[text()='Is the Return One time or recurring?']");
	 public By insuranceSave= By.xpath("//button[@value='SAVE']");
	 public By insurancePopUp = By.xpath("//section[@id='insurance_complete_popup']//div[1]/div[2]/ul//button");
	 //Locators for My Document
	 public  By documentDropDown = By.xpath("//span[@id='document_type-button']");
	 public By documentNameTxt = By.xpath("//input[@name='document_name']");
	 public By documentTypeErrMsg = By.id("document_type-error");
	 public By documentNameErrMsg = By.id("document_name-error");
	 public By documentUploadErrMsg = By.xpath("//span[@class='dz-error-message1 error-msg']");
	 public By documentSubmitButton = By.xpath("//button[@ng-click='savedocument()']");
	 public By fileUploadLink = By.xpath("//div[@name='dropzonefield']");
	 public By uploadTab = By.xpath("//span[contains(text(),'Upload')]");
	 public By uploadDragDropFileAsset = By.xpath("//span[contains(text(),'Drop files here to upload')]");
	 public By uploadPassword = By.xpath("//input[@name='ecash_passkey']");
	 public By saveAndAddUpload = By.xpath("//button[@ng-click='saveEcashdocument()']");
	 //Others locators
	 public By otherHolderName = By.xpath("//select[@name='asset_member_id']//following::span[1]");
	
	 //generate Report locators
	 public By generateReportButton = By.id("generatereportbutton");
	 public By genRepYesBtn = By.xpath("//button[@ng-click='updatelifecyclestatus()']");
	 public By genRepNoBtn = By.xpath("//button[@ng-click='updatelifecyclestatus()']/following::a[1]");
	 public By downloadRepBtn = By.xpath("//a[text()='Download']");
	 public DataGathering(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		

	} 
	
	public boolean genericClick(WebDriver driver, By elementToBeClicked)
	{ functions fun = new functions(driver);

	  //  try{
		try{
		fun.waitTillElementVisible(elementToBeClicked);
		//fun.scrollToElement(driver.findElement(elementToBeClicked));
		driver.findElement(elementToBeClicked).click();

	     return true;
	     }
	/*	catch(ElementNotVisibleException e) {
			fun.waitTillElementVisible(elementToBeClicked);
		     driver.findElement(elementToBeClicked).click();
		     return true;
		}
		catch(ElementNotInteractableException e) {
			fun.waitTillElementClickable(elementToBeClicked);

		     driver.findElement(elementToBeClicked).click();
			return true;
		}*/
		catch(Exception e) {
			WebElement ele = driver.findElement(elementToBeClicked);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
			return true;
		}
	//}
/*	catch(Exception e){

	     
	     assertEquals(false, true);
	     return false;
	}*/

	}
	
	public boolean genericSendKeys(WebDriver driver, By elementToBeClicked,String text)
	{

	    try{
             driver.findElement(elementToBeClicked).clear();
	     driver.findElement(elementToBeClicked).sendKeys(text);

	     return true;
	}
	catch(Exception e){

	     return false;
	}

	}


	
}

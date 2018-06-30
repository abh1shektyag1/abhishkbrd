package splitMyFields;

import crud.CustomerBRDsample0088;

import pojoClasses.Customerbrdsample0088Pojo;
import errorLog.ErrorLogFile;
import validation.Validation;

public class SplitMyFields {
	
	ErrorLogFile errorLog = new ErrorLogFile();
	CustomerBRDsample0088 customer = new CustomerBRDsample0088();
	
	public void splitFields(String line, String choice  , Validation validation) {
		Customerbrdsample0088Pojo pojoObject = new Customerbrdsample0088Pojo();
		String fields[] = line.split("~");
		int rejectionCount = 0 ;
		boolean rejected = false ;

		pojoObject.setCustomerId(validation.getCount());
		
		if(validation.customerCodeValidation(fields[0])){
				pojoObject.setCustomerCode(fields[0]);
		}else{
				errorLog.addErrorMessage("This field is primary hence duplicate can't be written into database :)" +
					"\nError in customerCode "+fields[0]);
				rejected =  true ;
	    }
		if(validation.customerNameValidation(fields[1])){
				pojoObject.setCustomerName(fields[1].toString());
		}else{
				errorLog.addErrorMessage("Error in customer Name "+fields[1]+" The customer code is "+fields[0]);
				rejectionCount++;
		}
		if((fields[2].length()>0)){
			pojoObject.setCustomerAddress1(fields[2]);
		}else {
			errorLog.addErrorMessage("Error in active flag "+fields[2]+" The customer code is "+fields[0]);
			rejectionCount++;
		}
		if((fields[3].length()>0)){
			pojoObject.setCustomerAddress2(fields[3]);
		}else {
			errorLog.addErrorMessage("Error in active flag "+fields[3]+" The customer code is "+fields[0]);
			rejectionCount++;
		}
		if(validation.pinCodeValidation(Integer.valueOf(fields[4]))){
					pojoObject.setCustomerPinCode(Integer.valueOf(fields[4]));
		}else{
			errorLog.addErrorMessage("Error in pincode "+fields[4]+" The customer code is "+fields[0]);
			rejectionCount++;
		}
		if(validation.emailAddressValidation(fields[5])){
			pojoObject.setCustomerEmailAddress(fields[5]);
		}else{
			errorLog.addErrorMessage("Error in email Id "+fields[5]+" The customer code is "+fields[0]);
			rejectionCount++;
		}
		pojoObject.setCustomerContactNumber(fields[6]);
		if((fields[7].length()>0)){
			pojoObject.setPrimaryContactPerson(fields[7]);
		}else {
			errorLog.addErrorMessage("Error in active flag "+fields[7]+" The customer code is "+fields[0]);
			rejectionCount++;
		}
		if(validation.recordStatusValidation(fields[8])){
			pojoObject.setRecords(fields[8]);
		}else{
			errorLog.addErrorMessage("Error in record status "+fields[8]+" The customer code is "+fields[0]);
			rejectionCount++;
		}
		if(validation.activityFlagValidation(fields[9])){
			pojoObject.setActivenessFlag(fields[9].toString());
		}else {
			errorLog.addErrorMessage("Error in active flag "+fields[9]+" The customer code is "+fields[0]);
			rejectionCount++;
		}
		if((fields[10].length()>0)){
			pojoObject.setCreateDate(fields[10].toString());
		}else {
			errorLog.addErrorMessage("Error in active flag "+fields[10]+" The customer code is "+fields[0]);
			rejectionCount++;
		}
		if((fields[11].length()>0)){
			pojoObject.setCreateBy(fields[11].toString());
		}else {
			errorLog.addErrorMessage("Error in active flag "+fields[11]+" The customer code is "+fields[0]);
			rejectionCount++;
		}
		pojoObject.setModifiedDate(fields[12].toString());
		pojoObject.setModifiedBy(fields[13].toString());
		pojoObject.setAuthorizedDate(fields[14].toString());
		pojoObject.setAuthorizedBy(fields[15].toString());
		if(choice.equalsIgnoreCase("r")&&(!rejected)){
			validation.setCount(validation.getCount()+1);
			customer.writeIntoDatabase(pojoObject);
		}else if(choice.equalsIgnoreCase("f")&&(!rejected)){
			if(rejectionCount==0){
				validation.setCount(validation.getCount()+1);
				customer.writeIntoDatabase(pojoObject);
			}
		}
	}
}

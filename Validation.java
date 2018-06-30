package validation;

import java.util.HashSet;
import java.util.Set;

import crud.CustomerBRDsample0088;

public class Validation {
    CustomerBRDsample0088 object = new CustomerBRDsample0088();
	Set<String> customercodeSet = new HashSet<String>();

	public void assignCustomerCodeSet(){
		this.customercodeSet = object.getCustomerCode();
	}
	public boolean customerCodeValidation(String customerCode){
		if(customercodeSet.contains(customerCode))			return false ;
		customercodeSet.add(customerCode);
		return true ;
	}
	public boolean customerNameValidation(String name){
		char nameInChar[] = name.toCharArray();
		for(int loop = 0 ; loop < nameInChar.length ; loop++){
			if((nameInChar[loop]>=48&&nameInChar[loop]<=57)||(nameInChar[loop]>=65&&
					nameInChar[loop]<=90)||(nameInChar[loop]>=97&&nameInChar[loop]<=122)||nameInChar[loop]==32) {
			}else return false ;
		}
		return true ;
	}
	public boolean pinCodeValidation(Integer pinCode){
		if((pinCode/100000)>=1&&(pinCode/100000)<10) return true ;
		return false ;

	}
	public boolean emailAddressValidation(String emailId){
		int count =  0 ,dot = 0 ;
		char[] string = emailId.toCharArray();
		for(int i = 0 ; i<string.length;i++){
			if(string[i]=='@'){
				count ++;
				for(int j = i ; j<string.length;j++){
					if(string[j]=='.')dot++;
				}
			}
		}
		if((count==0||count>1)||emailId.startsWith("@")||emailId.endsWith("@")||
				emailId.contains("@.")||emailId.endsWith(".")||(dot==0)||(dot>1)) return false ;
		return true  ;

	}
	public boolean recordStatusValidation(String record){
		if((record.length()==1)&&(record.equalsIgnoreCase("n")||record.equalsIgnoreCase("m")||
				record.equalsIgnoreCase("d")||record.equalsIgnoreCase("a")||record.equalsIgnoreCase("r"))) return true ;
		return false ;
	}
	public boolean activityFlagValidation(String activity){
		if((activity.length()==1)&&(activity.equalsIgnoreCase("a")||activity.equalsIgnoreCase("i"))) return true ;
		return false ;
	}
	
	int count  ;
	public int getCount() {
			return count;
	}
	public void setCount(int count) {
			this.count = count;
	}
}

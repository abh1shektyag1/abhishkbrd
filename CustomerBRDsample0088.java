package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import pojoClasses.Customerbrdsample0088Pojo;

import connection.ConnectionInterface;
import connection.FactoryConnection;

public class CustomerBRDsample0088 implements CustomerBRDsample0088Interface {

	ConnectionInterface connectionInterface = null ;
	Connection connection = null ;
	FactoryConnection factoryConnection  = new FactoryConnection();
	
	@SuppressWarnings("unused")
	@Override
	public void writeIntoDatabase(Customerbrdsample0088Pojo object) {
		
		try{
			connectionInterface = factoryConnection.GetMyConnection("oracle");
			connection = connectionInterface.myConnection();
			PreparedStatement statement = null ;
			int count = 0 ;
			statement = connection.prepareStatement("insert into customerBRDsample0088(customerId ,customerCode ," +
					" customerName   ,   customerAddress1  ,   customerAddress2 ,  customerPinCode " +
					",   customerEmailAddress ,   customerContactNumber  ,   primaryContactPerson   ," +
					"   recordStatus ,   activenessFlag   ,   createDate ,   createBy   ,   modifiedDate  ," +
					"   modifiedBy ,    authorizedDate  ,   authorizedBy  )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			statement.setInt(1, object.getCustomerId());
			statement.setString(2, object.getCustomerCode());
			statement.setString(3, object.getCustomerName());
			statement.setString(4, object.getCustomerAddress1());
			statement.setString(5, object.getCustomerAddress2());
			statement.setInt(6, object.getCustomerPinCode());
			statement.setString(7, object.getCustomerEmailAddress());
			statement.setString(8, object.getCustomerContactNumber());
			statement.setString(9, object.getPrimaryContactPerson());
			statement.setString(10, object.getRecords());
			statement.setString(11, object.getActivenessFlag());
			statement.setString(12, object.getCreateDate());
			statement.setString(13, object.getCreateBy());
			statement.setString(14, object.getModifiedDate());
			statement.setString(15, object.getModifiedBy());
			statement.setString(16, object.getAuthorizedDate());
			statement.setString(17, object.getAuthorizedBy());
			count = statement.executeUpdate();
	        //System.out.println("---------------"+count);

		}catch(Exception e){
			
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
		}
		
		
	}

	@Override
	public int getColomnNumber() {
		try{
			int count = 1 ;
			connectionInterface = factoryConnection.GetMyConnection("oracle");
	        connection = connectionInterface.myConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("select * from customerBRDsample0088");
			while(resultSet.next()){
				count++;
				}
			return count;
		}catch(Exception e){
			return 0;
		}		
	}

	@Override
	public Set<String> getCustomerCode() {
		// TODO Auto-generated method stub
		try{
			Set<String> customerCode = new HashSet<String>();
			connectionInterface = factoryConnection.GetMyConnection("oracle");
	        connection = connectionInterface.myConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("select customerCode from customerBRDsample0088");
			while(resultSet.next()){
				customerCode.add(resultSet.getString(1));
				}
			//int count = 0 ;
			/*for(String s:customerCode){
				count++;
				System.out.println(count+"-"+s);
			}*/
			return customerCode;
		}catch(Exception e){
			return null;
		}
		
	}

	@Override
	public void deleteDatabase() {
		try{
			connectionInterface = factoryConnection.GetMyConnection("oracle");
			connection = connectionInterface.myConnection();
			PreparedStatement statement = null ;
			int count = 0 ;
			statement = connection.prepareStatement("delete from customerbrdsample0088");	
            count = statement.executeUpdate();
            System.out.println(count);
			
		}catch(Exception e){
			
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
		}
		
		
	}

}

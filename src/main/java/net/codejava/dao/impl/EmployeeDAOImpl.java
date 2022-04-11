package net.codejava.dao.impl;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.swing.tree.TreePath;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;


import net.codejava.model.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	ResourceLoader resourceLoader;

	/*@Autowired
	public void setDataSource(DataSource dataSource) {
	    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}*/
	// connect to database
	public EmployeeDAOImpl(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	// Retrieve resources from class path
	public BufferedReader loadEmployeesJsonFile() throws IOException {
	    Resource resource = resourceLoader.getResource( "classpath:data/EmployeeData.json");
	    InputStream input = resource.getInputStream();
	    BufferedReader reader = new BufferedReader( new InputStreamReader(input));
	    return reader;
	    
	}
	private static final class TableRowMapper implements RowMapper<Employee> {

		
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Employee employee = new Employee();
	        employee.setAbout(rs.getString("about"));
	        employee.setCountry(rs.getString("country"));
	        employee.setCoverPicture(rs.getString("cover_picture"));
	        employee.setCreatedAt(rs.getString("created_at"));
	        employee.setCreditBalance(rs.getDouble("credit_balance"));
	        employee.setDob(rs.getString("dob"));
	        employee.setEmail(rs.getString("email"));
	        employee.setEnablefollowme(rs.getBoolean("enable_follow_me"));
	        employee.setEnabletagging(rs.getBoolean("enable_tagging"));
	        employee.setGender(rs.getInt("gender"));
	        employee.setId(rs.getInt("id"));
	        employee.setLat(rs.getInt("lat"));
	        employee.setLivelat(rs.getDouble("live_lat"));
	        employee.setLivelng(rs.getDouble("live_lng"));
	        employee.setLiveLocation(rs.getString("live_location"));
	        employee.setLng(rs.getInt("lng"));
	        employee.setLocation(rs.getString("location"));
	        employee.setMyCash(rs.getInt("my_Cash"));
	        employee.setName(rs.getString("name"));
	        employee.setPassword(rs.getString("password"));
	        employee.setProfilePicture(rs.getString("profile_picture"));
	        employee.setSendmenotifications(rs.getBoolean("send_me_notifications"));
	        employee.setSendTextmessages(rs.getBoolean("send_text_messages"));
	        employee.setToken(rs.getString("token"));
	        employee.setUpdatedAt(rs.getString("updated_at"));
	        employee.setUserStatus(rs.getInt("user_status"));
	        employee.setUserType(rs.getInt("user_type"));
	        return employee;
	    }

	}
	
	@Override 
	public List<Employee> getEmployeeInfo() {
		List<Employee> resultData ;
		String sql = "SELECT * FROM employeedata";
		resultData = namedParameterJdbcTemplate.query(sql,new TableRowMapper());
		return resultData;
	}

	@Override
	public Employee getEmployeeInfoByID(int employeeId) {
		//List<Employee> resultData;
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		String sql = "SELECT * FROM employeedata WHERE id=:employeeId";
		parameters.addValue("employeeId", employeeId);
		return namedParameterJdbcTemplate.queryForObject(sql, parameters, Employee.class);

		
		
	}

	@Override
	public void fillDatabase() {
		  
	      JSONParser jsonParser = new JSONParser();
	       
	      try {
	         //Parsing the contents of the JSON file
	    	  JSONArray jsonObjectArray = (JSONArray) jsonParser.parse(loadEmployeesJsonFile());
	    	  System.out.print(jsonObjectArray);
	    	  String sql ="insert into employeedata ( id,name,email,password ,about ,token , country , location , lng , lat  ,dob, gender , user_type ,  user_status , profile_picture , cover_picture ,enable_follow_me , \r\n" + 
	    	  		"	send_me_notifications , send_text_messages , enable_tagging , created_at ,  updated_at , live_lng, live_lat, live_location, credit_balance, my_cash) values ( :id,:name,:email,:password ,:about ,\r\n" + 
	    	  		"	:token , :country , :location , :lng , :lat ,:dob, :gender , :userType ,  :userStatus , :profilePicture , :coverPicture ,:enablefollowme , \r\n" + 
	    	  		"	:sendmenotifications , :sendTextmessages , :enabletagging , :createdAt ,  :updatedAt , :livelng, :livelat, :liveLocation, :creditBalance, :myCash)";
	    	  
	    	     MapSqlParameterSource parameters = new MapSqlParameterSource();
	    	  //Retrieving the array
	         for(Object entry : jsonObjectArray) {
	            JSONObject record = (JSONObject) entry;
	            
	            
	            	       
	            parameters.addValue( "id",record.get("id"));
	            parameters.addValue( "name" ,(String) record.get("name"));
	            parameters.addValue( "email" ,(String) record.get("email"));
	            parameters.addValue( "password" , (String) record.get("password"));
	            parameters.addValue( "about", (String) record.get("about"));
	            parameters.addValue( "token", (String) record.get("token"));
	            parameters.addValue( "country",(String) record.get("country"));
	            parameters.addValue( "location", (String) record.get("location"));
	            parameters.addValue( "lng", record.get("lng")); 
	            parameters.addValue( "name" ,(String) record.get("name"));
	            parameters.addValue( "email" ,(String) record.get("email"));
	            parameters.addValue( "password" , (String) record.get("password"));
	            parameters.addValue( "about", (String) record.get("about"));
	            parameters.addValue( "token", (String) record.get("token"));
	            parameters.addValue( "country",(String) record.get("country"));
	            parameters.addValue( "location", (String) record.get("location"));
	            parameters.addValue( "lng", record.get("lng"));
	            parameters.addValue( "lat",record.get("lat"));
	            //parameters.addValue( "dob ",(String) record.get("dob"));
	            parameters.addValue( "gender", record.get("gender"));
	            parameters.addValue( "userType",record.get("userType"));
	            parameters.addValue( "userStatus",record.get("userStatus"));
	            parameters.addValue( "coverPicture",(String) record.get("coverPicture"));
	            parameters.addValue( "enablefollowme",(boolean) record.get("enablefollowme"));
	            parameters.addValue( "sendmenotifications", (boolean) record.get("sendmenotifications"));
	            parameters.addValue( "sendTextmessages",(boolean) record.get("sendTextmessages"));
	            parameters.addValue( "enabletagging",(boolean) record.get("enabletagging"));
	            parameters.addValue( "createdAt",(String) record.get("createdAt"));
	            parameters.addValue( "updatedAt", (String) record.get("updatedAt"));
	            parameters.addValue( "livelng ",record.get("livelng"));
	            parameters.addValue( "livelat",record.get("livelat"));
	            parameters.addValue( "liveLocation ",(String) record.get("liveLocation"));
	           // paramMap.put( "creditBalance",Integer.parseInt((String) record.get("creditBalance")));
	            parameters.addValue( "creditBalance",record.get("creditBalance"));
	            parameters.addValue( "myCash", record.get("creditBalance"));
	            parameters.addValue( "lat",record.get("lat"));
	            parameters.addValue( "dob",(String) record.get("dob"));
	            parameters.addValue( "gender", record.get("gender"));
	            parameters.addValue( "userType",record.get("userType"));
	            parameters.addValue( "userStatus",record.get("userStatus"));
	            parameters.addValue( "coverPicture",(String) record.get("coverPicture"));
	            parameters.addValue( "enablefollowme",(boolean) record.get("enablefollowme"));
	            parameters.addValue( "sendmenotifications", (boolean) record.get("sendmenotifications"));
	            parameters.addValue( "sendTextmessages",(boolean) record.get("sendTextmessages"));
	            parameters.addValue( "enabletagging",(boolean) record.get("enabletagging"));
	            parameters.addValue( "createdAt",(String) record.get("createdAt"));
	            parameters.addValue( "updatedAt", (String) record.get("updatedAt"));
	            parameters.addValue( "livelng",record.get("livelng"));
	            parameters.addValue( "livelat",record.get("livelat"));
	            parameters.addValue( "profilePicture",(String) record.get("profilePicture"));
	            parameters.addValue( "liveLocation",(String) record.get("liveLocation"));
	           // paramMap.put( "creditBalance",Integer.parseInt((String) record.get("creditBalance")));
	            parameters.addValue( "creditBalance",record.get("creditBalance"));
	            parameters.addValue( "myCash", record.get("creditBalance"));
	            namedParameterJdbcTemplate.update(sql, parameters);
	         } 
	         System.out.print("done");
	         
	         
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ParseException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		
	}

}

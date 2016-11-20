package test03.eureka3.com;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.sql.*;

import org.apache.commons.logging.*;

public class MySQLAccessor {
	
	public static Log log = LogFactory.getLog(MySQLAccessor.class);
	
	private String UserId = "";
	public void setUserId(String value) {
		this.UserId = value;
	}
	
	private String Password = "";
	public void setPassword(String value) {
		this.Password = value;
	}
	
	private String DataSource = "";
	public void setDataSource(String value) {
		this.DataSource = value;
	}
	
	private String connectionString = "";
	public void createConnectionString() {
		this.connectionString = "jdbc:mysql://localhost:3306/" + this.DataSource;
	}
	
	private Connection myConnection = null;
	public void createConnection() throws SQLException {
		try {
			this.myConnection = DriverManager.getConnection(this.connectionString, this.UserId, this.Password);
		} catch(SQLException e) {
			log.error("Error Occured :", e);
		}
	}
	
	public MySQLAccessor() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
						
		} catch(ClassNotFoundException e) {
			
			log.error("Error Occured : ", e);
			
		}
		
	}
	
	private void destruction() throws Throwable {
		
		if(this.myConnection != null) {
			
			this.myConnection.close();
			
		}
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		try {
			
			super.finalize();
			
		} finally {
			
			destruction();
			
		}
		
	}
	
	private String QueryString = "";
	public void setQueryString(String path, String encoding) {
		
		BufferedReader in = null;
		
		try {
			
			in = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));
			
			String oneLine = "";
			
			while((oneLine = in.readLine()) != null) {
				this.QueryString += oneLine;
			}
			
		} catch(Exception e) {
			
			log.error("Error Occured : ", e);
			
		} finally {
			
			try {
				
				in.close();
				
			} catch(IOException e) {
				
				log.error("Error Occured : ", e);
				
			}
			
		}
		
	}
	
	public ResultSet executeSelectQuery() {
		
		ResultSet retSet = null;
		
		try {
			
			PreparedStatement ps = null;
			
			ps = this.myConnection.prepareStatement(this.QueryString);
			
			retSet = ps.executeQuery();
			
		} catch(SQLException e) {
			
			log.error("Error Occured : ", e);
			
		}
		return retSet;
		
	}
	
	public ResultSet executeSelectTest03(String strCode) {
		
		ResultSet retSet = null;
		
		try {
			
			PreparedStatement ps = null;
			
			StringBuilder sqlQuery = new StringBuilder("");
			sqlQuery.append("SELECT           ");
			sqlQuery.append("       PREF_CODE ");
			sqlQuery.append("     , PREF_NAME ");
			sqlQuery.append("FROM             ");
			sqlQuery.append("       test      ");
			sqlQuery.append("WHERE            ");
			sqlQuery.append("       PREF_CODE ");
			sqlQuery.append("     = " + strCode);
			
			ps = this.myConnection.prepareStatement(sqlQuery.toString());
			
			retSet = ps.executeQuery();
			
		} catch(SQLException e) {
			
			log.error("Error Occured : ", e);
			
		}
		return retSet;
		
	}
	
}

package com.ServerImpl.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrackRequest {
	public boolean saveIncomingReq(String reqID) {
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	         String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	         pst = connectionobject.prepareStatement("insert into listen_queue values (?,?)");
		     
		     pst.setString(1, reqID);
		     pst.setString(2, timeStamp);
		     
		    
		     //JDBC STEP 4
		     //EXECUTE QUERY
		     int i = pst.executeUpdate();		     
		     if(i > 0 )
		    	 f = true;
           
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
		
	}
}

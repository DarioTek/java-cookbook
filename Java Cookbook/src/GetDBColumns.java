import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GetDBColumns {
  public static void main(String[] args) throws Exception {
    //Connection conn = getMySqlConnection();
	Connection conn = getOracleConnection();	
    System.out.println("Got Connection.");
    
    //Statement st = conn.createStatement();
    
    /*
    st.executeUpdate("drop table survey;");
    
    String dropTable = "DROP TABLE \"NX_OWNER\".\"TEST_GIP_POPULATION2\"";

    st.executeUpdate(dropTable);
    
    
    System.out.println("SQL Statement created.");
    
    String createTable = "CREATE TABLE \"NX_OWNER\".\"TEST_GIP_POPULATION2\" " +
    			 "( " +
    			 "\"FG_SEEKER_ID\" VARCHAR2(20 BYTE) " +
    			 ")";
    
    st.executeUpdate(createTable);
    //st.executeUpdate("Insert into TEST_GIP_POPULATION (FG_SEEKER_ID) values ('HRG9JS00001049');");
    //st.executeUpdate("commit;");
    System.out.println("SQL Statement executed.");
     */
    
    ResultSet rsColumnsStaging = null;
    ResultSet rsColumnsTemp = null;
    DatabaseMetaData meta = conn.getMetaData();
    
    rsColumnsStaging = meta.getColumns(null, null, "FG_INVOICE_DOWNLOAD_STG", null);
    //rsColumnsStaging = meta.getColumns(null, null, "FG_INVOICE_TEMP", null);
    
    System.out.println("WORKER_DOWNLOAD_STG Columns metadata executed.");
    System.out.println("**************************");
    
    HashMap hmStaging = new HashMap();
    
    while (rsColumnsStaging.next()) {
      String columnName = rsColumnsStaging.getString("COLUMN_NAME");
      System.out.println("column name=" + columnName);      
      
      String columnType = rsColumnsStaging.getString("TYPE_NAME");
      System.out.println("type:" + columnType);
      
      int size = rsColumnsStaging.getInt("COLUMN_SIZE");
      System.out.println("size:" + size);

      int decimalDigits = rsColumnsStaging.getInt("DECIMAL_DIGITS");
      System.out.println("decimalDigits:" + decimalDigits);

             
      hmStaging.put(columnName, new Integer(size));
      
      int nullable = rsColumnsStaging.getInt("NULLABLE");
      if (nullable == DatabaseMetaData.columnNullable) {
        System.out.println("nullable true");
      } else {
        System.out.println("nullable false");
      }
      int position = rsColumnsStaging.getInt("ORDINAL_POSITION");
      System.out.println("position:" + position);
      System.out.println("**************************");
      
    }

    

    
    rsColumnsTemp = meta.getColumns(null, null, "FG_INVOICE_TEMP", null);
    //rsColumnsTemp = meta.getColumns(null, null, "WORKER_SYNC_TEMP", null);
    
    //rsColumns = meta.getColumns(null, null, "P2P_PLAY_DOWNLOAD_STG", null);
    //rsColumns = meta.getColumns(null, null, "P2P_EXC_DOWNLOAD_STG", null);
    //System.out.println("FG_INVOICE_TEMP Columns metadata executed.");
    System.out.println("FG_INVOICE_TEMP Columns metadata executed.");
    System.out.println("**************************");
    
    HashMap hmTemp = new HashMap();
    
    while (rsColumnsTemp.next()) {
      String columnName = rsColumnsTemp.getString("COLUMN_NAME");
      //System.out.println("column name=" + columnName);      
      
      String columnType = rsColumnsTemp.getString("TYPE_NAME");
      //System.out.println("type:" + columnType);
      int size = rsColumnsTemp.getInt("COLUMN_SIZE");
      //System.out.println("size:" + size);
      
      hmTemp.put(columnName, new Integer(size));
      
      int nullable = rsColumnsTemp.getInt("NULLABLE");
      if (nullable == DatabaseMetaData.columnNullable) {
        System.out.println("nullable true");
      } else {
        System.out.println("nullable false");
      }
      int position = rsColumnsTemp.getInt("ORDINAL_POSITION");
      System.out.println("position:" + position);
      System.out.println("**************************");
      
    }

    //st.close();
    conn.close();
    
    
	/*
	 * Loop through the map
	 */
    
	Iterator stagingIterator = hmStaging.entrySet().iterator();
	Iterator tempIterator = hmTemp.entrySet().iterator();
	
	int count = 0;
	while (stagingIterator.hasNext()){
		Map.Entry keyValuePair = (Map.Entry) stagingIterator.next();
		String key = (String) keyValuePair.getKey();
		System.out.println(count++ + " key = " + key);		
		int stagingSize = ((Integer) keyValuePair.getValue()).intValue();
		
		Integer tempSize = (Integer)hmTemp.get(key);
		if (tempSize != null){ 					
			if (stagingSize != tempSize.intValue()){
				System.out.println("stagingSize = " + stagingSize + "; tempSize = " + tempSize);
			}
		}else{
			System.out.println("Column = " + key + " does not exist in the temp table.");
		}		
		System.out.println("**************************");
	}
	

  }

  private static Connection getHSQLConnection() throws Exception {
    Class.forName("org.hsqldb.jdbcDriver");
    System.out.println("Driver Loaded.");
    String url = "jdbc:hsqldb:data/tutorial";
    return DriverManager.getConnection(url, "sa", "");
  }

  public static Connection getMySqlConnection() throws Exception {
    String driver = "org.gjt.mm.mysql.Driver";
    String url = "jdbc:mysql://localhost/demo2s";
    String username = "oost";
    String password = "oost";

    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

  public static Connection getOracleConnection() throws Exception {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@oraasgtd14-scan.nam.nsroot.net:8888:CENEX1D";
    String username = "nx_owner";
    String password = "Welcome1";

    Class.forName(driver); // load Oracle driver
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }
}
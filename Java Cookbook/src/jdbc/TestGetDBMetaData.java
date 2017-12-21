package jdbc;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TestGetDBMetaData {

	   @PersistenceContext
	    private EntityManager em;

	    public void getMeta() {
	        org.hibernate.engine.spi.SessionImplementor sessionImp = (org.hibernate.engine.spi.SessionImplementor) em.getDelegate();
	        DatabaseMetaData metadata = null;
	        try {
	            metadata = sessionImp.connection().getMetaData();
	            ResultSet rsColumnsStaging = metadata.getColumns(null, null, "WORKER_DOWNLOAD_STG", null);
	            System.out.println("WORKER_DOWNLOAD_STG Columns metadata executed.");
	            System.out.println("**************************");
	            
	            HashMap hmStaging = new HashMap();
	            
	            while (rsColumnsStaging.next()) {
		              String columnName = rsColumnsStaging.getString("COLUMN_NAME");
		              //System.out.println("column name=" + columnName);      
		              
		              String columnType = rsColumnsStaging.getString("TYPE_NAME");
		              //System.out.println("type:" + columnType);
		              int size = rsColumnsStaging.getInt("COLUMN_SIZE");
		              //System.out.println("size:" + size);
		              
		              hmStaging.put(columnName, new Integer(size));
		              /*
		              int nullable = rsColumnsStaging.getInt("NULLABLE");
		              if (nullable == DatabaseMetaData.columnNullable) {
		                System.out.println("nullable true");
		              } else {
		                System.out.println("nullable false");
		              }
		              int position = rsColumnsStaging.getInt("ORDINAL_POSITION");
		              System.out.println("position:" + position);
		              System.out.println("**************************");
		              */
	            }

	            rsColumnsStaging.close();
	            
	            System.out.println();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGetDBMetaData test = new TestGetDBMetaData();
		test.getMeta();
	}

}

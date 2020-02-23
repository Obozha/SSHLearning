package cc.sms.utils;


import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	private static DataSource source=new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return source;
	}
}

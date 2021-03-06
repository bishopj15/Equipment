package mcps.po.equipment.dao;

import javax.servlet.ServletContextEvent;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;




public class DatabaseAccess {
	
	private static DatabaseAccess instance = null;
	
	private static int maxActive = 20;
	private static int maxIdle = 2;
	private static int maxWait = 10000;
	private static long maxLifetime = 2000;

	private static String dbURI = "";
	private static String pwd = "";
	private static String jdbcDriver = "";
	private static String uid = "";
	private static String dbPoolName = "equipmentpool";
	private static String poolingDriver = "jdbc:apache:commons:dbcp:";
	private boolean poolSetup = false;
	
	
	private DatabaseAccess() {}

	/**
	 * We do not allow cloning our singleton
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/**
	 * this method is called by external callers and returns the instance,
	 * the instance has already been initialized by the method below
	 * @return
	 */
	public static synchronized DatabaseAccess getInstance() {
		return instance;
	}
	
	protected static synchronized DatabaseAccess getInstance(ServletContextEvent servletContext){
		if (instance == null) {
			instance = new DatabaseAccess();
		}
		
		String propertyFilePath = servletContext.getServletContext().getInitParameter("jdbcproperties");
		if(propertyFilePath != null){
			Properties properties = new Properties();
			try{
				properties.load(servletContext.getServletContext().getResourceAsStream(propertyFilePath));
				jdbcDriver = properties.getProperty("jdbc.driverClassName");
				dbURI = properties.getProperty("jdbc.url");
				uid = properties.getProperty("jdbc.username");
				pwd = properties.getProperty("jdbc.password");
			} catch(Exception e){
				System.out.println("unable to read/locate property file at "+ propertyFilePath);
			}
			if (!instance.initDatabaseAccess()) {
				instance = null;
				System.out.println("Error initializing DatabaseAccess and pool");
			}
		}
		return instance;
	}
	
	private boolean initDatabaseAccess(){
		try{
			Class.forName(jdbcDriver);

			//create ConnectionFactory pool will use to create Connections
			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(dbURI, uid, pwd);
			
			//create PoolableConnectionFactory to wrap the real connections
			PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
			poolableConnectionFactory.setDefaultAutoCommit(false);
			
			//pool config
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setMaxTotal(maxActive);
			poolConfig.setMaxWaitMillis(maxWait);
	        poolConfig.setMinIdle(maxIdle);
	        
	        
	        
	        
			 
			//create actual pool of connections
			ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory, poolConfig);
			poolableConnectionFactory.setMaxConnLifetimeMillis(maxLifetime);
			poolableConnectionFactory.setPool(connectionPool);
			
			//create pooling driver
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver(poolingDriver);
			
			//register pool
			driver.registerPool(dbPoolName, connectionPool);
			
			
			//validate pool
			printDriverStats();
			Connection c = getConnection();
			printDriverStats();
			System.out.println("Connection: " + c);
			c.close();
			printDriverStats();
			
			this.poolSetup = true;
			
			
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("Error setting up database pool");
		}

		return false;
	}
	
	protected static synchronized DatabaseAccess getInstance(Properties properties){
		if (instance == null) {
			instance = new DatabaseAccess();
		}
		
		
		return instance;
	}
	
	public void printDriverStats() throws Exception {
        PoolingDriver driver = (PoolingDriver) DriverManager.getDriver(poolingDriver);
        ObjectPool<? extends Connection> connectionPool = driver.getConnectionPool(dbPoolName);
	
        System.out.println("NumActive: " + connectionPool.getNumActive());
        System.out.println("NumIdle: " + connectionPool.getNumIdle());
    }
	
	/**
	 * provide a connection to the database pool
	 * @return
	 */
	public Connection getConnection() {
		// get a connection from our pool
		try {
			Connection c = DriverManager.getConnection(poolingDriver
					+ dbPoolName);
			return c;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void shutdownDriver() throws Exception {
		try{
			if(this.poolSetup){
				PoolingDriver driver = (PoolingDriver) DriverManager.getDriver(poolingDriver);
		        if(driver != null){
		        	driver.closePool(dbPoolName);
		        }
			}
		} catch(Exception e){
			
		}  
    }
	
	/**
	 * get the pkey of the latest record added to the database
	 * @return
	 * @throws SQLException
	 */
	public int getPkeyOfLastInsert(Connection conn) throws SQLException{
		int pkey = -1;

		try(PreparedStatement ps = conn.prepareStatement(Queries.GET_LAST_INSERT_ID);
				ResultSet rs = ps.executeQuery() ) {
			rs.next();
			pkey = rs.getInt(1);
		} catch (SQLException e) {
			throw e;
		}

		return pkey;
	}
}

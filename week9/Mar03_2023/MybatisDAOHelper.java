package com.PAM.mybatisDAOHelper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisDAOHelper {
	private static MybatisDAOHelper instance;
	private SqlSessionFactory ssf;
	
	private MybatisDAOHelper() {
		
	}
	
	public static MybatisDAOHelper getInstance() {
		if (instance==null) {
			instance = new MybatisDAOHelper();
		}
		return instance;
	}
	
	private void setFactory(String configFilePath) throws IOException {
		InputStream is = Resources.getResourceAsStream(configFilePath);
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		ssf = ssfb.build(is);
		
	}

	public SqlSessionFactory getSsf(String configFilePath) throws IOException {
		setFactory(configFilePath);		
		return ssf;
	}
	
	public SqlSessionFactory getSsf() throws IOException {
		if(ssf == null) {
			throw new IOException();
		}
		return ssf;
	}
	
}

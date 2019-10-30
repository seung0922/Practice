package org.seung.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public enum MybatisLoader {
	
	INSTANE;
	
	SqlSessionFactory factory;
	
	public SqlSessionFactory getFactory() {
		return this.factory;
	}
	
	MybatisLoader() {
		
		String resource = "mybatis-config.xml";
		
		try {
			
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}

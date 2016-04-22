package com.apl.sha.ers.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl extends com.apl.sha.ers.db.RowMapper implements RowMapper{
	private Class cls;
	
	public RowMapperImpl(Class cls) {
		this.cls= cls;
	}

/*	public CpsRowMapperImpl(Class c) {
		try {
			this.object = c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}*/
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		Object object=null;
		try {
			object = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return reflect(rs,index,object);
	}
}

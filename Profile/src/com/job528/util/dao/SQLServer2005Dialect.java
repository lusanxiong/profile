package com.job528.util.dao;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;

public class SQLServer2005Dialect extends SQLServerDialect {

	public SQLServer2005Dialect(){
		super(); 
		 registerHibernateType(Types.NVARCHAR,Hibernate.STRING.getName()); 
		 registerColumnType(Types.NVARCHAR,"nvarchar($l)");
		 registerHibernateType(Types.LONGVARCHAR, Hibernate.STRING.getName());
		 registerColumnType(Types.LONGVARCHAR,"text");
		 
	}
}

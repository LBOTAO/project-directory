package com.qfcwx.reflection;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ReflectionUtil {

	public static void setProToBeanFromResult(Object entity,ResultSet resultSet) throws SQLException {
		Field[] decfileds = entity.getClass().getDeclaredFields();
		for (int i = 0; i < decfileds.length; i++) {
			if(decfileds[i].getType().getSimpleName().equals("String")) {
				setProToBean(entity,decfileds[i].getName(),resultSet.getString(decfileds[i].getName()));
			}else if(decfileds[i].getType().getSimpleName().equals("Long")) {
				setProToBean(entity,decfileds[i].getName(),resultSet.getLong(decfileds[i].getName()));
			}else if(decfileds[i].getType().getSimpleName().equals("String")) {
				setProToBean(entity,decfileds[i].getName(),resultSet.getLong(decfileds[i].getName()));
			}
		}
	}

	private static void setProToBean(Object bean, String name, Object value) {
		Field field;
		try {
			field = bean.getClass().getDeclaredField(name);
			field.setAccessible(true);
			field.set(bean, value);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
//	public static void main(String[] args) {
//		user user = new user();
//		ReflectionUtil.setProToBean(user, "name","xzq");
//		System.out.println(user);
//	}
}

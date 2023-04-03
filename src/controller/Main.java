package controller;

import javax.persistence.EntityManager;

import utils.JpaUtil;

public class Main {
	static  EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	public static void main(String[] args) {
		
	}

}

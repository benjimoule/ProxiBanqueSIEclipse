package com.adaming.main;

import java.util.List;

import org.primefaces.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.dao.DaoClient;
import com.adaming.dao.IDaoClient;
import com.adaming.entities.Client;

public class Main {
//	public static void main(String[] args) {
//        ApplicationContext context = 
//            new ClassPathXmlApplicationContext("META-INF/config.xml");
//
//        Main p = context.getBean(Main.class);
//        p.start(args);
//    }

	public static void main(String[] args) {
		
		IDaoClient dao = new DaoClient();
	//	ApplicationContext context = 
		//            new ClassPathXmlApplicationContext("webapp/WEB-INF/applicationContext.xml");

		List<Client> liste = dao.getAllClients();
		if (liste == null){
			System.out.println("c'est nul!");
		} else {
			System.out.println(liste.size());
		}

	}

}

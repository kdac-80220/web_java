package com.app.tester;

import java.util.Scanner;

import com.app.dao.OwnerDao;
import com.app.pojos.Owner;

public class AddOwner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Owner owner=new Owner(sc.next(),sc.next(),sc.next());
		
		OwnerDao od=new OwnerDao();
		String msg=od.addOwner(owner);
		System.out.println(msg);
	}

}

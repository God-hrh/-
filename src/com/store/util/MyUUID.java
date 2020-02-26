package com.store.util;

import java.util.UUID;

public class MyUUID {
	public  static  String  getId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}

package com.ye.vio.util;

import java.util.UUID;

public class UUIDUtils {
	public static String UUID() {
		 return UUID.randomUUID().toString().replace("-", "");
	}


}

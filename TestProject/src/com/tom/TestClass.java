package com.tom;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class TestClass {

	public static String uniqueStringForPasswordReset (int randomChars)
	{
		SecureRandom random=null;
		char[] randomCharArray=new char[randomChars];
		char[] characterRange ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456879".toCharArray();

		try {
			random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
//			throw new Exception("Cannot Get SecureRandomAlgorithm:SHA1PRNG ",e);
		}

		//Self Seeding with random bytes of length 16
		random.nextBytes(random.generateSeed(randomChars));

		for(int i=0;i<randomChars;i++){
			randomCharArray[i]=characterRange[random.nextInt(characterRange.length)];
		
		}

		final String returnedString=new String(randomCharArray);
		return returnedString;

		//return randomString(randomChars) + uniqueString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
		System.out.println("Random String is: "+TestClass.uniqueStringForPasswordReset(13));
		}
	}

}

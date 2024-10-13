package com.holly.gradTechChallenge;

import com.holly.gradTechChallenge.runner.PrimeRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class GradTechChallengeApplication {
	private static final Logger log = LogManager.getLogger(GradTechChallengeApplication.class);
	static PrimeRunner primeRunner = new PrimeRunner();

	public static void main(String[] args) {
		start();
	}

	public static void start(){
		boolean goAgain = true;
		log.info("Prime Number Application Starting");

		String fileName = "src/main/resources/primeNumbers.txt";
		ArrayList<String> knownPrimes = primeRunner.startUp(fileName);

		while (goAgain){
			goAgain = primeRunner.primeCaller(fileName,knownPrimes);
		}
		System.exit(0);

	}
}
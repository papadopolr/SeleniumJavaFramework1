package demo;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\nHello Word!...   \n");
		
		logger.trace("This is trace message");
		logger.info("This is information message");
		logger.error("This is an error message");
		logger.warn("This is a warning message");
		logger.fatal("Thi is a fatal message");
		
		System.out.println("\nCompleted");
	}

}

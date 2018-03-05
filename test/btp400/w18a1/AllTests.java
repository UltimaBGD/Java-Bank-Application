package test.btp400.w18a1;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(BankTest.class);
		suite.addTestSuite(ChequingTest.class);
		suite.addTestSuite(GICTest.class);
		suite.addTestSuite(SavingsTest.class);
		//$JUnit-END$
		return suite;
	}

}

package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ssoTests.ShibFunctionalityTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   ShibFunctionalityTest.class
})

public class SSOTests {

}

package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.AdvancedSearchTest;
import tests.CrossMatchTest;
import tests.LoginTest;
import tests.M60SearchFilterTest;
import tests.M60VOUseCaseTest;
import tests.SimpleTest;
import tests.SpectralViewerUseCaseTest;
import tests.TimeseriesViewerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   AdvancedSearchTest.class,
   CrossMatchTest.class,
   LoginTest.class,
   M60SearchFilterTest.class,
   M60VOUseCaseTest.class,
   SimpleTest.class,
   SpectralViewerUseCaseTest.class,
   TimeseriesViewerTest.class
})
public class AllTests {

}

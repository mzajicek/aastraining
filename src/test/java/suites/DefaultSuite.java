package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.CalculationTest;
import tests.EmailValidationTest;
import tests.NewSavingRequestTest;
import tests.SavingCalculatorTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculationTest.class,
        SavingCalculatorTest.class,
        EmailValidationTest.class,
        NewSavingRequestTest.class
})
public class DefaultSuite {

}


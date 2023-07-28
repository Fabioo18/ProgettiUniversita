import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;
import org.example.Homework3;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class TestHomework3
{
    private final static int n = 3;

    @Property(tries = 728999)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void lose(@ForAll("Cards") int[] scheda) {
        int[] schedaVincente = Homework3.schedaVincente();
        Statistics.collect(Homework3.haveSameElements(schedaVincente,scheda));
        if(!(Homework3.haveSameElements(schedaVincente,scheda)))
        {
            assertFalse(Homework3.superenalotto(scheda, schedaVincente));
        }
    }

    @Property(tries = 728999)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void win(@ForAll("Cards") int[] scheda) {
        int[] schedaVincente = Homework3.schedaVincente();
        Statistics.collect(Homework3.haveSameElements(schedaVincente,scheda));
        if(Homework3.haveSameElements(schedaVincente,scheda))
        {
            assertTrue(Homework3.superenalotto(scheda, schedaVincente));
        }
    }

    @Provide
    private Arbitrary<int[]> Cards()
    {
        return Arbitraries.integers().between(1,90).array(int[].class).ofSize(n);
    }

    @Property(tries = 1000)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void invalid(@ForAll("invalidInputs") int[] scheda) {
        int[] schedaVincente = Homework3.schedaVincente();
        for(int i=0;i<n;i++)
        {
            Statistics.collect(scheda[i] < 1);
        }
        assertThrows(InvalidParameterException.class, () -> {
            Homework3.superenalotto(scheda,schedaVincente);
        });
    }

    @Provide
    private Arbitrary<int[]> invalidInputs() {
        Arbitrary<Integer> invalidNumbers = Arbitraries.integers()
                .filter(number -> number < 1 || number > 90);

        return invalidNumbers.array(int[].class).ofSize(n);

    }


}


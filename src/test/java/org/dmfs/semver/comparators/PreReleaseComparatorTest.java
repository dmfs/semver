package org.dmfs.semver.comparators;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class PreReleaseComparatorTest
{

    @Test
    void test()
    {
        assertThat(new PreReleaseComparator().compare("alpha", "alpha"), is(equalTo(0)));
        assertThat(new PreReleaseComparator().compare("alpha", "alpha.1"), is(lessThan(0)));
        assertThat(new PreReleaseComparator().compare("alpha.2", "alpha.1"), is(greaterThan(0)));
        assertThat(new PreReleaseComparator().compare("alpha", "beta"), is(lessThan(0)));
        assertThat(new PreReleaseComparator().compare("alpha.1", "alpha.1.b"), is(lessThan(0)));
    }

}
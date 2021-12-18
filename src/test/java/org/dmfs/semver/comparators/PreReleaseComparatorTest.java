package org.dmfs.semver.comparators;

import org.junit.jupiter.api.Test;

import static org.dmfs.jems2.hamcrest.matchers.comparable.ComparableOrderMatcher.imposesOrderOf;
import static org.hamcrest.MatcherAssert.assertThat;


class PreReleaseComparatorTest
{

    @Test
    void test()
    {
        assertThat(new PreReleaseComparator(),
            imposesOrderOf(
                "0",
                "5",
                "100",
                "alpha",
                "alpha.1",
                "alpha.1.5",
                "alpha.1.100",
                "alpha.1.a",
                "alpha.1.b",
                "alpha.5",
                "alpha.100",
                "beta",
                "beta.1",
                "beta.5",
                "beta.100"
            ));
    }

}
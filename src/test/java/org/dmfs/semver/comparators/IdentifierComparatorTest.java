package org.dmfs.semver.comparators;

import org.junit.jupiter.api.Test;

import static org.dmfs.jems2.hamcrest.matchers.comparable.ComparableOrderMatcher.imposesOrderOf;
import static org.hamcrest.MatcherAssert.assertThat;


class IdentifierComparatorTest
{

    @Test
    void test()
    {
        assertThat(new IdentifierComparator(),
            imposesOrderOf("1", "2", "4", "100", "alpha", "beta"));
    }
}
package org.dmfs.semver.comparators;

import org.dmfs.semver.PreRelease;
import org.dmfs.semver.Release;
import org.junit.jupiter.api.Test;

import static org.dmfs.jems2.hamcrest.matchers.comparable.ComparableOrderMatcher.imposesOrderOf;
import static org.hamcrest.MatcherAssert.assertThat;


class VersionComparatorTest
{

    @Test
    void testReleases()
    {
        assertThat(
            new VersionComparator(),
            imposesOrderOf(
                new PreRelease(new Release(1, 0, 0), "alpha"),
                new PreRelease(new Release(1, 0, 0), "alpha.1"),
                new Release(1, 0, 0),
                new PreRelease(new Release(1, 0, 3), "alpha"),
                new PreRelease(new Release(1, 0, 3), "beta"),
                new Release(1, 0, 3),
                new PreRelease(new Release(1, 2, 0), "alpha"),
                new PreRelease(new Release(1, 2, 0), "rc.1"),
                new Release(1, 2, 0),
                new PreRelease(new Release(1, 2, 3), "alpha"),
                new Release(1, 2, 3),
                new PreRelease(new Release(2, 0, 0), "alpha"),
                new Release(2, 0, 0),
                new PreRelease(new Release(2, 0, 3), "alpha"),
                new Release(2, 0, 3),
                new PreRelease(new Release(2, 2, 0), "alpha"),
                new Release(2, 2, 0),
                new PreRelease(new Release(2, 2, 3), "alpha"),
                new Release(2, 2, 3)));
    }

}
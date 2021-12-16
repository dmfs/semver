package org.dmfs.semver.comparators;

import org.dmfs.semver.PreRelease;
import org.dmfs.semver.Release;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


class VersionComparatorTest
{

    @Test
    void testReleases()
    {
        assertThat(
            new VersionComparator().compare(
                new Release(1, 0, 0),
                new Release(1, 0, 0)),
            is(equalTo(0)));

        assertThat(
            new VersionComparator().compare(
                new Release(1, 0, 0),
                new Release(2, 0, 0)),
            is(lessThan(0)));

        assertThat(
            new VersionComparator().compare(
                new Release(1, 0, 0),
                new Release(1, 1, 0)),
            is(lessThan(0)));

        assertThat(
            new VersionComparator().compare(
                new Release(1, 0, 0),
                new Release(1, 0, 1)),
            is(lessThan(0)));

        assertThat(
            new VersionComparator().compare(
                new Release(1, 0, 99),
                new Release(1, 1, 0)),
            is(lessThan(0)));

        assertThat(
            new VersionComparator().compare(
                new Release(1, 99, 0),
                new Release(2, 0, 0)),
            is(lessThan(0)));

    }


    void testPreReleases()
    {
        assertThat(
            new VersionComparator().compare(
                new PreRelease(new Release(1, 0, 0), "alpha.1"),
                new PreRelease(new Release(1, 0, 0), "alpha.1")),
            is(equalTo(0)));

        assertThat(
            new VersionComparator().compare(
                new PreRelease(new Release(1, 0, 0), "alpha"),
                new Release(1, 0, 0)),
            is(lessThan(0)));

        assertThat(
            new VersionComparator().compare(
                new PreRelease(new Release(1, 0, 0), "alpha.1"),
                new PreRelease(new Release(1, 0, 0), "alpha.2")),
            is(lessThan(0)));

        assertThat(
            new VersionComparator().compare(
                new PreRelease(new Release(1, 0, 0), "alpha.1"),
                new PreRelease(new Release(1, 0, 0), "alpha.1.a")),
            is(lessThan(0)));

        assertThat(
            new VersionComparator().compare(
                new PreRelease(new Release(1, 0, 0), "alpha.1"),
                new PreRelease(new Release(1, 0, 0), "alpha.a")),
            is(lessThan(0)));
    }

}
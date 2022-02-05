package org.dmfs.semver;

import org.junit.jupiter.api.Test;

import static org.dmfs.semver.Matchers.preRelease;
import static org.dmfs.semver.Matchers.version;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class NextPreReleaseTest
{
    @Test
    void testAlphaVersion()
    {
        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "alpha")),
            is(preRelease(version(1, 0, 0), "alpha.1")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "alpha.1")),
            is(preRelease(version(1, 0, 0), "alpha.2")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta")),
            is(preRelease(version(1, 0, 0), "beta.1")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta.1")),
            is(preRelease(version(1, 0, 0), "beta.2")));

        assertThat(new NextPreRelease(new Release(1, 0, 0)),
            is(preRelease(version(1, 1, 0), "alpha")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "alpha")),
            is(preRelease(version(1, 2, 0), "alpha.1")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "alpha.1")),
            is(preRelease(version(1, 2, 0), "alpha.2")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta")),
            is(preRelease(version(1, 2, 0), "beta.1")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta.1")),
            is(preRelease(version(1, 2, 0), "beta.2")));

        assertThat(new NextPreRelease(new Release(1, 2, 0)),
            is(preRelease(version(1, 3, 0), "alpha")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "alpha")),
            is(preRelease(version(1, 2, 3), "alpha.1")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "alpha.1")),
            is(preRelease(version(1, 2, 3), "alpha.2")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta")),
            is(preRelease(version(1, 2, 3), "beta.1")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta.1")),
            is(preRelease(version(1, 2, 3), "beta.2")));
    }


    @Test
    void test()
    {
        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "alpha"), "beta"),
            is(preRelease(version(1, 0, 0), "beta")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "alpha.1"), "beta"),
            is(preRelease(version(1, 0, 0), "beta")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta"), "alpha"),
            is(preRelease(version(1, 1, 0), "alpha")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta.1"), "alpha"),
            is(preRelease(version(1, 1, 0), "alpha")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta"), "beta"),
            is(preRelease(version(1, 0, 0), "beta.1")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta.1"), "beta"),
            is(preRelease(version(1, 0, 0), "beta.2")));

        assertThat(new NextPreRelease(new Release(1, 0, 0), "beta"),
            is(preRelease(version(1, 1, 0), "beta")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "alpha"), "beta"),
            is(preRelease(version(1, 2, 0), "beta")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "alpha.1"), "beta"),
            is(preRelease(version(1, 2, 0), "beta")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta"), "alpha"),
            is(preRelease(version(1, 3, 0), "alpha")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta.1"), "alpha"),
            is(preRelease(version(1, 3, 0), "alpha")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta"), "beta"),
            is(preRelease(version(1, 2, 0), "beta.1")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta.1"), "beta"),
            is(preRelease(version(1, 2, 0), "beta.2")));

        assertThat(new NextPreRelease(new Release(1, 2, 0), "beta"),
            is(preRelease(version(1, 3, 0), "beta")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "alpha"), "beta"),
            is(preRelease(version(1, 2, 3), "beta")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "alpha.1"), "beta"),
            is(preRelease(version(1, 2, 3), "beta")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta"), "alpha"),
            is(preRelease(version(1, 3, 0), "alpha")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta.1"), "alpha"),
            is(preRelease(version(1, 3, 0), "alpha")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta"), "beta"),
            is(preRelease(version(1, 2, 3), "beta.1")));

        assertThat(new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta.1"), "beta"),
            is(preRelease(version(1, 2, 3), "beta.2")));

        assertThat(new NextPreRelease(new Release(1, 2, 3), "beta"),
            is(preRelease(version(1, 3, 0), "beta")));
    }
}
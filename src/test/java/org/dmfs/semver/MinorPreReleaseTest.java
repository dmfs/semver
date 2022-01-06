package org.dmfs.semver;

import org.junit.jupiter.api.Test;

import static org.dmfs.semver.Matchers.preRelease;
import static org.dmfs.semver.Matchers.version;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class MinorPreReleaseTest
{
    @Test
    void test()
    {
        assertThat(new MinorPreRelease(new PreRelease(new Release(1, 0, 0), "alpha"), "beta"),
            is(preRelease(version(1, 0, 0), "beta")));
        assertThat(new MinorPreRelease(new PreRelease(new Release(1, 0, 0), "beta"), "alpha"),
            is(preRelease(version(1, 1, 0), "alpha")));
        assertThat(new MinorPreRelease(new Release(1, 0, 0), "beta"),
            is(preRelease(version(1, 1, 0), "beta")));
        assertThat(new MinorPreRelease(new PreRelease(new Release(1, 2, 0), "alpha"), "beta"),
            is(preRelease(version(1, 2, 0), "beta")));
        assertThat(new MinorPreRelease(new PreRelease(new Release(1, 2, 0), "beta"), "alpha"),
            is(preRelease(version(1, 3, 0), "alpha")));
        assertThat(new MinorPreRelease(new Release(1, 2, 0), "beta"),
            is(preRelease(version(1, 3, 0), "beta")));
        assertThat(new MinorPreRelease(new PreRelease(new Release(1, 2, 3), "alpha"), "beta"),
            is(preRelease(version(1, 3, 0), "beta")));
        assertThat(new MinorPreRelease(new PreRelease(new Release(1, 2, 3), "beta"), "alpha"),
            is(preRelease(version(1, 3, 0), "alpha")));
        assertThat(new MinorPreRelease(new Release(1, 2, 3), "beta"),
            is(preRelease(version(1, 3, 0), "beta")));
    }
}
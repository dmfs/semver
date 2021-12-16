package org.dmfs.semver;

import org.junit.jupiter.api.Test;

import static org.dmfs.semver.Matchers.preRelease;
import static org.dmfs.semver.Matchers.version;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class MajorPreReleaseTest
{
    @Test
    void test()
    {
        assertThat(new MajorPreRelease(new PreRelease(new Release(1, 0, 0), "alpha"), "beta"),
            is(preRelease(version(1, 0, 0), "beta")));
        assertThat(new MajorPreRelease(new Release(1, 0, 0), "beta"),
            is(preRelease(version(2, 0, 0), "beta")));
        assertThat(new MajorPreRelease(new PreRelease(new Release(1, 2, 0), "alpha"), "beta"),
            is(preRelease(version(2, 0, 0), "beta")));
        assertThat(new MajorPreRelease(new Release(1, 2, 0), "beta"),
            is(preRelease(version(2, 0, 0), "beta")));
        assertThat(new MajorPreRelease(new PreRelease(new Release(1, 2, 3), "alpha"), "beta"),
            is(preRelease(version(2, 0, 0), "beta")));
        assertThat(new MajorPreRelease(new Release(1, 2, 3), "beta"),
            is(preRelease(version(2, 0, 0), "beta")));
    }
}
package org.dmfs.semver;

import org.junit.jupiter.api.Test;

import static org.dmfs.semver.Matchers.preRelease;
import static org.dmfs.semver.Matchers.version;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class PatchPreReleaseTest
{
    @Test
    void test()
    {
        assertThat(new PatchPreRelease(new PreRelease(new Release(1, 0, 0), "alpha"), "beta"),
            is(preRelease(version(1, 0, 0), "beta")));
        assertThat(new PatchPreRelease(new PreRelease(new Release(1, 0, 0), "beta"), "alpha"),
            is(preRelease(version(1, 0, 1), "alpha")));
        assertThat(new PatchPreRelease(new Release(1, 0, 0), "beta"),
            is(preRelease(version(1, 0, 1), "beta")));
        assertThat(new PatchPreRelease(new PreRelease(new Release(1, 2, 0), "alpha"), "beta"),
            is(preRelease(version(1, 2, 0), "beta")));
        assertThat(new PatchPreRelease(new PreRelease(new Release(1, 2, 0), "beta"), "alpha"),
            is(preRelease(version(1, 2, 1), "alpha")));
        assertThat(new PatchPreRelease(new Release(1, 2, 0), "beta"),
            is(preRelease(version(1, 2, 1), "beta")));
        assertThat(new PatchPreRelease(new PreRelease(new Release(1, 2, 3), "alpha"), "beta"),
            is(preRelease(version(1, 2, 3), "beta")));
        assertThat(new PatchPreRelease(new PreRelease(new Release(1, 2, 3), "beta"), "alpha"),
            is(preRelease(version(1, 2, 4), "alpha")));
        assertThat(new PatchPreRelease(new Release(1, 2, 3), "beta"),
            is(preRelease(version(1, 2, 4), "beta")));
    }
}
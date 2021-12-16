package org.dmfs.semver;

import org.junit.jupiter.api.Test;

import static org.dmfs.semver.Matchers.release;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class NextMinorTest
{

    @Test
    void test()
    {
        assertThat(new NextMinor(new PreRelease(new Release(1, 0, 0), "beta")),
            is(release(1, 0, 0)));
        assertThat(new NextMinor(new Release(1, 0, 0)),
            is(release(1, 1, 0)));
        assertThat(new NextMinor(new PreRelease(new Release(1, 2, 0), "beta")),
            is(release(1, 2, 0)));
        assertThat(new NextMinor(new Release(1, 2, 0)),
            is(release(1, 3, 0)));
        assertThat(new NextMinor(new PreRelease(new Release(1, 2, 3), "beta")),
            is(release(1, 3, 0)));
        assertThat(new NextMinor(new Release(1, 2, 3)),
            is(release(1, 3, 0)));
    }
}
package org.dmfs.semver;

import org.junit.jupiter.api.Test;

import static org.dmfs.semver.Matchers.release;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class NextMajorTest
{

    @Test
    void test()
    {
        assertThat(new NextMajor(new PreRelease(new Release(1, 0, 0), "beta")),
            is(release(1, 0, 0)));
        assertThat(new NextMajor(new Release(1, 0, 0)),
            is(release(2, 0, 0)));
        assertThat(new NextMajor(new PreRelease(new Release(1, 2, 0), "beta")),
            is(release(2, 0, 0)));
        assertThat(new NextMajor(new Release(1, 2, 0)),
            is(release(2, 0, 0)));
        assertThat(new NextMajor(new PreRelease(new Release(1, 2, 3), "beta")),
            is(release(2, 0, 0)));
        assertThat(new NextMajor(new Release(1, 2, 3)),
            is(release(2, 0, 0)));
    }

}
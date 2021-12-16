package org.dmfs.semver;

import org.dmfs.jems2.optional.Present;
import org.junit.jupiter.api.Test;

import static org.dmfs.semver.Matchers.release;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class ReleaseTest
{

    @Test
    void test()
    {
        assertThat(new Release(1, 0, 0), is(release(1, 0, 0)));
        assertThat(new Release(1, 0, 0, "123"), is(release(1, 0, 0)));
        assertThat(new Release(new Release(1, 0, 0), new Present<>("123")), is(release(1, 0, 0)));
    }

}
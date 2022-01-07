package org.dmfs.semver;

import org.junit.jupiter.api.Test;

import static org.dmfs.jems2.hamcrest.matchers.fragile.BrokenFragileMatcher.throwing;
import static org.dmfs.semver.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class StrictParserTest
{

    @Test
    void test()
    {
        assertThat(new StrictParser().parse("1.0.0"),
            is(release(1, 0, 0)));
        assertThat(new StrictParser().parse("1.0.0-alpha"),
            is(preRelease(version(1, 0, 0), "alpha")));
        assertThat(new StrictParser().parse("1.0.0-alpha+build"),
            is(preRelease(version(1, 0, 0), "alpha")));
        assertThat(new StrictParser().parse("1.0.0-alpha-123"),
            is(preRelease(version(1, 0, 0), "alpha-123")));
        assertThat(new StrictParser().parse("1.0.0-alpha.123"),
            is(preRelease(version(1, 0, 0), "alpha.123")));

        assertThat(() -> new StrictParser().parse("1.0.a-alpha-123"),
            is(throwing(IllegalArgumentException.class)));

    }

}
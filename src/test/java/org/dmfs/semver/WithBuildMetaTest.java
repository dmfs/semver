package org.dmfs.semver;

import org.dmfs.jems2.optional.Present;
import org.junit.jupiter.api.Test;

import static org.dmfs.semver.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;


class WithBuildMetaTest
{

    @Test
    void test()
    {
        assertThat(new WithBuildMeta(new Release(1, 2, 3), "123"),
            is(allOf(version(1, 2, 3), buildMeta("123"))));

        assertThat(new WithBuildMeta(new Release(3, 4, 5), "abc"),
            is(allOf(release(3, 4, 5), buildMeta("abc"))));

        assertThat(new WithBuildMeta(new StructuredVersion(1, 2, 3, new Present<>("pre"), new Present<>("build")), "123"),
            is(allOf(preRelease(version(1, 2, 3), "pre"), buildMeta("123"))));
    }

}
package org.dmfs.semver.prereleases;

import org.dmfs.jems2.optional.Absent;
import org.dmfs.jems2.optional.Present;
import org.junit.jupiter.api.Test;

import static org.dmfs.jems2.hamcrest.matchers.optional.PresentMatcher.present;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class PreReleaseSuccessorTest
{

    @Test
    void testAlphanumBase()
    {
        assertThat(new PreReleaseSuccessor(new Absent<>(), "alpha"), is(present("alpha")));
        assertThat(new PreReleaseSuccessor(new Absent<>(), "alpha.1"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Absent<>(), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("1"), "alpha"), is(present("alpha")));
        assertThat(new PreReleaseSuccessor(new Present<>("1"), "alpha.1"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("1"), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alp"), "alpha"), is(present("alpha")));
        assertThat(new PreReleaseSuccessor(new Present<>("alp"), "alpha.1"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alp"), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha"), is(present("alpha")));
        assertThat(new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.1"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha123"), "alpha"), is(present("alpha")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.1"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha"), "alpha"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha"), "alpha.1"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha"), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha"), is(present("alpha.2")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.1"), is(present("alpha.2")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha"), is(present("alpha.2")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.1"), is(present("alpha.2")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha"), is(present("alpha.11")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.1"), is(present("alpha.11")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.5"), is(present("alpha.11")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha"), is(present("alpha")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.1"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha"), is(present("alpha")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.1"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.5"), is(present("alpha.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("beta"), "alpha"), is(present("alpha")));
        assertThat(new PreReleaseSuccessor(new Present<>("beta"), "alpha.1"), is(present("alpha.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("beta"), "alpha.5"), is(present("alpha.5")));
    }


    @Test
    void testLongAlphanumBase()
    {
        assertThat(new PreReleaseSuccessor(new Absent<>(), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Absent<>(), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Absent<>(), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("1"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("1"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("1"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alp"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("alp"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alp"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.1.xyz"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.1.xyz"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1.xyz.1"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.2")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1.xyz.3"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

        assertThat(new PreReleaseSuccessor(new Present<>("beta"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
        assertThat(new PreReleaseSuccessor(new Present<>("beta"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
        assertThat(new PreReleaseSuccessor(new Present<>("beta"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));
    }


    @Test
    void testNumericBase()
    {
        assertThat(new PreReleaseSuccessor(new Absent<>(), "0"), is(present("0")));
        assertThat(new PreReleaseSuccessor(new Absent<>(), "1"), is(present("1")));
        assertThat(new PreReleaseSuccessor(new Absent<>(), "5"), is(present("5")));

        assertThat(new PreReleaseSuccessor(new Present<>("1"), "0"), is(present("2")));
        assertThat(new PreReleaseSuccessor(new Present<>("1"), "1"), is(present("2")));
        assertThat(new PreReleaseSuccessor(new Present<>("1"), "5"), is(present("5")));

        assertThat(new PreReleaseSuccessor(new Present<>("1.3"), "0"), is(present("2")));
        assertThat(new PreReleaseSuccessor(new Present<>("1.3"), "1"), is(present("2")));
        assertThat(new PreReleaseSuccessor(new Present<>("1.3"), "5"), is(present("5")));

        assertThat(new PreReleaseSuccessor(new Present<>("1.a"), "0"), is(present("2")));
        assertThat(new PreReleaseSuccessor(new Present<>("1.a"), "1"), is(present("2")));
        assertThat(new PreReleaseSuccessor(new Present<>("1.a"), "5"), is(present("5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha"), "0"), is(present("0")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha"), "1"), is(present("1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha"), "5"), is(present("5")));

        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1"), "0"), is(present("0")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1"), "1"), is(present("1")));
        assertThat(new PreReleaseSuccessor(new Present<>("alpha.1"), "5"), is(present("5")));
    }

}
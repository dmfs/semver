package org.dmfs.semver;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasToString;


class VersionSequenceTest
{

    @Test
    void test()
    {
        assertThat(
            new VersionSequence(new PreRelease(new Release(1, 2, 3), "xyz", "abc")),
            hasToString("1.2.3-xyz+abc"));
        assertThat(
            new VersionSequence(new PreRelease(new Release(1, 2, 3), "xyz")),
            hasToString("1.2.3-xyz"));
        assertThat(
            new VersionSequence(new Release(1, 2, 3, "abc")),
            hasToString("1.2.3+abc"));
    }

}
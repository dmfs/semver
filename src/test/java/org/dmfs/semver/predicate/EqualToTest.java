package org.dmfs.semver.predicate;

import org.dmfs.semver.Release;
import org.junit.jupiter.api.Test;

import static org.dmfs.jems2.hamcrest.matchers.predicate.PredicateMatcher.satisfiedBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;


class EqualToTest
{
    @Test
    void test()
    {
        assertThat(new EqualTo(new Release(2, 0, 0)),
            allOf(
                not(satisfiedBy(new Release(0, 1, 0))),
                not(satisfiedBy(new Release(1, 0, 0))),
                not(satisfiedBy(new Release(1, 99, 99))),
                satisfiedBy(new Release(2, 0, 0)),
                not(satisfiedBy(new Release(2, 0, 1))),
                not(satisfiedBy(new Release(2, 1, 0))),
                not(satisfiedBy(new Release(3, 0, 0)))
            ));
    }
}
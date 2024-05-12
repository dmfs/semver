package org.dmfs.semver.predicate;

import org.dmfs.jems2.confidence.Jems2;
import org.dmfs.semver.Release;
import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.core.quality.Composite.not;
import static org.saynotobugs.confidence.core.quality.Predicate.satisfiedBy;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class LessThanTest
{
    Assertion less_than_2_0_0 = assertionThat(
        new LessThan(new Release(2, 0, 0)),
        allOf(
            satisfiedBy(new Release(0, 1, 0)),
            satisfiedBy(new Release(1, 0, 0)),
            satisfiedBy(new Release(1, 99, 99)),
            not(satisfiedBy(new Release(2, 0, 0))),
            not(satisfiedBy(new Release(2, 0, 1))),
            not(satisfiedBy(new Release(2, 1, 0))),
            not(satisfiedBy(new Release(3, 0, 0))),

            Jems2.satisfiedBy(new Release(0, 1, 0)),
            Jems2.satisfiedBy(new Release(1, 0, 0)),
            Jems2.satisfiedBy(new Release(1, 99, 99)),
            not(Jems2.satisfiedBy(new Release(2, 0, 0))),
            not(Jems2.satisfiedBy(new Release(2, 0, 1))),
            not(Jems2.satisfiedBy(new Release(2, 1, 0))),
            not(Jems2.satisfiedBy(new Release(3, 0, 0)))
        ));
}
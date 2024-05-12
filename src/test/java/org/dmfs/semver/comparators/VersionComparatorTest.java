package org.dmfs.semver.comparators;

import org.dmfs.semver.PreRelease;
import org.dmfs.semver.Release;
import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.saynotobugs.confidence.core.quality.Comparator.imposesOrderOf;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class VersionComparatorTest
{
    Assertion VersionComparator_imposes_correct_order = assertionThat(
        new VersionComparator(),
        imposesOrderOf(
            new PreRelease(new Release(1, 0, 0), "alpha"),
            new PreRelease(new Release(1, 0, 0), "alpha.1"),
            new Release(1, 0, 0),
            new PreRelease(new Release(1, 0, 3), "alpha"),
            new PreRelease(new Release(1, 0, 3), "beta"),
            new Release(1, 0, 3),
            new PreRelease(new Release(1, 2, 0), "alpha"),
            new PreRelease(new Release(1, 2, 0), "rc.1"),
            new Release(1, 2, 0),
            new PreRelease(new Release(1, 2, 3), "alpha"),
            new Release(1, 2, 3),
            new PreRelease(new Release(2, 0, 0), "alpha"),
            new Release(2, 0, 0),
            new PreRelease(new Release(2, 0, 3), "alpha"),
            new Release(2, 0, 3),
            new PreRelease(new Release(2, 2, 0), "alpha"),
            new Release(2, 2, 0),
            new PreRelease(new Release(2, 2, 3), "alpha"),
            new Release(2, 2, 3)));
}
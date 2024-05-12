package org.dmfs.semver.comparators;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.saynotobugs.confidence.core.quality.Comparator.imposesOrderOf;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;

@Confidence
class PreReleaseComparatorTest
{
    Assertion PreReleaseComparator_imposes_correct_order = assertionThat(
        new PreReleaseComparator(),
        imposesOrderOf(
            "0",
            "5",
            "100",
            "alpha",
            "alpha.1",
            "alpha.1.5",
            "alpha.1.100",
            "alpha.1.a",
            "alpha.1.b",
            "alpha.5",
            "alpha.100",
            "beta",
            "beta.1",
            "beta.5",
            "beta.100"
        ));
}
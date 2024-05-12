package org.dmfs.semver.comparators;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.saynotobugs.confidence.core.quality.Comparator.imposesOrderOf;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class IdentifierComparatorTest
{
    Assertion IdentifierComparator_imposes_correct_order = assertionThat(
        new IdentifierComparator(),
        imposesOrderOf("1", "2", "4", "100", "alpha", "beta"));
}
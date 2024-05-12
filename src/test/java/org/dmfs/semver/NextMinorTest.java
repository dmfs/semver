package org.dmfs.semver;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.semver.confidence.SemVer.release;
import static org.saynotobugs.confidence.core.quality.Grammar.is;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class NextMinorTest
{
    Assertion next_minor_of_1_0_0_beta = assertionThat(
        new NextMinor(new PreRelease(new Release(1, 0, 0), "beta")),
        is(release(1, 0, 0)));

    Assertion next_minor_of_1_0_0 = assertionThat(
        new NextMinor(new Release(1, 0, 0)),
        is(release(1, 1, 0)));

    Assertion next_minor_of_1_2_0_beta = assertionThat(
        new NextMinor(new PreRelease(new Release(1, 2, 0), "beta")),
        is(release(1, 2, 0)));

    Assertion next_minor_of_1_2_0 = assertionThat(
        new NextMinor(new Release(1, 2, 0)),
        is(release(1, 3, 0)));

    Assertion next_minor_of_1_2_3_beta = assertionThat(
        new NextMinor(new PreRelease(new Release(1, 2, 3), "beta")),
        is(release(1, 3, 0)));

    Assertion next_minor_of_1_2_3 = assertionThat(
        new NextMinor(new Release(1, 2, 3)),
        is(release(1, 3, 0)));
}
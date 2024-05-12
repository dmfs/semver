package org.dmfs.semver;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.semver.confidence.SemVer.release;
import static org.saynotobugs.confidence.core.quality.Grammar.is;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class NextMajorTest
{
    Assertion next_major_of_1_0_0_beta = assertionThat(
        new NextMajor(new PreRelease(new Release(1, 0, 0), "beta")),
        is(release(1, 0, 0)));

    Assertion next_major_of_1_0_0 = assertionThat(
        new NextMajor(new Release(1, 0, 0)),
        is(release(2, 0, 0)));

    Assertion next_major_of_1_2_0_beta = assertionThat(
        new NextMajor(new PreRelease(new Release(1, 2, 0), "beta")),
        is(release(2, 0, 0)));

    Assertion next_major_of_1_2_0 = assertionThat(
        new NextMajor(new Release(1, 2, 0)),
        is(release(2, 0, 0)));

    Assertion next_major_of_1_2_3_beta = assertionThat(
        new NextMajor(new PreRelease(new Release(1, 2, 3), "beta")),
        is(release(2, 0, 0)));

    Assertion next_major_of_1_2_3 = assertionThat(
        new NextMajor(new Release(1, 2, 3)),
        is(release(2, 0, 0)));
}
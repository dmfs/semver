package org.dmfs.semver;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.semver.confidence.SemVer.preRelease;
import static org.saynotobugs.confidence.core.quality.Grammar.is;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class NextPreReleaseTest
{
    Assertion next_prerelease_of_1_0_0_alpha = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "alpha")),
        is(preRelease(1, 0, 0, "alpha.1")));

    Assertion next_prerelease_of_1_0_0_alpha_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "alpha.1")),
        is(preRelease(1, 0, 0, "alpha.2")));

    Assertion next_prerelease_of_1_0_0_beta = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta")),
        is(preRelease(1, 0, 0, "beta.1")));

    Assertion next_prerelease_of_1_0_0_beta_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta.1")),
        is(preRelease(1, 0, 0, "beta.2")));

    Assertion next_prerelease_of_1_0_0 = assertionThat(
        new NextPreRelease(new Release(1, 0, 0)),
        is(preRelease(1, 1, 0, "alpha")));

    Assertion next_prerelease_of_1_2_0_alpha = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "alpha")),
        is(preRelease(1, 2, 0, "alpha.1")));

    Assertion next_prerelease_of_1_2_0_alpha_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "alpha.1")),
        is(preRelease(1, 2, 0, "alpha.2")));

    Assertion next_prerelease_of_1_2_0_beta = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta")),
        is(preRelease(1, 2, 0, "beta.1")));

    Assertion next_prerelease_of_1_2_0_beta_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta.1")),
        is(preRelease(1, 2, 0, "beta.2")));

    Assertion next_prerelease_of_1_2_0 = assertionThat(
        new NextPreRelease(new Release(1, 2, 0)),
        is(preRelease(1, 3, 0, "alpha")));

    Assertion next_prerelease_of_1_2_3_alpha = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "alpha")),
        is(preRelease(1, 2, 3, "alpha.1")));

    Assertion next_prerelease_of_1_2_3_alpha_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "alpha.1")),
        is(preRelease(1, 2, 3, "alpha.2")));

    Assertion next_prerelease_of_1_2_3_beta = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta")),
        is(preRelease(1, 2, 3, "beta.1")));

    Assertion next_prerelease_of_1_2_3_beta_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta.1")),
        is(preRelease(1, 2, 3, "beta.2")));

    Assertion next_prerelease_of_1_2_3 = assertionThat(
        new NextPreRelease(new Release(1, 2, 3)),
        is(preRelease(1, 3, 0, "alpha")));

    Assertion next_beta_prerelease_of_1_0_0_alpha = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "alpha"), "beta"),
        is(preRelease(1, 0, 0, "beta")));

    Assertion next_beta_prerelease_of_1_0_0_alpha_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "alpha.1"), "beta"),
        is(preRelease(1, 0, 0, "beta")));

    Assertion next_alpha_prerelease_of_1_0_0_beta = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta"), "alpha"),
        is(preRelease(1, 1, 0, "alpha")));

    Assertion next_alpha_prerelease_of_1_0_0_beta_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta.1"), "alpha"),
        is(preRelease(1, 1, 0, "alpha")));

    Assertion next_beta_prerelease_of_1_0_0_beta = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta"), "beta"),
        is(preRelease(1, 0, 0, "beta.1")));

    Assertion next_beta_prerelease_of_1_0_0_beta_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 0, 0), "beta.1"), "beta"),
        is(preRelease(1, 0, 0, "beta.2")));

    Assertion next_beta_prerelease_of_1_0_0 = assertionThat(
        new NextPreRelease(new Release(1, 0, 0), "beta"),
        is(preRelease(1, 1, 0, "beta")));

    Assertion next_beta_prerelease_of_1_2_0_alpha = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "alpha"), "beta"),
        is(preRelease(1, 2, 0, "beta")));

    Assertion next_beta_prerelease_of_1_2_0_alpha_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "alpha.1"), "beta"),
        is(preRelease(1, 2, 0, "beta")));

    Assertion next_alpha_prerelease_of_1_2_0_beta = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta"), "alpha"),
        is(preRelease(1, 3, 0, "alpha")));

    Assertion next_alpha_prerelease_of_1_2_0_beta_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta.1"), "alpha"),
        is(preRelease(1, 3, 0, "alpha")));

    Assertion next_beta_prerelease_of_1_2_0_beta = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta"), "beta"),
        is(preRelease(1, 2, 0, "beta.1")));

    Assertion next_beta_prerelease_of_1_2_0_beta_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 0), "beta.1"), "beta"),
        is(preRelease(1, 2, 0, "beta.2")));

    Assertion next_beta_prerelease_of_1_2_0 = assertionThat(
        new NextPreRelease(new Release(1, 2, 0), "beta"),
        is(preRelease(1, 3, 0, "beta")));

    Assertion next_beta_prerelease_of_1_2_3_alpha = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "alpha"), "beta"),
        is(preRelease(1, 2, 3, "beta")));

    Assertion next_beta_prerelease_of_1_2_3_alpha_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "alpha.1"), "beta"),
        is(preRelease(1, 2, 3, "beta")));

    Assertion next_alpha_prerelease_of_1_2_3_alpha = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta"), "alpha"),
        is(preRelease(1, 3, 0, "alpha")));

    Assertion next_alpha_prerelease_of_1_2_3_beta_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta.1"), "alpha"),
        is(preRelease(1, 3, 0, "alpha")));

    Assertion next_beta_prerelease_of_1_2_3_beta = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta"), "beta"),
        is(preRelease(1, 2, 3, "beta.1")));

    Assertion next_beta_prerelease_of_1_2_3_beta_1 = assertionThat(
        new NextPreRelease(new PreRelease(new Release(1, 2, 3), "beta.1"), "beta"),
        is(preRelease(1, 2, 3, "beta.2")));

    Assertion next_beta_prerelease_of_1_2_3 = assertionThat(
        new NextPreRelease(new Release(1, 2, 3), "beta"),
        is(preRelease(1, 3, 0, "beta")));
}
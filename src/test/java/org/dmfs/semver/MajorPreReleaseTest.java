package org.dmfs.semver;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.semver.confidence.SemVer.preRelease;
import static org.saynotobugs.confidence.core.quality.Grammar.is;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class MajorPreReleaseTest
{
    Assertion beta_major_prerelease_of_1_0_0_alpha = assertionThat(
        new MajorPreRelease(new PreRelease(new Release(1, 0, 0), "alpha"), "beta"),
        is(preRelease(1, 0, 0, "beta")));

    Assertion alpha_major_prerelease_of_1_0_0_beta = assertionThat(
        new MajorPreRelease(new PreRelease(new Release(1, 0, 0), "beta"), "alpha"),
        is(preRelease(2, 0, 0, "alpha")));

    Assertion beta_major_prerelease_of_1_0_0 = assertionThat(
        new MajorPreRelease(new Release(1, 0, 0), "beta"),
        is(preRelease(2, 0, 0, "beta")));

    Assertion beta_major_prerelease_of_1_0_1_alpha = assertionThat(
        new MajorPreRelease(new PreRelease(new Release(1, 0, 1), "alpha"), "beta"),
        is(preRelease(2, 0, 0, "beta")));

    Assertion alpha_major_prerelease_of_1_0_1_beta = assertionThat(
        new MajorPreRelease(new PreRelease(new Release(1, 0, 1), "beta"), "alpha"),
        is(preRelease(2, 0, 0, "alpha")));

    Assertion beta_major_prerelease_of_1_0_1 = assertionThat(
        new MajorPreRelease(new Release(1, 0, 1), "beta"),
        is(preRelease(2, 0, 0, "beta")));

    Assertion beta_major_prerelease_of_1_2_0_alpha = assertionThat(
        new MajorPreRelease(new PreRelease(new Release(1, 2, 0), "alpha"), "beta"),
        is(preRelease(2, 0, 0, "beta")));

    Assertion alpha_major_prerelease_of_1_2_0_beta = assertionThat(
        new MajorPreRelease(new PreRelease(new Release(1, 2, 0), "beta"), "alpha"),
        is(preRelease(2, 0, 0, "alpha")));

    Assertion beta_major_prerelease_of_1_2_0 = assertionThat(
        new MajorPreRelease(new Release(1, 2, 0), "beta"),
        is(preRelease(2, 0, 0, "beta")));

    Assertion beta_major_prerelease_of_1_2_3_alpha = assertionThat(
        new MajorPreRelease(new PreRelease(new Release(1, 2, 3), "alpha"), "beta"),
        is(preRelease(2, 0, 0, "beta")));

    Assertion beta_major_prerelease_of_1_2_3_beta = assertionThat(
        new MajorPreRelease(new PreRelease(new Release(1, 2, 3), "beta"), "alpha"),
        is(preRelease(2, 0, 0, "alpha")));

    Assertion beta_major_prerelease_of_1_2_3 = assertionThat(
        new MajorPreRelease(new Release(1, 2, 3), "beta"),
        is(preRelease(2, 0, 0, "beta")));
}
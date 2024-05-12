package org.dmfs.semver;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.semver.confidence.SemVer.preRelease;
import static org.saynotobugs.confidence.core.quality.Grammar.is;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class PatchPreReleaseTest
{
    Assertion next_beta_patch_prerelease_of_1_0_0_alpha = assertionThat(
        new PatchPreRelease(new PreRelease(new Release(1, 0, 0), "alpha"), "beta"),
        is(preRelease(1, 0, 0, "beta")));

    Assertion next_alpha_patch_prerelease_of_1_0_0_alpha = assertionThat(
        new PatchPreRelease(new PreRelease(new Release(1, 0, 0), "beta"), "alpha"),
        is(preRelease(1, 0, 1, "alpha")));

    Assertion next_beta_patch_prerelease_of_1_0_0 = assertionThat(
        new PatchPreRelease(new Release(1, 0, 0), "beta"),
        is(preRelease(1, 0, 1, "beta")));

    Assertion next_beta_patch_prerelease_of_1_2_0_alpha = assertionThat(
        new PatchPreRelease(new PreRelease(new Release(1, 2, 0), "alpha"), "beta"),
        is(preRelease(1, 2, 0, "beta")));

    Assertion next_alpha_patch_prerelease_of_1_2_0_beta = assertionThat(
        new PatchPreRelease(new PreRelease(new Release(1, 2, 0), "beta"), "alpha"),
        is(preRelease(1, 2, 1, "alpha")));

    Assertion next_beta_patch_prerelease_of_1_2_0 = assertionThat(
        new PatchPreRelease(new Release(1, 2, 0), "beta"),
        is(preRelease(1, 2, 1, "beta")));

    Assertion next_beta_patch_prerelease_of_1_2_3_alpha = assertionThat(
        new PatchPreRelease(new PreRelease(new Release(1, 2, 3), "alpha"), "beta"),
        is(preRelease(1, 2, 3, "beta")));

    Assertion next_alpha_patch_prerelease_of_1_2_3_beta = assertionThat(
        new PatchPreRelease(new PreRelease(new Release(1, 2, 3), "beta"), "alpha"),
        is(preRelease(1, 2, 4, "alpha")));

    Assertion next_beta_patch_prerelease_of_1_2_3 = assertionThat(
        new PatchPreRelease(new Release(1, 2, 3), "beta"),
        is(preRelease(1, 2, 4, "beta")));
}
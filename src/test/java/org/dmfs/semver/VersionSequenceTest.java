package org.dmfs.semver;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.saynotobugs.confidence.core.quality.Object.hasToString;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class VersionSequenceTest
{
    Assertion pre_release_version_with_build_meta = assertionThat(
        new VersionSequence(new WithBuildMeta(new PreRelease(new Release(1, 2, 3), "xyz"), "abc")),
        hasToString("1.2.3-xyz+abc"));

    Assertion pre_release_version = assertionThat(
        new VersionSequence(new PreRelease(new Release(1, 2, 3), "xyz")),
        hasToString("1.2.3-xyz"));

    Assertion release_version_with_build_meta = assertionThat(
        new VersionSequence(new Release(1, 2, 3, "abc")),
        hasToString("1.2.3+abc"));

    Assertion release_version = assertionThat(
        new VersionSequence(new Release(1, 2, 3)),
        hasToString("1.2.3"));
}
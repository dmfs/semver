package org.dmfs.semver;

import org.dmfs.jems2.optional.Present;
import org.saynotobugs.confidence.junit5.engine.Confidence;
import org.saynotobugs.confidence.junit5.engine.Verifiable;

import static org.dmfs.semver.confidence.SemVer.hasBuild;
import static org.dmfs.semver.confidence.SemVer.release;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertThat;
import static org.saynotobugs.confidence.quality.Core.allOf;
import static org.saynotobugs.confidence.quality.Core.is;


@Confidence
class ReleaseTest
{

    Verifiable release_without_build = assertThat(
        new Release(1, 0, 0),
        is(release(1, 0, 0)));

    Verifiable release_with_build = assertThat(
        new Release(1, 0, 0, "123"),
        is(allOf(
            release(1, 0, 0),
            hasBuild("123"))));
    Verifiable release_with_build_optional = assertThat(
        new Release(1, 0, 0, new Present<>("123")),
        is(allOf(
            release(1, 0, 0),
            hasBuild("123"))));
}
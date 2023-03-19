package org.dmfs.semver.confidence;

import org.dmfs.semver.Version;
import org.saynotobugs.confidence.junit5.engine.Confidence;
import org.saynotobugs.confidence.junit5.engine.Verifiable;

import static org.dmfs.jems2.mockito.Mock.*;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertThat;
import static org.saynotobugs.confidence.quality.Core.allOf;
import static org.saynotobugs.confidence.quality.Core.greaterThan;
import static org.saynotobugs.confidence.test.quality.Test.*;


@Confidence
class HasPatchTest
{
    Verifiable has_patch_int = assertThat(
        new HasPatch(5),
        allOf(
            passes(mock(Version.class, with(Version::patch, returning(5)))),
            fails(mock(Version.class, with(Version::patch, returning(4))), "had patch <4>"),
            hasDescription("has patch <5>")
        )
    );

    Verifiable has_patch_quality = assertThat(
        new HasPatch(greaterThan(4)),
        allOf(
            passes(mock(Version.class, with(Version::patch, returning(5)))),
            fails(mock(Version.class, with(Version::patch, returning(4))), "had patch <4>"),
            hasDescription("has patch greater than <4>")
        )
    );
}
package org.dmfs.semver.confidence;

import org.dmfs.semver.Version;
import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.jems2.mockito.Mock.*;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;
import static org.saynotobugs.confidence.quality.Core.allOf;
import static org.saynotobugs.confidence.quality.Core.greaterThan;
import static org.saynotobugs.confidence.test.quality.Test.*;


@Confidence
class HasPatchTest
{
    Assertion has_patch_int = assertionThat(
        new HasPatch(5),
        allOf(
            passes(mock(Version.class, with(Version::patch, returning(5)))),
            fails(mock(Version.class, with(Version::patch, returning(4))), "had patch <4>"),
            hasDescription("has patch <5>")
        )
    );

    Assertion has_patch_quality = assertionThat(
        new HasPatch(greaterThan(4)),
        allOf(
            passes(mock(Version.class, with(Version::patch, returning(5)))),
            fails(mock(Version.class, with(Version::patch, returning(4))), "had patch <4>"),
            hasDescription("has patch greater than <4>")
        )
    );
}
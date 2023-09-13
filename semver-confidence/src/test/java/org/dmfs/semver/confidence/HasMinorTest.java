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
class HasMinorTest
{
    Assertion has_minor_int = assertionThat(
        new HasMinor(5),
        allOf(
            passes(mock(Version.class, with(Version::minor, returning(5)))),
            fails(mock(Version.class, with(Version::minor, returning(4))), "had minor <4>"),
            hasDescription("has minor <5>")
        )
    );

    Assertion has_minor_quality = assertionThat(
        new HasMinor(greaterThan(4)),
        allOf(
            passes(mock(Version.class, with(Version::minor, returning(5)))),
            fails(mock(Version.class, with(Version::minor, returning(4))), "had minor <4>"),
            hasDescription("has minor greater than <4>")
        )
    );
}
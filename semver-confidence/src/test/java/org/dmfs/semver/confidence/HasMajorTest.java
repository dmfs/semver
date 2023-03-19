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
class HasMajorTest
{
    Verifiable has_major_int = assertThat(
        new HasMajor(5),
        allOf(
            passes(mock(Version.class, with(Version::major, returning(5)))),
            fails(mock(Version.class, with(Version::major, returning(4))), "had major <4>"),
            hasDescription("has major <5>")
        )
    );

    Verifiable has_major_quality = assertThat(
        new HasMajor(greaterThan(4)),
        allOf(
            passes(mock(Version.class, with(Version::major, returning(5)))),
            fails(mock(Version.class, with(Version::major, returning(4))), "had major <4>"),
            hasDescription("has major greater than <4>")
        )
    );
}
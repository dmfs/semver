package org.dmfs.semver.confidence;

import org.dmfs.jems2.optional.Absent;
import org.dmfs.jems2.optional.Present;
import org.dmfs.semver.Version;
import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.jems2.mockito.Mock.*;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;
import static org.saynotobugs.confidence.quality.Core.allOf;
import static org.saynotobugs.confidence.quality.Core.matchesPattern;
import static org.saynotobugs.confidence.test.quality.Test.*;


@Confidence
class HasPreReleaseTest
{
    Assertion has_preRelease_string = assertionThat(
        new HasPreRelease("12345"),
        allOf(
            passes(mock(Version.class, with(Version::preRelease, returning(new Present<>("12345"))))),
            fails(mock(Version.class, with(Version::preRelease, returning(new Present<>("123456")))), "had preRelease present \"123456\""),
            fails(mock(Version.class, with(Version::preRelease, returning(new Absent<>()))), "had preRelease absent"),
            hasDescription("has preRelease present \"12345\"")
        )
    );

    Assertion has_preRelease_quality = assertionThat(
        new HasPreRelease(matchesPattern(".*234.*")),
        allOf(
            passes(mock(Version.class, with(Version::preRelease, returning(new Present<>("12345"))))),
            fails(mock(Version.class, with(Version::preRelease, returning(new Present<>("12245")))),
                "had preRelease present \"12245\" mismatched pattern /.*234.*/"),
            fails(mock(Version.class, with(Version::preRelease, returning(new Absent<>()))), "had preRelease absent"),
            hasDescription("has preRelease present matches pattern /.*234.*/")
        )
    );
}
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
class HasNoPreReleaseTest
{
    Assertion has_no_preRelease = assertionThat(
        new HasNoPreRelease(),
        allOf(
            passes(mock(Version.class, with(Version::preRelease, returning(new Absent<>())))),
            fails(mock(Version.class, with(Version::preRelease, returning(new Present<>("123456")))),
                describesAs(matchesPattern("had preRelease <present \"123456\" >"))),
            hasDescription("has preRelease <absent>")
        )
    );
}
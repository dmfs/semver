package org.dmfs.semver.confidence;

import org.dmfs.jems2.optional.Absent;
import org.dmfs.jems2.optional.Present;
import org.dmfs.semver.Version;
import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;
import org.saynotobugs.confidence.quality.object.EqualTo;

import static org.dmfs.jems2.mockito.Mock.*;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;
import static org.saynotobugs.confidence.quality.Core.allOf;
import static org.saynotobugs.confidence.quality.Core.matchesPattern;
import static org.saynotobugs.confidence.test.quality.Test.*;


@Confidence
class ReleaseTest
{
    Assertion release_with_ints = assertionThat(
        new Release(1, 2, 3),
        allOf(
            passes(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Absent<>())))),
            fails(mock(Version.class,
                with(Version::major, returning(2)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Absent<>()))), "{ had major <2>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(3)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Absent<>()))), "{ ...\n  had minor <3>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(2)),
                with(Version::preRelease, returning(new Absent<>()))), "{ ...\n  had patch <2>\n  ... }"),
            fails(mock(Version.class,
                    with(Version::major, returning(1)),
                    with(Version::minor, returning(3)),
                    with(Version::patch, returning(2)),
                    with(Version::preRelease, returning(new Present<>("123")))),
                describesAs(matchesPattern(
                    "\\{ ...\n  had minor <3>\n  and\n  had patch <2>\n  and\n  had preRelease <present <org\\.dmfs\\.jems2\\.optional\\.Present@.*> > \\}"))),
            hasDescription("has major <1>\n  and\n  has minor <2>\n  and\n  has patch <3>\n  and\n  has preRelease <absent>"))
    );

    Assertion release_with_qualities = assertionThat(
        new Release(new EqualTo<>(1), new EqualTo<>(2), new EqualTo<>(3)),
        allOf(
            passes(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Absent<>())))),
            fails(mock(Version.class,
                with(Version::major, returning(2)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Absent<>()))), "{ had major <2>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(3)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Absent<>()))), "{ ...\n  had minor <3>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(2)),
                with(Version::preRelease, returning(new Absent<>()))), "{ ...\n  had patch <2>\n  ... }"),
            fails(mock(Version.class,
                    with(Version::major, returning(1)),
                    with(Version::minor, returning(3)),
                    with(Version::patch, returning(2)),
                    with(Version::preRelease, returning(new Present<>("123")))),
                describesAs(matchesPattern(
                    "\\{ ...\n  had minor <3>\n  and\n  had patch <2>\n  and\n  had preRelease <present <org\\.dmfs\\.jems2\\.optional\\.Present@.*> > \\}"))),
            hasDescription("has major <1>\n  and\n  has minor <2>\n  and\n  has patch <3>\n  and\n  has preRelease <absent>"))
    );
}
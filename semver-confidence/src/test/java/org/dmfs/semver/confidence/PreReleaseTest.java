package org.dmfs.semver.confidence;

import org.dmfs.jems2.optional.Absent;
import org.dmfs.jems2.optional.Present;
import org.dmfs.semver.Version;
import org.saynotobugs.confidence.junit5.engine.Confidence;
import org.saynotobugs.confidence.junit5.engine.Verifiable;
import org.saynotobugs.confidence.quality.object.EqualTo;

import static org.dmfs.jems2.mockito.Mock.*;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertThat;
import static org.saynotobugs.confidence.quality.Core.allOf;
import static org.saynotobugs.confidence.test.quality.Test.*;


@Confidence
class PreReleaseTest
{
    Verifiable preRelease_with_primitives = assertThat(
        new PreRelease(1, 2, 3, "abc"),
        allOf(
            passes(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Present<>("abc"))))),
            fails(mock(Version.class,
                with(Version::major, returning(2)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Present<>("abc")))), "{ had major <2>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(3)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Present<>("abc")))), "{ ...\n  had minor <3>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(2)),
                with(Version::preRelease, returning(new Present<>("abc")))), "{ ...\n  had patch <2>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Present<>("123")))), "{ ...\n  had preRelease present \"123\" }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(3)),
                with(Version::patch, returning(2)),
                with(Version::preRelease, returning(new Absent<>()))), "{ ...\n  had minor <3>\n  and\n  had patch <2>\n  and\n  had preRelease absent }"),
            hasDescription("has major <1>\n  and\n  has minor <2>\n  and\n  has patch <3>\n  and\n  has preRelease present \"abc\""))
    );

    Verifiable preRelease_with_qualities = assertThat(
        new PreRelease(new EqualTo<>(1), new EqualTo<>(2), new EqualTo<>(3), new EqualTo<>("abc")),
        allOf(
            passes(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Present<>("abc"))))),
            fails(mock(Version.class,
                with(Version::major, returning(2)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Present<>("abc")))), "{ had major <2>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(3)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Present<>("abc")))), "{ ...\n  had minor <3>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(2)),
                with(Version::preRelease, returning(new Present<>("abc")))), "{ ...\n  had patch <2>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)),
                with(Version::preRelease, returning(new Present<>("123")))), "{ ...\n  had preRelease present \"123\" }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(3)),
                with(Version::patch, returning(2)),
                with(Version::preRelease, returning(new Absent<>()))), "{ ...\n  had minor <3>\n  and\n  had patch <2>\n  and\n  had preRelease absent }"),
            hasDescription("has major <1>\n  and\n  has minor <2>\n  and\n  has patch <3>\n  and\n  has preRelease present \"abc\""))
    );
}
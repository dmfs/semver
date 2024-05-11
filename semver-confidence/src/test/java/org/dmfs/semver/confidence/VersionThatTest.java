package org.dmfs.semver.confidence;

import org.dmfs.semver.Version;
import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.jems2.mockito.Mock.*;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;
import static org.saynotobugs.confidence.quality.Core.allOf;
import static org.saynotobugs.confidence.test.quality.Test.*;


@Confidence
class VersionThatTest
{
    Assertion versionThat_with_one_delegate = assertionThat(
        new VersionThat(new HasMajor(1)),
        allOf(
            passes(mock(Version.class, with(Version::major, returning(1)))),
            fails(mock(Version.class, with(Version::major, returning(2))), "{ had major <2> }"),
            hasDescription("{ has major <1> }"))
    );

    Assertion versionThat_with_multiple_delegates = assertionThat(
        new VersionThat(new HasMajor(1), new HasMinor(2), new HasPatch(3)),
        allOf(
            passes(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3)))),
            fails(mock(Version.class,
                with(Version::major, returning(2)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(3))), "{ had major <2>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(3)),
                with(Version::patch, returning(3))), "{ ...\n  had minor <3>\n  ... }"),
            fails(mock(Version.class,
                with(Version::major, returning(1)),
                with(Version::minor, returning(2)),
                with(Version::patch, returning(2))), "{ ...\n  had patch <2> }"),
            hasDescription("{ has major <1>\n  and\n  has minor <2>\n  and\n  has patch <3> }"))
    );
}
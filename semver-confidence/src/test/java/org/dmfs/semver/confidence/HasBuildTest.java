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
class HasBuildTest
{
    Assertion has_build_string = assertionThat(
        new HasBuild("12345"),
        allOf(
            passes(mock(Version.class, with(Version::build, returning(new Present<>("12345"))))),
            fails(mock(Version.class, with(Version::build, returning(new Present<>("123456")))), "had build present \"123456\""),
            fails(mock(Version.class, with(Version::build, returning(new Absent<>()))), "had build absent"),
            hasDescription("has build present \"12345\"")
        )
    );

    Assertion has_build_quality = assertionThat(
        new HasBuild(matchesPattern(".*234.*")),
        allOf(
            passes(mock(Version.class, with(Version::build, returning(new Present<>("12345"))))),
            fails(mock(Version.class, with(Version::build, returning(new Present<>("12245")))), "had build present \"12245\" mismatched pattern /.*234.*/"),
            fails(mock(Version.class, with(Version::build, returning(new Absent<>()))), "had build absent"),
            hasDescription("has build present matches pattern /.*234.*/")
        )
    );
}
package org.dmfs.semver;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.semver.confidence.SemVer.*;
import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.core.quality.Grammar.to;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class StrictParserTest
{
    Assertion parses_releases =
        assertionThat(new StrictParser(),
            allOf(
                parses("1.2.3", to(
                    allOf(
                        release(1, 2, 3),
                        hasNoBuild()))),
                parses("123.456.789", to(
                    allOf(
                        release(123, 456, 789),
                        hasNoBuild())))));

    Assertion parses_pre_releases =
        assertionThat(new StrictParser(),
            allOf(
                parses("2.3.4-alpha", to(
                    allOf(
                        preRelease(2, 3, 4, "alpha"),
                        hasNoBuild()))),
                parses("2.3.4-alpha-567", to(
                    allOf(
                        preRelease(2, 3, 4, "alpha-567"),
                        hasNoBuild()))),
                parses("2.3.4-alpha.567", to(
                    allOf(
                        preRelease(2, 3, 4, "alpha.567"),
                        hasNoBuild())))));

    Assertion parses_build =
        assertionThat(new StrictParser(),
            allOf(
                parses("3.4.5-alpha+build", to(
                    allOf(
                        preRelease(3, 4, 5, "alpha"),
                        hasBuild("build")))),
                parses("3.4.5-alpha-123+build-1", to(
                    allOf(
                        preRelease(3, 4, 5, "alpha-123"),
                        hasBuild("build-1")))),
                parses("3.4.5-alpha.123+build.1", to(
                    allOf(
                        preRelease(3, 4, 5, "alpha.123"),
                        hasBuild("build.1"))))));

    Assertion fails_to_parse_invalid_versions =
        assertionThat(new StrictParser(),
            allOf(
                failsToParse("1"),
                failsToParse("1.2"),
                failsToParse("1.2.a"),
                failsToParse("1.2.3.4"),
                failsToParse("1.0.a-alpha-123")));
}
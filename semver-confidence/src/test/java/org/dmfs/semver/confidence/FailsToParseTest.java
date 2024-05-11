package org.dmfs.semver.confidence;

import org.dmfs.semver.Release;
import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;
import static org.saynotobugs.confidence.test.quality.Quality.fails;
import static org.saynotobugs.confidence.test.quality.Quality.passes;

@Confidence
class FailsToParseTest
{
    Assertion fails_to_parse = assertionThat(
        new FailsToParse("a.b.c"),
        allOf(
            passes(s -> {throw new IllegalArgumentException("can't parse that");}),
            fails(s -> new Release(1, 2, 3))
        )
    );
}
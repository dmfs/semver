package org.dmfs.semver.confidence;

import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.core.quality.Grammar.to;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;
import static org.saynotobugs.confidence.test.quality.Quality.fails;
import static org.saynotobugs.confidence.test.quality.Quality.passes;

@Confidence
class ParsesTest
{
    Assertion parses_quality = assertionThat(
        new Parses("1.2.3", to(new Release(1, 2, 3))),
        allOf(
            passes(s -> new org.dmfs.semver.Release(1, 2, 3)),
            fails(s -> new org.dmfs.semver.Release(2, 3, 4)),
            fails(s -> {throw new IllegalArgumentException("Not a version");})
        )
    );
}
package org.dmfs.semver.confidence;

import org.dmfs.semver.VersionParser;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.description.Spaced;
import org.saynotobugs.confidence.description.Text;
import org.saynotobugs.confidence.description.Value;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;

import static org.saynotobugs.confidence.core.quality.Object.throwing;


@StaticFactories("SemVer")
public final class FailsToParse extends QualityComposition<VersionParser>
{
    public FailsToParse(CharSequence versionString)
    {
        super(new Has<>(
            new Spaced(new Text("fails to parse"), new Value(versionString)),
            new Spaced(new Text("did not fail to parse"), new Value(versionString)),
            v -> () -> v.parse(versionString),
            throwing(IllegalArgumentException.class)));
    }
}

package org.dmfs.semver.confidence;

import org.dmfs.semver.Version;
import org.dmfs.semver.VersionParser;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.description.Spaced;
import org.saynotobugs.confidence.description.Text;
import org.saynotobugs.confidence.description.Value;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;


@StaticFactories("SemVer")
public final class Parses extends QualityComposition<VersionParser>
{
    public Parses(CharSequence versionString, Quality<? super Version> versionQuality)
    {
        super(new Has<>(
            new Spaced(new Text("parses"), new Value(versionString)),
            new Spaced(new Text("parsed"), new Value(versionString)),
            v -> v.parse(versionString),
            versionQuality));
    }
}

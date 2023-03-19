package org.dmfs.semver.confidence;

import org.dmfs.semver.Version;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;
import org.saynotobugs.confidence.quality.object.EqualTo;


@StaticFactories("SemVer")
public final class HasMinor extends QualityComposition<Version>
{
    public HasMinor(int minor)
    {
        this(new EqualTo<>(minor));
    }


    public HasMinor(Quality<? super Integer> minorQuality)
    {
        super(new Has<>("minor", Version::minor, minorQuality));
    }
}

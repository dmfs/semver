package org.dmfs.semver.confidence;

import org.dmfs.semver.Version;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;
import org.saynotobugs.confidence.quality.object.EqualTo;


@StaticFactories("SemVer")
public final class HasMajor extends QualityComposition<Version>
{
    public HasMajor(int major)
    {
        this(new EqualTo<>(major));
    }


    public HasMajor(Quality<? super Integer> majorQuality)
    {
        super(new Has<>("major", Version::major, majorQuality));
    }
}

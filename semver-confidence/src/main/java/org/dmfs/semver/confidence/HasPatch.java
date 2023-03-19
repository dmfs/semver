package org.dmfs.semver.confidence;

import org.dmfs.semver.Version;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;
import org.saynotobugs.confidence.quality.object.EqualTo;


@StaticFactories("SemVer")
public final class HasPatch extends QualityComposition<Version>
{
    public HasPatch(int patch)
    {
        this(new EqualTo<>(patch));
    }


    public HasPatch(Quality<? super Integer> patchQuality)
    {
        super(new Has<>("patch", Version::patch, patchQuality));
    }
}

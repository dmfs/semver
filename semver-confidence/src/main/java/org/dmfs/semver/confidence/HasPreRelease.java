package org.dmfs.semver.confidence;

import org.dmfs.jems2.confidence.optional.Present;
import org.dmfs.semver.Version;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;
import org.saynotobugs.confidence.quality.object.EqualTo;


@StaticFactories("SemVer")
public final class HasPreRelease extends QualityComposition<Version>
{
    public HasPreRelease(String preRelease)
    {
        this(new EqualTo<>(preRelease));
    }


    public HasPreRelease(Quality<? super String> preRelease)
    {
        super(new Has<>("preRelease", Version::preRelease, new Present<>(preRelease)));
    }
}

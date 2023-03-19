package org.dmfs.semver.confidence;

import org.dmfs.jems2.confidence.optional.Present;
import org.dmfs.semver.Version;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;
import org.saynotobugs.confidence.quality.object.EqualTo;


@StaticFactories("SemVer")
public final class HasBuild extends QualityComposition<Version>
{
    public HasBuild(String build)
    {
        this(new EqualTo<>(build));
    }


    public HasBuild(Quality<? super String> build)
    {
        super(new Has<>("build", Version::build, new Present<>(build)));
    }
}

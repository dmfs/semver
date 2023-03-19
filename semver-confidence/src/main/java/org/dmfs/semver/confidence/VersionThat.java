package org.dmfs.semver.confidence;

import org.dmfs.jems2.iterable.Seq;
import org.dmfs.semver.Version;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.AllOf;
import org.saynotobugs.confidence.quality.composite.QualityComposition;


@StaticFactories("SemVer")
public final class VersionThat extends QualityComposition<Version>
{
    @SafeVarargs
    public VersionThat(Quality<? super Version>... delegates)
    {
        this(new Seq<>(delegates));
    }


    public VersionThat(Iterable<? extends Quality<? super Version>> delegates)
    {
        super(new AllOf<>(delegates));
    }
}

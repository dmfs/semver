package org.dmfs.semver.confidence;

import org.dmfs.semver.Version;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.QualityComposition;
import org.saynotobugs.confidence.quality.object.EqualTo;


@StaticFactories("SemVer")
public final class Release extends QualityComposition<Version>
{
    public Release(int major, int minor, int patch)
    {
        this(new EqualTo<>(major), new EqualTo<>(minor), new EqualTo<>(patch));
    }


    public Release(Quality<? super Number> major, Quality<? super Number> minor, Quality<? super Number> patch)
    {
        super(new VersionThat(new HasMajor(major), new HasMinor(minor), new HasPatch(patch), new HasNoPreRelease()));
    }
}

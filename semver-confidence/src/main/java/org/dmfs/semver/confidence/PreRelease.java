package org.dmfs.semver.confidence;

import org.dmfs.semver.Version;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.QualityComposition;
import org.saynotobugs.confidence.quality.object.EqualTo;


@StaticFactories("SemVer")
public final class PreRelease extends QualityComposition<Version>
{
    public PreRelease(int major, int minor, int patch, String preRelease)
    {
        this(new EqualTo<>(major), new EqualTo<>(minor), new EqualTo<>(patch), new EqualTo<>(preRelease));
    }


    public PreRelease(Quality<? super Number> major, Quality<? super Number> minor, Quality<? super Number> patch, Quality<? super String> preRelease)
    {
        super(new VersionThat(new HasMajor(major), new HasMinor(minor), new HasPatch(patch), new HasPreRelease(preRelease)));
    }
}

package org.dmfs.semver.confidence;

import org.dmfs.jems2.confidence.optional.Absent;
import org.dmfs.semver.Version;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;


@StaticFactories("SemVer")
public final class HasNoPreRelease extends QualityComposition<Version>
{
    public HasNoPreRelease()
    {
        super(new Has<>("preRelease", Version::preRelease, new Absent()));
    }
}

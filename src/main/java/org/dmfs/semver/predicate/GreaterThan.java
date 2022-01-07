package org.dmfs.semver.predicate;

import org.dmfs.jems2.Predicate;
import org.dmfs.semver.Version;
import org.dmfs.semver.comparators.VersionComparator;


public final class GreaterThan implements Predicate<Version>, java.util.function.Predicate<Version>
{
    private final Version mVersion;


    public GreaterThan(Version version)
    {
        mVersion = version;
    }


    @Override
    public boolean test(Version version)
    {
        return satisfiedBy(version);
    }


    @Override
    public boolean satisfiedBy(Version testedInstance)
    {
        return VersionComparator.INSTANCE.compare(testedInstance, mVersion) > 0;
    }
}

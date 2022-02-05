package org.dmfs.semver.predicate;

import org.dmfs.jems2.Predicate;
import org.dmfs.semver.Version;
import org.dmfs.semver.comparators.VersionComparator;


/**
 * A {@link Predicate} that matches when the test candidate is less (older) than a given version.
 */
public final class LessThan implements Predicate<Version>, java.util.function.Predicate<Version>
{
    private final Version mVersion;


    public LessThan(Version version)
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
        return VersionComparator.VERSION_COMPARATOR.compare(testedInstance, mVersion) < 0;
    }
}

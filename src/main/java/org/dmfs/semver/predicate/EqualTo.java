package org.dmfs.semver.predicate;

import org.dmfs.jems2.Predicate;
import org.dmfs.semver.Version;
import org.dmfs.semver.comparators.VersionComparator;


/**
 * A {@link Predicate} that matches when the test candidate matches a given version.
 */
public final class EqualTo implements Predicate<Version>, java.util.function.Predicate<Version>
{
    private final Version mVersion;


    public EqualTo(Version version)
    {
        mVersion = version;
    }


    @Override
    public boolean test(Version version)
    {
        return satisfiedBy(version);
    }


    @Override
    public boolean satisfiedBy(Version candidate)
    {
        return VersionComparator.VERSION_COMPARATOR.compare(candidate, mVersion) == 0;
    }
}

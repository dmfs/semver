package org.dmfs.semver.comparators;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.comparator.*;
import org.dmfs.semver.Version;

import java.util.Comparator;


/**
 * {@link Comparator} for {@link Version}s.
 */
public final class VersionComparator extends DelegatingComparator<Version>
{
    public static final Comparator<Optional<? extends String>> PRERELEASE_COMPARATOR =
        new GreaterAbsent<>(new OptionalComparator<>(new PreReleaseComparator()));

    public final static Comparator<Version> VERSION_COMPARATOR = new VersionComparator();


    public VersionComparator()
    {
        super(new Composite<>(
            new By<>(Version::major),
            new By<>(Version::minor),
            new By<>(Version::patch),
            new By<>(Version::preRelease, PRERELEASE_COMPARATOR)));
    }
}

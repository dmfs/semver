package org.dmfs.semver.comparators;

import org.dmfs.jems2.comparator.*;
import org.dmfs.semver.Version;


public final class VersionComparator extends DelegatingComparator<Version>
{

    public VersionComparator()
    {
        super(new Composite<>(
            new By<>(Version::major),
            new By<>(Version::minor),
            new By<>(Version::patch),
            new By<>(Version::preRelease, new GreaterAbsent<>(new OptionalComparator<>(new PreReleaseComparator())))));
    }
}

package org.dmfs.semver.comparators;

import org.dmfs.jems2.comparator.*;
import org.dmfs.semver.Version;

import java.util.Comparator;


public final class VersionComparator extends DelegatingComparator<Version>
{
    public final static Comparator<Version> INSTANCE = new VersionComparator();


    public VersionComparator()
    {
        super(new Composite<>(
            new By<>(Version::major),
            new By<>(Version::minor),
            new By<>(Version::patch),
            new By<>(Version::preRelease, new GreaterAbsent<>(new OptionalComparator<>(new PreReleaseComparator())))));
    }
}

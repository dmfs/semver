package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;

import static org.dmfs.jems2.optional.Absent.absent;


/**
 * A pre-release version of a given version. This appends or replaces (if already present) the pre-release (and build) part of the given version number without
 * altering major, minor or patch version.
 */
public final class PreRelease extends VersionComposition
{

    public PreRelease(Version delegate, String preRelease)
    {
        this(delegate, new Present<>(preRelease));
    }


    PreRelease(Version delegate, Optional<String> preRelease)
    {
        super(new Version()
        {

            @Override
            public int major()
            {
                return delegate.major();
            }


            @Override
            public int minor()
            {
                return delegate.minor();
            }


            @Override
            public int patch()
            {
                return delegate.patch();
            }


            @Override
            public Optional<String> preRelease()
            {
                return preRelease;
            }


            @Override
            public Optional<String> build()
            {
                return absent();
            }
        });
    }
}

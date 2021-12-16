package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;

import static org.dmfs.jems2.optional.Absent.absent;


public final class Release extends VersionComposition
{

    public Release(int major, int minor, int patch)
    {
        this(new StructuredVersion(major, minor, patch));
    }


    public Release(int major, int minor, int patch, String build)
    {
        this(new StructuredVersion(major, minor, patch), build);
    }


    Release(int major, int minor, int patch, Optional<String> build)
    {
        this(new StructuredVersion(major, minor, patch), build);
    }


    public Release(Version delegate)
    {
        this(delegate, absent());
    }


    public Release(Version delegate, String build)
    {
        this(delegate, new Present<>(build));
    }


    Release(Version delegate, Optional<String> build)
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
                return absent();
            }


            @Override
            public Optional<String> build()
            {
                return build;
            }
        });
    }
}

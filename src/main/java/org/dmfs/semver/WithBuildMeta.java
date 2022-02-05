package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;


/**
 * A {@link Version} decorator to add or replace a build meta tag of a given {@link Version}.
 */
public final class WithBuildMeta implements Version
{
    private final Version mDelegate;
    private final Optional<String> mBuildMeta;


    public WithBuildMeta(Version delegate, String buildMeta)
    {
        mDelegate = delegate;
        mBuildMeta = new Present<>(buildMeta);
    }


    @Override
    public int major()
    {
        return mDelegate.major();
    }


    @Override
    public int minor()
    {
        return mDelegate.minor();
    }


    @Override
    public int patch()
    {
        return mDelegate.patch();
    }


    @Override
    public Optional<String> preRelease()
    {
        return mDelegate.preRelease();
    }


    @Override
    public Optional<String> build()
    {
        return mBuildMeta;
    }
}

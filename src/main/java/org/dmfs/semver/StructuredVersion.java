package org.dmfs.semver;

import org.dmfs.jems2.Optional;

import static org.dmfs.jems2.optional.Absent.absent;


final class StructuredVersion implements Version
{
    private final int mMajor;
    private final int mMinor;
    private final int mPatch;
    private final Optional<String> mPreRelease;
    private final Optional<String> mBuild;


    StructuredVersion(int major, int minor, int patch)
    {
        this(major, minor, patch, absent(), absent());
    }


    StructuredVersion(int major, int minor, int patch, Optional<String> preRelease, Optional<String> build)
    {
        mMajor = major;
        mMinor = minor;
        mPatch = patch;
        mPreRelease = preRelease;
        mBuild = build;
    }


    @Override
    public int major()
    {
        return mMajor;
    }


    @Override
    public int minor()
    {
        return mMinor;
    }


    @Override
    public int patch()
    {
        return mPatch;
    }


    @Override
    public Optional<String> preRelease()
    {
        return mPreRelease;
    }


    @Override
    public Optional<String> build()
    {
        return mBuild;
    }
}

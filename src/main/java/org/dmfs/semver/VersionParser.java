package org.dmfs.semver;

public interface VersionParser
{
    Version parse(CharSequence versionString);
}

package org.dmfs.semver;

@FunctionalInterface
public interface VersionParser
{
    Version parse(CharSequence versionString);
}

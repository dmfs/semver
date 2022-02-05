package org.dmfs.semver;

import org.dmfs.jems2.Function;
import org.dmfs.jems2.Optional;
import org.dmfs.jems2.single.Backed;
import org.dmfs.semver.prereleases.PreReleaseSuccessor;

import static org.dmfs.semver.comparators.VersionComparator.PRERELEASE_COMPARATOR;


/**
 * The next pre-release version.
 * <p>
 * If the given version already is a pre-release and the last pre-release segment is a number it's incremented otherwise ".1" is appended.
 * If the given version is not a pre-release, the minor version is incremented and the given default pre-release is appended.
 *
 * <h2>Examples</h2>
 * <p>
 * For a given version this will result in
 *
 * <pre>
 * current version  default Pre-Release  Next Pre-Release
 * 1.0.0-alpha      beta                 1.0.0-beta
 * 1.0.0-alpha.1    beta                 1.0.0-beta
 * 1.0.0-beta       alpha                1.1.0-alpha  (roll over)
 * 1.0.0-beta.1     alpha                1.1.0-alpha  (roll over)
 * 1.0.0-beta       beta                 1.0.0-beta.1
 * 1.0.0-beta.1     beta                 1.0.0-beta.2
 * 1.0.0            beta                 1.1.0-beta
 * 1.2.0-alpha      beta                 1.2.0-beta
 * 1.2.0-alpha.1    beta                 1.2.0-beta
 * 1.2.0-beta       alpha                1.3.0-alpha  (roll over)
 * 1.2.0-beta.1     alpha                1.3.0-alpha  (roll over)
 * 1.2.0-beta       beta                 1.2.0-beta.1
 * 1.2.0-beta.1     beta                 1.2.0-beta.2
 * 1.2.0            beta                 1.3.0-beta
 * 1.2.3-alpha      beta                 1.2.3-beta
 * 1.2.3-alpha.1    beta                 1.2.3-beta
 * 1.2.3-beta       alpha                1.3.0-alpha  (roll over)
 * 1.2.3-beta.1     alpha                1.3.0-alpha  (roll over)
 * 1.2.3-beta       beta                 1.2.3-beta.1
 * 1.2.3-beta.1     beta                 1.2.3-beta.2
 * 1.2.3            beta                 1.3.0-beta
 * </pre>
 */
public final class NextPreRelease extends VersionComposition
{
    public NextPreRelease(Version delegate)
    {
        this(delegate, NextMinor::new, new Backed<>(delegate.preRelease(), "alpha").value());
    }


    public NextPreRelease(Version delegate, Function<Version, Version> carryOverFunction)
    {
        this(delegate, carryOverFunction, new Backed<>(delegate.preRelease(), "alpha").value());
    }


    public NextPreRelease(Version delegate, String defaultPreRelease)
    {
        this(delegate, NextMinor::new, defaultPreRelease);
    }


    public NextPreRelease(Version delegate, Function<Version, Version> carryOverFunction, String defaultPreRelease)
    {
        this(delegate, carryOverFunction, new PreReleaseSuccessor(delegate.preRelease(), defaultPreRelease));
    }


    private NextPreRelease(Version delegate, Function<Version, Version> carryOverFunction, Optional<String> newPreRelease)
    {
        super(new PreRelease(PRERELEASE_COMPARATOR.compare(delegate.preRelease(), newPreRelease) > 0 ?
            carryOverFunction.value(new Release(delegate)) : delegate, newPreRelease));
    }
}

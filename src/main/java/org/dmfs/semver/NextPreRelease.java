package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;
import org.dmfs.semver.prereleases.IncPreRelease;

import static org.dmfs.jems2.optional.Absent.absent;


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
 * 1.0.0-alpha      beta                 1.0.0-alpha.1
 * 1.0.0-alpha.1    beta                 1.0.0-alpha.2
 * 1.0.0-beta       alpha                1.0.0-beta.1
 * 1.0.0-beta.1     alpha                1.0.0-beta.2
 * 1.0.0-beta       beta                 1.0.0-beta.1
 * 1.0.0-beta.1     beta                 1.0.0-beta.2
 * 1.0.0            beta                 1.1.0-beta
 * 1.2.0-alpha      beta                 1.2.0-alpha.1
 * 1.2.0-alpha.1    beta                 1.2.0-alpha.2
 * 1.2.0-beta       alpha                1.2.0-beta.1
 * 1.2.0-beta.1     alpha                1.2.0-beta.2
 * 1.2.0-beta       beta                 1.2.0-beta.1
 * 1.2.0-beta.1     beta                 1.2.0-beta.2
 * 1.2.0            beta                 1.3.0-beta
 * 1.2.3-alpha      beta                 1.2.3-alpha.1
 * 1.2.3-alpha.1    beta                 1.2.3-alpha.2
 * 1.2.3-beta       alpha                1.2.3-beta.1
 * 1.2.3-beta.1     alpha                1.2.3-beta.2
 * 1.2.3-beta       beta                 1.2.3-beta.1
 * 1.2.3-beta.1     beta                 1.2.3-beta.2
 * 1.2.3            beta                 1.3.0-beta
 * </pre>
 */
public final class NextPreRelease extends VersionComposition
{
    public NextPreRelease(Version delegate)
    {
        this(delegate, "alpha", absent());
    }


    public NextPreRelease(Version delegate, String defaultPreRelease)
    {
        this(delegate, defaultPreRelease, absent());
    }


    public NextPreRelease(Version delegate, String defaultPreRelease, String build)
    {
        this(delegate, defaultPreRelease, new Present<>(build));
    }


    private NextPreRelease(Version delegate, String defaultPreRelease, Optional<String> build)
    {
        super(delegate.preRelease().isPresent()
            ? new PreRelease(delegate, new IncPreRelease(delegate.preRelease()), build)
            : new PreRelease(new NextMinor(delegate), defaultPreRelease, build));
    }
}

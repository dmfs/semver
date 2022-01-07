package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;

import static org.dmfs.jems2.optional.Absent.absent;


/**
 * The next minor version.
 *
 * <h2>Examples</h2>
 * <p>
 * For a given version this will result in
 *
 * <pre>
 * current version    Next Minor Release
 * 1.0.0-alpha        1.0.0
 * 1.0.0              1.1.0
 * 1.2.0-alpha        1.2.0
 * 1.2.0              1.3.0
 * 1.2.3-alpha        1.3.0
 * 1.2.3              1.3.0
 * </pre>
 */
public final class NextMinor extends VersionComposition
{
    public NextMinor(Version delegate)
    {
        this(delegate, absent());
    }


    public NextMinor(Version delegate, String build)
    {
        this(delegate, new Present<>(build));
    }


    private NextMinor(Version delegate, Optional<String> build)
    {
        super(delegate.preRelease().isPresent() && delegate.patch() == 0
            ? new Release(delegate, build)
            : new Release(delegate.major(), delegate.minor() + 1, 0, build));
    }

}

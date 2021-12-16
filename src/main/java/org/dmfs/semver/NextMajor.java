package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;

import static org.dmfs.jems2.optional.Absent.absent;


/**
 * The next major version.
 *
 * <h2>Examples</h2>
 * <p>
 * For a given version this will result in
 *
 * <pre>
 * current version    Next Major Release
 * 1.0.0-alpha        1.0.0
 * 1.0.0              2.0.0
 * 1.2.0-alpha        2.0.0
 * 1.2.0              2.0.0
 * 1.2.3-alpha        2.0.0
 * 1.2.3              2.0.0
 * </pre>
 */
public final class NextMajor extends VersionComposition
{
    public NextMajor(Version delegate)
    {
        this(delegate, absent());
    }


    public NextMajor(Version delegate, String build)
    {
        this(delegate, new Present<>(build));
    }


    private NextMajor(Version delegate, Optional<String> build)
    {
        super(delegate.preRelease().isPresent() && delegate.minor() == 0 && delegate.patch() == 0
            ? new Release(delegate, build)
            : new Release(delegate.major() + 1, 0, 0, build));
    }
}

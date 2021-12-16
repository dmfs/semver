package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;

import static org.dmfs.jems2.optional.Absent.absent;


/**
 * The next patch version.
 *
 * <h2>Examples</h2>
 * <p>
 * For a given version this will result in
 *
 * <pre>
 * current version    Next Major Release
 * 1.0.0-alpha        1.0.0
 * 1.0.0              1.0.1
 * 1.2.0-alpha        1.2.0
 * 1.2.0              1.2.1
 * 1.2.3-alpha        1.2.3
 * 1.2.3              1.2.4
 * </pre>
 */
public final class NextPatch extends VersionComposition
{
    public NextPatch(Version delegate)
    {
        this(delegate, absent());
    }


    public NextPatch(Version delegate, String build)
    {
        this(delegate, new Present<>(build));
    }


    private NextPatch(Version delegate, Optional<String> build)
    {
        super(delegate.preRelease().isPresent()
            ? new Release(delegate, build)
            : new Release(delegate.major(), delegate.minor(), delegate.patch() + 1, build));
    }
}

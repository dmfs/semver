package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;

import static org.dmfs.jems2.optional.Absent.absent;


/**
 * A pre-release of the next major version.
 *
 * <h2>Examples</h2>
 * <p>
 * For a given version and pre-release this will result in
 *
 * <pre>
 * current version    pre-release     Major pre-release
 * 1.0.0-alpha        beta            1.0.0-beta
 * 1.0.0              beta            2.0.0-beta
 * 1.2.0-alpha        beta            2.0.0-beta
 * 1.2.0              beta            2.0.0-beta
 * 1.2.3-alpha        beta            2.0.0-beta
 * 1.2.3              beta            2.0.0-beta
 * </pre>
 */
public final class MajorPreRelease extends VersionComposition
{
    public MajorPreRelease(Version delegate, String preRelease)
    {
        this(delegate, preRelease, absent());
    }


    public MajorPreRelease(Version delegate, String preRelease, String build)
    {
        this(delegate, preRelease, new Present<>(build));
    }


    private MajorPreRelease(Version delegate, String preRelease, Optional<String> build)
    {
        super(new PreRelease(new NextMajor(delegate), preRelease, build));
    }
}

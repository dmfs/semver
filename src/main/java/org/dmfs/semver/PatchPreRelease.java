package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;

import static org.dmfs.jems2.optional.Absent.absent;


/**
 * A pre-release of the next patch version.
 *
 * <h2>Examples</h2>
 * <p>
 * For a given version and pre-release this will result in
 *
 * <pre>
 * current version    pre-release     Major pre-release
 * 1.0.0-alpha        beta            1.0.0-beta
 * 1.0.0              beta            1.0.1-beta
 * 1.2.0-alpha        beta            1.2.0-beta
 * 1.2.0              beta            1.2.1-beta
 * 1.2.3-alpha        beta            1.2.3-beta
 * 1.2.3              beta            1.2.4-beta
 * </pre>
 */
public final class PatchPreRelease extends VersionComposition
{
    public PatchPreRelease(Version delegate, String preRelease)
    {
        this(delegate, preRelease, absent());
    }


    public PatchPreRelease(Version delegate, String preRelease, String build)
    {
        this(delegate, preRelease, new Present<>(build));
    }


    private PatchPreRelease(Version delegate, String preRelease, Optional<String> build)
    {
        super(new PreRelease(new NextPatch(delegate), preRelease, build));
    }
}

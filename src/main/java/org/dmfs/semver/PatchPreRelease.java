package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.comparator.OptionalComparator;
import org.dmfs.jems2.optional.Present;
import org.dmfs.semver.comparators.PreReleaseComparator;

import static org.dmfs.jems2.optional.Absent.absent;


/**
 * A pre-release of the next patch version.
 *
 * <h2>Examples</h2>
 * <p>
 * For a given version and pre-release this will result in
 *
 * <pre>
 * current version    pre-release     Patch pre-release
 * 1.0.0-alpha        beta            1.0.0-beta
 * 1.0.0-beta         alpha           1.0.1-alpha (patch version rolls over because 1.0.0-alpha would be &lt; 1.0.0-beta)
 * 1.0.0              beta            1.0.1-beta
 * 1.2.0-alpha        beta            1.2.0-beta
 * 1.2.0-beta         alpha           1.2.1-alpha (patch version rolls over because 1.2.0-alpha would be &lt; 1.2.0-beta)
 * 1.2.0              beta            1.2.1-beta
 * 1.2.3-alpha        beta            1.2.3-beta
 * 1.2.3-beta         alpha           1.2.4-alpha (patch version rolls over because 1.2.3-alpha would be &lt; 1.2.3-beta)
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
        super(new PreRelease(
            new OptionalComparator<>(new PreReleaseComparator()).compare(delegate.preRelease(), new Present<>(preRelease)) < 0
                ? new NextPatch(delegate)
                : new NextPatch(new NextPatch(delegate)), preRelease, build));
    }
}

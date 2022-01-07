package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.comparator.OptionalComparator;
import org.dmfs.jems2.optional.Present;
import org.dmfs.semver.comparators.PreReleaseComparator;

import static org.dmfs.jems2.optional.Absent.absent;


/**
 * A pre-release of the next minor version.
 *
 * <h2>Examples</h2>
 * <p>
 * For a given version and pre-release this will result in
 *
 * <pre>
 * current version    pre-release     Minor pre-release
 * 1.0.0-alpha        beta            1.0.0-beta
 * 1.0.0-beta         alpha           1.1.0-alpha (minor version rolls over, because 1.0.0-alpha would be < 1.0.0-beta)
 * 1.0.0              beta            1.1.0-beta
 * 1.2.0-alpha        beta            1.2.0-beta
 * 1.2.0-beta         alpha           1.3.0-alpha (minor version rolls over, because 1.2.0-alpha would be < 1.2.0-beta)
 * 1.2.0              beta            1.3.0-beta
 * 1.2.0              beta            1.3.0-beta
 * 1.2.3-alpha        beta            1.3.0-beta
 * 1.2.3-beta         alpha           1.3.0-alpha
 * 1.2.3              beta            1.3.0-beta
 * 1.2.3              beta            1.3.0-beta
 * </pre>
 */
public final class MinorPreRelease extends VersionComposition
{
    public MinorPreRelease(Version delegate, String preRelease)
    {
        this(delegate, preRelease, absent());
    }


    public MinorPreRelease(Version delegate, String preRelease, String build)
    {
        this(delegate, preRelease, new Present<>(build));
    }


    private MinorPreRelease(Version delegate, String preRelease, Optional<String> build)
    {
        super(new PreRelease(
            new OptionalComparator<>(new PreReleaseComparator()).compare(delegate.preRelease(), new Present<>(preRelease)) < 0 || delegate.patch() != 0
                ? new NextMinor(delegate)
                : new NextMinor(new NextMinor(delegate)), preRelease, build));
    }
}

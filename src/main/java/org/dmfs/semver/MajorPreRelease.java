package org.dmfs.semver;

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
 * 1.0.0-beta         alpha           2.0.0-alpha (major version rolls over because 1.0.0-alpha would be &lt; 1.0.0-beta)
 * 1.0.0              beta            2.0.0-beta
 * 1.0.1-alpha        beta            2.0.0-beta
 * 1.0.1-beta         alpha           2.0.0-alpha
 * 1.0.1              beta            2.0.0-beta
 * 1.2.0-alpha        beta            2.0.0-beta
 * 1.2.0-beta         alpha           2.0.0-alpha
 * 1.2.0              beta            2.0.0-beta
 * 1.2.3-alpha        beta            2.0.0-beta
 * 1.2.3-beta         alpha           2.0.0-alpha
 * 1.2.3              beta            2.0.0-beta
 * </pre>
 */
public final class MajorPreRelease extends VersionComposition
{
    public MajorPreRelease(Version delegate, String preRelease)
    {
        this(preRelease, new NextPreRelease(delegate, NextMajor::new, preRelease));
    }


    private MajorPreRelease(String preRelease, Version delegate)
    {
        super(delegate.minor() == 0 && delegate.patch() == 0 ? delegate : new PreRelease(new NextMajor(delegate), preRelease));
    }

}

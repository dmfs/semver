package org.dmfs.semver;

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
 * 1.0.0-beta         alpha           1.1.0-alpha (minor version rolls over, because 1.0.0-alpha would be &lt; 1.0.0-beta)
 * 1.0.0              beta            1.1.0-beta
 * 1.2.0-alpha        beta            1.2.0-beta
 * 1.2.0-beta         alpha           1.3.0-alpha (minor version rolls over, because 1.2.0-alpha would be &lt; 1.2.0-beta)
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
    public MinorPreRelease(Version delegate)
    {
        this(delegate, "alpha");
    }


    public MinorPreRelease(Version delegate, String preRelease)
    {
        this(preRelease, new NextPreRelease(delegate, NextMinor::new, preRelease));
    }


    private MinorPreRelease(String preRelease, Version delegate)
    {
        super(delegate.patch() == 0 ? delegate : new PreRelease(new NextMinor(delegate), preRelease));
    }
}

package org.dmfs.semver;

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
        super(new NextPreRelease(delegate, NextPatch::new, preRelease));
    }
}

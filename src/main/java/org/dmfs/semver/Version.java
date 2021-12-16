package org.dmfs.semver;

import org.dmfs.jems2.Optional;
import org.dmfs.srcless.annotations.composable.Composable;


/**
 * A semantic version as per version 2.0.0.
 * <p>
 * see <a href="https://semver.org/spec/v2.0.0.html">https://semver.org/spec/v2.0.0.html</a>
 */
@Composable
public interface Version
{
    /**
     * The major version.
     */
    int major();

    /**
     * The minor version.
     */
    int minor();

    /**
     * The patch version.
     */
    int patch();

    /**
     * The {@link Optional} pre-release identifier.
     */
    Optional<String> preRelease();

    /**
     * The {@link Optional} build identifier.
     */
    Optional<String> build();
}

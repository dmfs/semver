package org.dmfs.semver.prereleases;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.Single;
import org.dmfs.jems2.single.Frozen;

import java.util.regex.Pattern;


/**
 * The successor pre-release of a given pre-release version. The result has the same prefix as the given base version, but it might be followed
 * by an integer larger than that. If the base of the give pre-release version is already greater than the given base version, the result
 * is the base version.
 * The caller should detect this case by comparing the old pre-release version to the new one, incrementing the major,
 * minor or patch version when the new pre-release is smaller than the old one.
 *
 * <h2>Examples</h2>
 *
 * <pre>
 * delegate     base      result
 *
 * &lt;absent&gt;     alpha     alpha        (&lt;absent&gt; &gt; alpha -&gt; new release version)
 * &lt;absent&gt;     alpha.1   alpha.1      (&lt;absent&gt; &gt; alpha.1 -&gt; new release version)
 *
 * 1            alpha    alpha
 * 2            alpha.1  alpha.1
 *
 * alpha        alpha     alpha.1
 * alpha.1      alpha.1   alpha.2
 * alpha.2      alpha.1   alpha.3
 * alpha.2      alpha.5   alpha.5
 *
 * alpha.1.xyz  alpha     alpha.2
 * alpha.1.xyz  alpha.1   alpha.2
 * alpha.2.xyz  alpha.1   alpha.3
 * alpha.2.xyz  alpha.5   alpha.5
 *
 * alpha.xyz    alpha     alpha         (alpha.xyz &gt; alpha -&gt; new release version)
 * alpha.xyz    alpha.1   alpha.1       (alpha.xyz &gt; alpha.1 -&gt; new release version)
 * alpha.xyz    alpha.5   alpha.5       (alpha.xyz &gt; alpha.5 -&gt; new release version)
 *
 * beta         alpha     alpha         (beta &gt; alpha -&gt; new release version)
 * beta         alpha.1   alpha.1       (beta &gt; alpha.1 -&gt; new release version)
 * beta         alpha.5   alpha.5       (beta &gt; alpha.5 -&gt; new release version)
 * </pre>
 */
public final class PreReleaseSuccessor implements Optional<String>
{
    private static final Pattern NUMERIC = Pattern.compile("\\d+");
    private final Optional<String> mDelegate;
    private final String mBase;
    private final Single<Integer> mBaseVersion;
    private final Single<String> mBaseBase;


    public PreReleaseSuccessor(Optional<String> delegate, String base)
    {
        this(delegate, base, new Frozen<>(() -> {
            String[] baseParts = base.split("\\.");
            return baseParts[baseParts.length - 1];
        }));
    }


    private PreReleaseSuccessor(Optional<String> delegate, String base, Single<String> lastBaseSegment)
    {
        this(delegate,
            base,
            new Frozen<>(
                () -> NUMERIC.matcher(lastBaseSegment.value()).matches() ? base.substring(0, base.length() - lastBaseSegment.value().length()) : base + "."),
            new Frozen<>(() -> NUMERIC.matcher(lastBaseSegment.value()).matches() ? Integer.parseInt(lastBaseSegment.value()) : 1));
    }


    private PreReleaseSuccessor(Optional<String> delegate, String base, Single<String> baseBase, Single<Integer> baseVersion)
    {
        mDelegate = delegate;
        mBase = base;
        mBaseBase = baseBase;
        mBaseVersion = baseVersion;
    }


    @Override
    public boolean isPresent()
    {
        return true;
    }


    @Override
    public String value()
    {
        if (mDelegate.isPresent())
        {
            String baseBase = mBaseBase.value();
            String value = mDelegate.value();
            if (value.length() + 1 == baseBase.length() && baseBase.startsWith(value))
            {
                return baseBase + mBaseVersion.value();
            }
            else if (value.startsWith(baseBase))
            {
                String nextSegment = value.substring(baseBase.length()).split("\\.")[0];
                if (NUMERIC.matcher(nextSegment).matches())
                {
                    return baseBase + (Math.max(mBaseVersion.value(), Integer.parseInt(nextSegment) + 1));
                }
                else
                {
                    return mBase;
                }
            }
            else
            {
                return mBase;
            }
        }
        else
        {
            return mBase;
        }
    }
}

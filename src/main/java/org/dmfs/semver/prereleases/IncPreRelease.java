package org.dmfs.semver.prereleases;

import org.dmfs.jems2.Optional;

import java.util.regex.Pattern;


public final class IncPreRelease implements Optional<String>
{
    private static final Pattern NUMERIC = Pattern.compile("\\d+");
    private final Optional<String> mDelegate;


    public IncPreRelease(Optional<String> delegate)
    {
        mDelegate = delegate;
    }


    @Override
    public boolean isPresent()
    {
        return mDelegate.isPresent();
    }


    @Override
    public String value()
    {
        String value = mDelegate.value();
        String[] parts = value.split("\\.");
        if (NUMERIC.matcher(parts[parts.length - 1]).matches())
        {
            parts[parts.length - 1] = Integer.toString(Integer.parseInt(parts[parts.length - 1]) + 1);
            return String.join(".", parts);
        }
        else
        {
            return value + ".1";
        }
    }
}

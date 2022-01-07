package org.dmfs.semver;

import org.dmfs.jems2.optional.NullSafe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;


public final class StrictParser implements VersionParser
{
    private static final Pattern SEMVER_PATTERN = Pattern.compile(
        "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$");


    @Override
    public Version parse(CharSequence versionString)
    {
        Matcher matcher = SEMVER_PATTERN.matcher(versionString);
        if (!matcher.matches())
        {
            throw new IllegalArgumentException(String.format("%s is not a valid Semantic Version String.", versionString));
        }
        return new StructuredVersion(parseInt(matcher.group(1)), parseInt(matcher.group(2)), parseInt(matcher.group(3)),
            new NullSafe<>(matcher.group(4)), new NullSafe<>(matcher.group(4)));
    }
}

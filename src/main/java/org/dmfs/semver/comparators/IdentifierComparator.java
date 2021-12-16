package org.dmfs.semver.comparators;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.regex.Pattern;


/**
 * Compares two pre-release identifiers by the following rules:
 * <p>
 * 1. Identifiers consisting of only digits are compared numerically.
 * <p>
 * 2. Identifiers with letters or hyphens are compared lexically in ASCII sort order.
 * <p>
 * 3. Numeric identifiers always have lower precedence than non-numeric identifiers.
 */
public final class IdentifierComparator implements Comparator<CharSequence>
{
    private final Pattern NUMERICAL = Pattern.compile("\\d+");


    @Override
    public int compare(CharSequence left, CharSequence right)
    {
        if (NUMERICAL.matcher(left).matches())
        {
            if (NUMERICAL.matcher(right).matches())
            {
                return new BigInteger(left.toString()).compareTo(new BigInteger(right.toString()));
            }
            return -1;
        }

        if (NUMERICAL.matcher(right).matches())
        {
            return 1;
        }
        return left.toString().compareTo(right.toString());
    }
}

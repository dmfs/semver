package org.dmfs.semver.comparators;

import org.dmfs.jems2.comparator.By;
import org.dmfs.jems2.comparator.DelegatingComparator;
import org.dmfs.jems2.comparator.IterableComparator;
import org.dmfs.jems2.comparator.OptionalComparator;
import org.dmfs.jems2.iterable.Seq;

import java.util.Comparator;
import java.util.regex.Pattern;


/**
 * {@link Comparator} of pre-release {@link CharSequence}s.
 * <p>
 * This compares the dot separated segments of two pre-releases until one is found to be greater than the other or both are found to be equal.
 */
public final class PreReleaseComparator extends DelegatingComparator<CharSequence>
{
    private final static Pattern SEPARATOR = Pattern.compile("\\.");


    public PreReleaseComparator()
    {
        super(new By<>(i -> new Seq<>(SEPARATOR.split(i)), new IterableComparator<>(new OptionalComparator<>(new IdentifierComparator()))));
    }
}

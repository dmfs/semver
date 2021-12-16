package org.dmfs.semver.comparators;

import org.dmfs.jems2.comparator.By;
import org.dmfs.jems2.comparator.DelegatingComparator;
import org.dmfs.jems2.comparator.IterableComparator;
import org.dmfs.jems2.comparator.OptionalComparator;
import org.dmfs.jems2.iterable.Seq;

import java.util.regex.Pattern;


public final class PreReleaseComparator extends DelegatingComparator<CharSequence>
{
    private final static Pattern SEPARATOR = Pattern.compile("\\.");


    public PreReleaseComparator()
    {
        super(new By<>(i -> new Seq<>(SEPARATOR.split(i)), new IterableComparator<>(new OptionalComparator<>(new IdentifierComparator()))));
    }
}

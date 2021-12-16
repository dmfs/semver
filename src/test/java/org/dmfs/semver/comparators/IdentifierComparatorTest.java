package org.dmfs.semver.comparators;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class IdentifierComparatorTest
{

    @Test
    void testNumerical()
    {
        assertThat(new IdentifierComparator().compare("12", "12"), is(equalTo(0)));
        assertThat(new IdentifierComparator().compare("12", "13"), is(lessThan(0)));
        assertThat(new IdentifierComparator().compare("13", "12"), is(greaterThan(0)));
        assertThat(new IdentifierComparator().compare("13", "123"), is(lessThan(0)));
        assertThat(new IdentifierComparator().compare("123", "13"), is(greaterThan(0)));
    }


    @Test
    void testMixed()
    {
        assertThat(new IdentifierComparator().compare("12", "abc"), is(lessThan(0)));
        assertThat(new IdentifierComparator().compare("abc", "12"), is(greaterThan(0)));
        assertThat(new IdentifierComparator().compare("12", "13a"), is(lessThan(0)));
        assertThat(new IdentifierComparator().compare("13", "12a"), is(lessThan(0)));
    }


    @Test
    void testNonNumerical()
    {
        assertThat(new IdentifierComparator().compare("abc", "abc"), is(equalTo(0)));
        assertThat(new IdentifierComparator().compare("abc", "abd"), is(lessThan(0)));
        assertThat(new IdentifierComparator().compare("abd", "abc"), is(greaterThan(0)));
        assertThat(new IdentifierComparator().compare("abc", "abcd"), is(lessThan(0)));
        assertThat(new IdentifierComparator().compare("abcd", "abc"), is(greaterThan(0)));
    }
}
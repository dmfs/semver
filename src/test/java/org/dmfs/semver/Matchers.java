package org.dmfs.semver;

import org.hamcrest.Matcher;

import static org.dmfs.jems2.hamcrest.matchers.LambdaMatcher.having;
import static org.dmfs.jems2.hamcrest.matchers.optional.AbsentMatcher.absent;
import static org.dmfs.jems2.hamcrest.matchers.optional.PresentMatcher.present;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;


public final class Matchers
{
    public static Matcher<Version> version(int major, int minor, int patch)
    {
        return allOf(having("major", Version::major, equalTo(major)),
            having("minor", Version::minor, equalTo(minor)),
            having("patch", Version::patch, equalTo(patch))
        );
    }


    public static Matcher<Version> release(int major, int minor, int patch)
    {
        return allOf(version(major, minor, patch), having("preRelease", Version::preRelease, absent()));
    }


    public static Matcher<Version> release(Matcher<? super Version> version)
    {
        return allOf(version, having("preRelease", Version::preRelease, absent()));
    }


    public static Matcher<Version> preRelease(Matcher<? super Version> version, String preRelease)
    {
        return allOf(version, having("preRelease", Version::preRelease, present(preRelease)));
    }


    public static Matcher<Version> buildMeta(String buildMeta)
    {
        return having("buildMeta", Version::build, present(buildMeta));
    }
}

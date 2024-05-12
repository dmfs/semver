package org.dmfs.semver;

import org.dmfs.jems2.optional.Absent;
import org.dmfs.jems2.optional.Present;
import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.semver.confidence.SemVer.*;
import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.core.quality.Grammar.is;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class WithBuildMetaTest
{
    Assertion add_build_meta_to_release = assertionThat(
        new WithBuildMeta(new Release(1, 2, 3), "123"),
        is(allOf(
            release(1, 2, 3),
            hasBuild("123"))));

    Assertion add_build_meta_to_pre_release = assertionThat(
        new WithBuildMeta(new PreRelease(new Release(3, 4, 5), "123"), "abc"),
        is(allOf(
            preRelease(3, 4, 5, "123"),
            hasBuild("abc"))));

    Assertion replace_build_meta_of_release = assertionThat(
        new WithBuildMeta(new StructuredVersion(1, 2, 3, new Absent<>(), new Present<>("build")), "123"),
        is(allOf(
            release(1, 2, 3),
            hasBuild("123"))));

    Assertion replace_build_meta_of_pre_release = assertionThat(
        new WithBuildMeta(new StructuredVersion(1, 2, 3, new Present<>("pre"), new Present<>("build")), "123"),
        is(allOf(
            preRelease(1, 2, 3, "pre"),
            hasBuild("123"))));
}
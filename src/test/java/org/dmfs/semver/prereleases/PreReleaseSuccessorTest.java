package org.dmfs.semver.prereleases;

import org.dmfs.jems2.optional.Absent;
import org.dmfs.jems2.optional.Present;
import org.saynotobugs.confidence.junit5.engine.Assertion;
import org.saynotobugs.confidence.junit5.engine.Confidence;

import static org.dmfs.jems2.confidence.Jems2.present;
import static org.saynotobugs.confidence.core.quality.Grammar.is;
import static org.saynotobugs.confidence.junit5.engine.ConfidenceEngine.assertionThat;


@Confidence
class PreReleaseSuccessorTest
{
    Assertion alpha_successor_of_release = assertionThat(
        new PreReleaseSuccessor(new Absent<>(), "alpha"), is(present("alpha")));
    Assertion alpha_1_successor_of_release = assertionThat(
        new PreReleaseSuccessor(new Absent<>(), "alpha.1"), is(present("alpha.1")));
    Assertion alpha_5_successor_of_release = assertionThat(
        new PreReleaseSuccessor(new Absent<>(), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1"), "alpha"), is(present("alpha")));
    Assertion alpha_1_successor_of_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1"), "alpha.1"), is(present("alpha.1")));
    Assertion alpha_5_successor_of_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1"), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_alp = assertionThat(
        new PreReleaseSuccessor(new Present<>("alp"), "alpha"), is(present("alpha")));
    Assertion alpha_1_successor_of_alp = assertionThat(
        new PreReleaseSuccessor(new Present<>("alp"), "alpha.1"), is(present("alpha.1")));
    Assertion alpha_5_successor_of_alp = assertionThat(
        new PreReleaseSuccessor(new Present<>("alp"), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_alphaxy = assertionThat(
        new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha"), is(present("alpha")));
    Assertion alpha_1_successor_of_alphaxy = assertionThat(
        new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.1"), is(present("alpha.1")));
    Assertion alpha_5_successor_of_alphaxy = assertionThat(
        new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_alpha123 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha123"), "alpha"), is(present("alpha")));
    Assertion alpha_1_successor_of_alpha123 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.1"), is(present("alpha.1")));
    Assertion alpha_5_successor_of_alpha123 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_alpha = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha"), "alpha"), is(present("alpha.1")));
    Assertion alpha_1_successor_of_alpha = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha"), "alpha.1"), is(present("alpha.1")));
    Assertion alpha_5_successor_of_alpha = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha"), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_alpha_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha"), is(present("alpha.2")));
    Assertion alpha_1_successor_of_alpha_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.1"), is(present("alpha.2")));
    Assertion alpha_5_successor_of_alpha_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_alpha_1_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha"), is(present("alpha.2")));
    Assertion alpha_1_successor_of_alpha_1_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.1"), is(present("alpha.2")));
    Assertion alpha_5_successor_of_alpha_1_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_alpha_10_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha"), is(present("alpha.11")));
    Assertion alpha_1_successor_of_alpha_10_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.1"), is(present("alpha.11")));
    Assertion alpha_5_successor_of_alpha_10_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.5"), is(present("alpha.11")));

    Assertion alpha_successor_of_alpha_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha"), is(present("alpha")));
    Assertion alpha_1_successor_of_alpha_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.1"), is(present("alpha.1")));
    Assertion alpha_5_successor_of_alpha_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_alpha_xyz_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha"), is(present("alpha")));
    Assertion alpha_1_successor_of_alpha_xyz_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.1"), is(present("alpha.1")));
    Assertion alpha_5_successor_of_alpha_xyz_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.5"), is(present("alpha.5")));

    Assertion alpha_successor_of_beta = assertionThat(
        new PreReleaseSuccessor(new Present<>("beta"), "alpha"), is(present("alpha")));
    Assertion alpha_1_successor_of_beta = assertionThat(
        new PreReleaseSuccessor(new Present<>("beta"), "alpha.1"), is(present("alpha.1")));
    Assertion alpha_5_successor_of_beta = assertionThat(
        new PreReleaseSuccessor(new Present<>("beta"), "alpha.5"), is(present("alpha.5")));


    Assertion alpha_1_xyz_successor_of_release = assertionThat(
        new PreReleaseSuccessor(new Absent<>(), "alpha.1.xyz"), is(present("alpha.1.xyz")));

    Assertion alpha_1_xyz_1_successor_of_release = assertionThat(
        new PreReleaseSuccessor(new Absent<>(), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_release = assertionThat(
        new PreReleaseSuccessor(new Absent<>(), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_alp = assertionThat(
        new PreReleaseSuccessor(new Present<>("alp"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_alp = assertionThat(
        new PreReleaseSuccessor(new Present<>("alp"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_alp = assertionThat(
        new PreReleaseSuccessor(new Present<>("alp"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_alphaxy = assertionThat(
        new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_alphaxy = assertionThat(
        new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_alphaxy = assertionThat(
        new PreReleaseSuccessor(new Present<>("alphaxy"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_alpha123 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_alpha123 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_alpha123 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha123"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_alpha = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_alpha = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_alpha = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_alpha_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_alpha_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_alpha_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_alpha_1_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.1.xyz"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_1_successor_of_alpha_1_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_alpha_1_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1.xyz"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_1_successor_of_alpha_1_xyz_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1.xyz.1"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.2")));
    Assertion alpha_1_xyz_5_successor_of_alpha_1_xyz_3 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1.xyz.3"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_alpha_10_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_alpha_10_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_alpha_10_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.10.xyz"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_alpha_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_alpha_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_alpha_xyz = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_alpha_xyz_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_alpha_xyz_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_alpha_xyz_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.xyz.1"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));

    Assertion alpha_1_xyz_successor_of_beta = assertionThat(
        new PreReleaseSuccessor(new Present<>("beta"), "alpha.1.xyz"), is(present("alpha.1.xyz")));
    Assertion alpha_1_xyz_1_successor_of_beta = assertionThat(
        new PreReleaseSuccessor(new Present<>("beta"), "alpha.1.xyz.1"), is(present("alpha.1.xyz.1")));
    Assertion alpha_1_xyz_5_successor_of_beta = assertionThat(
        new PreReleaseSuccessor(new Present<>("beta"), "alpha.1.xyz.5"), is(present("alpha.1.xyz.5")));


    Assertion _0_successor_of_release = assertionThat(
        new PreReleaseSuccessor(new Absent<>(), "0"), is(present("0")));
    Assertion _1_successor_of_release = assertionThat(
        new PreReleaseSuccessor(new Absent<>(), "1"), is(present("1")));
    Assertion _5_successor_of_release = assertionThat(
        new PreReleaseSuccessor(new Absent<>(), "5"), is(present("5")));

    Assertion _0_successor_of_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1"), "0"), is(present("2")));
    Assertion _1_successor_of_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1"), "1"), is(present("2")));
    Assertion _5_successor_of_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1"), "5"), is(present("5")));

    Assertion _0_successor_of_1_3 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1.3"), "0"), is(present("2")));
    Assertion _1_successor_of_1_3 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1.3"), "1"), is(present("2")));
    Assertion _5_successor_of_1_3 = assertionThat(
        new PreReleaseSuccessor(new Present<>("1.3"), "5"), is(present("5")));

    Assertion _0_successor_of_1_a = assertionThat(
        new PreReleaseSuccessor(new Present<>("1.a"), "0"), is(present("2")));
    Assertion _1_successor_of_1_a = assertionThat(
        new PreReleaseSuccessor(new Present<>("1.a"), "1"), is(present("2")));
    Assertion _5_successor_of_1_a = assertionThat(
        new PreReleaseSuccessor(new Present<>("1.a"), "5"), is(present("5")));

    Assertion _0_successor_of_alpha = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha"), "0"), is(present("0")));
    Assertion _1_successor_of_alpha = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha"), "1"), is(present("1")));
    Assertion _5_successor_of_alpha = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha"), "5"), is(present("5")));

    Assertion _0_successor_of_alpha_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1"), "0"), is(present("0")));
    Assertion _1_successor_of_alpha_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1"), "1"), is(present("1")));
    Assertion _5_successor_of_alpha_1 = assertionThat(
        new PreReleaseSuccessor(new Present<>("alpha.1"), "5"), is(present("5")));
}
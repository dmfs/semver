package org.dmfs.semver;

import org.dmfs.jems2.charsequence.DelegatingCharSequence;
import org.dmfs.jems2.optional.Mapped;
import org.dmfs.jems2.single.Backed;

import java.util.Locale;


public final class VersionSequence extends DelegatingCharSequence
{
    public VersionSequence(Version version)
    {
        super(String.format(Locale.ENGLISH, "%d.%d.%d%s%s",
            version.major(),
            version.minor(),
            version.patch(),
            new Backed<>(new Mapped<>(pre -> "-" + pre, version.preRelease()), "").value(),
            new Backed<>(new Mapped<>(pre -> "+" + pre, version.build()), "").value()));
    }
}

package ro.abarcan.httpusers.user.model;

import lombok.Builder;

@Builder
public record Company(String name, String catchPhrase, String bs) {
}


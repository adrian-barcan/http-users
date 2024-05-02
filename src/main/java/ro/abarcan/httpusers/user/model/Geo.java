package ro.abarcan.httpusers.user.model;

import lombok.Builder;

@Builder
public record Geo(
        String lat,
        String lng
) {
}


package ro.abarcan.httpusers.user.model;

import lombok.Builder;

@Builder
public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo
) {
}


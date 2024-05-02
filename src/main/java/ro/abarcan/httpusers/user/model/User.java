package ro.abarcan.httpusers.user.model;

import lombok.Builder;

@Builder
public record User(
        int id,
        String name,
        String username,
        String email,
        Address address,
        String phone,
        String website,
        Company company
) {
}

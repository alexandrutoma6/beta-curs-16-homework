package org.beta.curs16.comework.model;

import lombok.Builder;

@Builder
public record Person(
        String firstName,
        String lastName,
        int age,
        String city
) {
}

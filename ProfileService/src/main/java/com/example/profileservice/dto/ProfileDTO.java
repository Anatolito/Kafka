package com.example.profileservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Data
public class ProfileDTO {
    @JsonProperty
    private int accountId;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
}

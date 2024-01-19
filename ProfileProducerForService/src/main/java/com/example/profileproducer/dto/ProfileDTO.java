package com.example.profileproducer.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProfileDTO implements AbstractDTO {
    private int accountId;
    private String firstName;
    private String lastName;
}

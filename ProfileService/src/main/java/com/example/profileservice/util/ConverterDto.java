package com.example.profileservice.util;

import com.example.profileservice.dto.ProfileDTO;
import com.example.profileservice.model.Profile;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConverterDto {
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    public ProfileDTO convertToProfile(String json) {
        try {
            return objectMapper.readValue(json, ProfileDTO.class);
        } catch (Exception e) {
            log.error("Не удалось конвертировать Json в объект ProfileDto {}",
                    e.getMessage());
        }
        return null;
    }

    public Profile fromDtoToProfile(ProfileDTO profileDTO) {
        return modelMapper.map(profileDTO, Profile.class);
    }

}

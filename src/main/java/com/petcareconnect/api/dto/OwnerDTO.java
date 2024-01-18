package com.petcareconnect.api.dto;

import com.petcareconnect.api.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerDTO {
    private String username;
    private String email;

    public static OwnerDTO fromEntity(Owner owner) {
        return new OwnerDTO(owner.getUsername(), owner.getEmail());
    }
}

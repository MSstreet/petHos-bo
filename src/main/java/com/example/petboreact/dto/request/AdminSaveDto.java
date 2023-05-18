package com.example.petboreact.dto.request;

import com.example.petboreact.entity.AdminEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminSaveDto {

    private Long idx;

    private String AdminId;

    private String AdminPw;

    private String AdminName;

    public AdminEntity toEntity(){
        return AdminEntity.builder()
                .idx(idx)
                .AdminId(AdminId)
                .AdminPw(AdminPw)
                .AdminName(AdminName)
                .build();

    }

}

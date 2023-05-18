package com.example.petboreact.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AdminEntity {

    private Long idx;

    private String AdminId;

    private String AdminPw;

    private String AdminName;
}

package com.example.petboreact.mapper;

import com.example.petboreact.entity.AdminEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminMapper {

    List<AdminEntity> getAdminList(HashMap<String, Object> paramMap);

    int getAdminTotalCount(HashMap<String,Object> paramMap);

    AdminEntity getAdminOne(Long idx);

    int insertAdmin(AdminEntity adminEntity);

    int updateAdmin(AdminEntity adminEntity);

    int deleteAdmin(Long idx);
}

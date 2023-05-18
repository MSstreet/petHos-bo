package com.example.petboreact.service;

import com.example.petboreact.dto.request.AdminSaveDto;
import com.example.petboreact.entity.AdminEntity;
import com.example.petboreact.mapper.AdminMapper;
import com.example.petboreact.util.Header;
import com.example.petboreact.util.Pagination;
import com.example.petboreact.util.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMapper adminMapper;

    public Header<List<AdminEntity>> getAdminList(int page, int size, Search search){

        HashMap<String, Object> paramMap = new HashMap<>();

        if (page <= 1) {    //페이지가 1 이하로 입력되면 0으로 고정,
            paramMap.put("page", 0);
        } else {            //페이지가 2 이상
            paramMap.put("page", (page - 1) * size);
        }
        paramMap.put("size", size);
        paramMap.put("sk", search.getSk());
        paramMap.put("sv", search.getSv());

        List<AdminEntity> boardList = adminMapper.getAdminList(paramMap);
        Pagination pagination = new Pagination(
                adminMapper.getAdminTotalCount(paramMap),
                page,
                size,
                10
        );

        return Header.OK(boardList, pagination);
    }

    public Header<AdminEntity> getAdminOne(Long idx) {
        return Header.OK(adminMapper.getAdminOne(idx));
    }

    public Header<AdminEntity> insertAdmin(AdminSaveDto adminSaveDto) {

        AdminEntity entity = adminSaveDto.toEntity();

        if (adminMapper.insertAdmin(entity) > 0) {
            return Header.OK(entity);
        } else {
            return Header.ERROR("ERROR");
        }
    }

    public Header<AdminEntity> updateAdmin(AdminSaveDto adminSaveDto) {
        AdminEntity entity = adminSaveDto.toEntity();
        if (adminMapper.updateAdmin(entity) > 0) {
            return Header.OK(entity);
        } else {
            return Header.ERROR("ERROR");
        }
    }

    public Header<String> deleteAdmin(Long idx) {
        if (adminMapper.deleteAdmin(idx) > 0) {
            return Header.OK();
        } else {
            return Header.ERROR("ERROR");
        }
    }
}

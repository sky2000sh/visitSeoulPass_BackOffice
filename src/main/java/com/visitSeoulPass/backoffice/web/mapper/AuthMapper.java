package com.visitSeoulPass.backoffice.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.visitSeoulPass.backoffice.web.vo.MemberVO;
import com.visitSeoulPass.backoffice.web.vo.PicVO;

@Mapper
public interface AuthMapper {

    List<MemberVO> getUserList();

    PicVO getLoginUser(String userId);

    int duplicateCheckToId(String userId);

    int duplicateCheckToEmail(String userEml);

}

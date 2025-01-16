package com.visitSeoulPass.backoffice.admin.auth.mapper;

import com.visitSeoulPass.backoffice.admin.vo.CodeVO;
import com.visitSeoulPass.backoffice.admin.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthMapper {
    List<MemberVO> getUserList();
    List<CodeVO> getBoardListByCategoty();
    int insertBoard(Map<String, Object> board);
    MemberVO getLoginUser(String id);
    int duplicateCheckToId(String userId);
    int duplicateCheckToEmail(String email);
    List<CodeVO> getCodeList(CodeVO code);
}

package com.visitSeoulPass.backoffice.repository;

import com.visitSeoulPass.backoffice.web.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MemberVO, Long> {
    Optional<MemberVO> findByUsername(String username);
    Optional<MemberVO> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}

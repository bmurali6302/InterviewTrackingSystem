package com.panelmemberservice.repository;

import com.panelmemberservice.entity.PanelMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanelMemberRepository extends JpaRepository<PanelMember,Long> {
}

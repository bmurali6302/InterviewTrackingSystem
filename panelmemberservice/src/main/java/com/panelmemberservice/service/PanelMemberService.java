package com.panelmemberservice.service;

import com.panelmemberservice.entity.PanelMember;
import org.springframework.stereotype.Service;

@Service
public interface PanelMemberService {
    public PanelMember addPanelMember(PanelMember panelMember);
}

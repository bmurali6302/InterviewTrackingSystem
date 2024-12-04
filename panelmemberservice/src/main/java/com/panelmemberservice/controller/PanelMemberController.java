package com.panelmemberservice.controller;

import com.panelmemberservice.entity.PanelMember;
import com.panelmemberservice.service.PanelMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/panelmembers")
public class PanelMemberController {
    private PanelMemberService panelMemberService;

    public PanelMemberController(PanelMemberService panelMemberService) {
        this.panelMemberService = panelMemberService;
    }
    @PostMapping("/addpanel")

    public ResponseEntity<PanelMember> addPanel(@RequestBody PanelMember panelMember){
        PanelMember panelMember1 = panelMemberService.addPanelMember(panelMember);
        return new ResponseEntity<>(panelMember1, HttpStatus.OK);
    }


}

package com.panelmemberservice.serviceimpl;

import com.panelmemberservice.client.EmployeeService;
import com.panelmemberservice.dto.EmployeeDto;
import com.panelmemberservice.entity.PanelMember;
import com.panelmemberservice.exception.EmployeeIdNotFound;
import com.panelmemberservice.exception.PanelTypeMisMatchException;
import com.panelmemberservice.repository.PanelMemberRepository;
import com.panelmemberservice.service.PanelMemberService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PanelMemberServiceImpl implements PanelMemberService {
    private PanelMemberRepository panelMemberRepository;
    private EmployeeService employeeService;

    public PanelMemberServiceImpl(PanelMemberRepository panelMemberRepository, EmployeeService employeeService) {
        this.panelMemberRepository = panelMemberRepository;
        this.employeeService = employeeService;
    }

    @Override
    public PanelMember addPanelMember(PanelMember panelMember) {
        try{
            ResponseEntity<EmployeeDto> employeeById = employeeService.getEmployeeById(panelMember.getEmployeeId());
            if((panelMember.getPanelType().equals("Tech")) || panelMember.getPanelType().equalsIgnoreCase("HR")){
                return panelMemberRepository.save(panelMember);
            }else{
                throw new PanelTypeMisMatchException("Panel Type should be either Tech or HR");
            }

        }catch (FeignException.NotFound e) {
            throw new EmployeeIdNotFound("Employee ID not found: " + panelMember.getEmployeeId());
        }
    }
}

package com.placeManage.placeManagement.controller;

import com.placeManage.placeManagement.dto.Placedto;
import com.placeManage.placeManagement.dto.VisitPlaceByUserDto;
import com.placeManage.placeManagement.entity.Ticket;
import com.placeManage.placeManagement.services.IAdminService;
import com.placeManage.placeManagement.services.IUserService;
import com.placeManage.placeManagement.services.IplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    IplaceService placeService;
    @Autowired
    IUserService userService;
    @Autowired
    IAdminService adminService;
    @GetMapping("/")
    public String general(){
        return "general api access to all";
    }
    @GetMapping("/user")
    @Secured({"ROLE_USER"})
    public String user(){
        return "only access to users";
    }
    @PostMapping("/registerplaces")
    @Secured({"ROLE_ADMIN"})
    public String addPlaces(@RequestBody Placedto placedto){
        if(placeService.registerPlace(placedto)){
            return "place register";
        }
        return "place not registered.";
    }
    @PostMapping("/visitPlace")
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public Ticket visitPlace(@RequestBody VisitPlaceByUserDto visitPlaceByUserDto){
        return userService.visitPlace(visitPlaceByUserDto);
    }

    @PostMapping("/processTicket/{ticket_id}")
    @Secured("ROLE_ADMIN")
    public String processTicket(@PathVariable long ticket_id){
        adminService.processTicket(ticket_id);
        return "done";
    }

}

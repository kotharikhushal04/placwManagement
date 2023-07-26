package com.placeManage.placeManagement.services;

import com.mysql.cj.xdevapi.TableImpl;
import com.placeManage.placeManagement.dto.LoginDto;
import com.placeManage.placeManagement.dto.RegisterDto;
import com.placeManage.placeManagement.dto.VisitPlaceByUserDto;
import com.placeManage.placeManagement.entity.Ticket;
import com.placeManage.placeManagement.entity.User;

public interface IUserService {
    public User registerUser(RegisterDto registerDto) throws Exception;
    public String loginUser(LoginDto loginDto) throws Exception;

    public Ticket visitPlace(VisitPlaceByUserDto visitPlaceByUserDto);
}

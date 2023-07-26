package com.placeManage.placeManagement.services;

import com.placeManage.placeManagement.dto.LoginDto;
import com.placeManage.placeManagement.dto.RegisterDto;
import com.placeManage.placeManagement.dto.VisitPlaceByUserDto;
import com.placeManage.placeManagement.entity.Place;
import com.placeManage.placeManagement.entity.Ticket;
import com.placeManage.placeManagement.entity.User;
import java.util.Date;
import com.placeManage.placeManagement.repository.AdminRepository;
import com.placeManage.placeManagement.repository.PlaceRepository;
import com.placeManage.placeManagement.repository.TicketRepository;
import com.placeManage.placeManagement.repository.UserRpository;
import com.placeManage.placeManagement.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

@Service
public class UserService implements IUserService{
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    UserRpository userRpository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtProvider jwtProvider;

    @Override
    public User registerUser(RegisterDto registerDto) throws Exception {
        boolean isExists = userRpository.existsByNameAndEmail(registerDto.getName(),registerDto.getEmail());

        if (isExists) {
            throw new Exception("User already exists.");
        }

        User user = new User(registerDto.getName()
                            ,registerDto.getEmail()
                            ,passwordEncoder.encode(registerDto.getPassword())
                            ,registerDto.getRole());
        userRpository.save(user);
        return user;
    }

    @Override
    public String loginUser(LoginDto loginDto) throws Exception {
        System.out.println(loginDto.getEmail() + "ggggggggggggggggggggg");
        User user =userRpository.findByEmail(loginDto.getEmail());

        System.out.println(user.getEmail()+ "ggggggggggggggggggggggggggggggggg");
        if(passwordEncoder.matches(loginDto.getPassword(),user.getPassword())){
            return  jwtProvider.generateToken(user.getEmail());
        }
        return "user not present first register user";
    }

    @Override
    public Ticket visitPlace(VisitPlaceByUserDto visitPlaceByUserDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

// Retrieve the user details from the authentication object
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

// Extract user data from the user details
        String username = userDetails.getUsername();
        User user =userRpository.findByEmail(username);
        Place place = placeRepository.findByName(visitPlaceByUserDto.getPlaceName());
        String uniqueId = UUID.randomUUID().toString();
        Date date = new Date();
        System.out.println(date);
        String ticketNo = place.getPrefix()+ "-"+uniqueId;
        System.out.println(place.getName() + "     " +user.getName());
        Ticket ticket= new Ticket(
                ticketNo,false,date.toString(),place,user);
        ticketRepository.save(ticket);
        place.setUnprocessedTickets(place.getUnprocessedTickets()+1);
        placeRepository.save(place);

        return ticket;
    }
}

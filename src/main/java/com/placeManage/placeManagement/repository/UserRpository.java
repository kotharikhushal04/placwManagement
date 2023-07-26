package com.placeManage.placeManagement.repository;

import com.placeManage.placeManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRpository extends JpaRepository<User,String> {
    Boolean existsByNameAndEmail(String name,String email);

    User findByEmail(String s);
}

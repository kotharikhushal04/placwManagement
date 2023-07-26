package com.placeManage.placeManagement.repository;

import com.placeManage.placeManagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}

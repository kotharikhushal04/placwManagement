package com.placeManage.placeManagement.repository;

import com.placeManage.placeManagement.dto.VisitPlaceByUserDto;
import com.placeManage.placeManagement.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,String> {
    Place findByName(String placeName);
}

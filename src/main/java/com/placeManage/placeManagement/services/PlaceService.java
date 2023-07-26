package com.placeManage.placeManagement.services;

import com.placeManage.placeManagement.dto.Placedto;
import com.placeManage.placeManagement.entity.Place;
import com.placeManage.placeManagement.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService implements IplaceService{
    @Autowired
    PlaceRepository placeRepository;

    @Override
    public boolean registerPlace(Placedto placedto) {
        Place place = new Place(placedto.getName(),placedto.getPrefix());
        placeRepository.save(place);
        return true;
    }
}

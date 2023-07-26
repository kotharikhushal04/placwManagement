package com.placeManage.placeManagement.dto;

public class VisitPlaceByUserDto {
    private String name;
    private String email;
    private String placeName;


    public VisitPlaceByUserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public String toString() {
        return "VisitPlaceByUserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", placeName='" + placeName + '\'' +
                '}';
    }



    public VisitPlaceByUserDto(String name, String email, String placeName) {
        this.name = name;
        this.email = email;
        this.placeName = placeName;

    }
}

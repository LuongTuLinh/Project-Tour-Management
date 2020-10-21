/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_DTO;

/**
 *
 * @author DELL
 */
public class Tour_DTO {
    private static String tourId;
    private static String tourName;
    private static String specification;
    private static String tourCategoryId;
    private static String price;
    private static String status;
    private static String createdAt;
    private static String lastModifiedAt;
    private static String tourDetails;

    public Tour_DTO() {
    }

    public static String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        Tour_DTO.tourId = tourId;
    }

    public static String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        Tour_DTO.tourName = tourName;
    }

    public static String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        Tour_DTO.specification = specification;
    }

    public static String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        Tour_DTO.price = price;
    }

    public static String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        Tour_DTO.status = status;
    }

    public static String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        Tour_DTO.createdAt = createdAt;
    }

    public static String getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(String lastModifiedAt) {
        Tour_DTO.lastModifiedAt = lastModifiedAt;
    }

    public static String getTourDetails() {
        return tourDetails;
    }

    public void setTourDetails(String tourDetails) {
        Tour_DTO.tourDetails = tourDetails;
    }

    public static String getTourCategoryId() {
        return tourCategoryId;
    }

    public static void setTourCategoryId(String tourCategoryId) {
        Tour_DTO.tourCategoryId = tourCategoryId;
    }
}

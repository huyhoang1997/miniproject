package com.example.miniproject;

public class Review {
    int reviewID;
    String date;
    String mealType;
    int mealCost;
    float overallRating;
    float serviceRating;
    float atmosphereRating;
    float foodRating;
    String comment;
    int estID;

    public Review(){}
    public Review(int reviewID,String date,String mealType,int mealCost,float overallRating,float serviceRating,float atmosphereRating,float foodRating,String comment,int estID){
        this.reviewID = reviewID;
        this.date = date;
        this.mealType = mealType;
        this.mealCost = mealCost;
        this.overallRating = overallRating;
        this.serviceRating = serviceRating;
        this.atmosphereRating = atmosphereRating;
        this.foodRating = foodRating;
        this.comment = comment;
        this.estID = estID;
    }
    public Review(String date,String mealType,int mealCost,float overallRating,float serviceRating,float atmosphereRating,float foodRating,String comment){
        this.date = date;
        this.mealType = mealType;
        this.mealCost = mealCost;
        this.overallRating = overallRating;
        this.serviceRating = serviceRating;
        this.atmosphereRating = atmosphereRating;
        this.foodRating = foodRating;
        this.comment = comment;
    }


    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public int getMealCost() {
        return mealCost;
    }

    public void setMealCost(int mealCost) {
        this.mealCost = mealCost;
    }

    public float getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(float overallRating) {
        this.overallRating = overallRating;
    }

    public float getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(float serviceRating) {
        this.serviceRating = serviceRating;
    }

    public float getAtmosphereRating() {
        return atmosphereRating;
    }

    public void setAtmosphereRating(float atmosphereRating) {
        this.atmosphereRating = atmosphereRating;
    }

    public float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(float foodRating) {
        this.foodRating = foodRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getEstID() {
        return estID;
    }

    public void setEstID(int estID) {
        this.estID = estID;
    }

    public String toString(){
        return date;
    }
}

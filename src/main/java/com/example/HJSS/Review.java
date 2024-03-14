package com.example.HJSS;

public class Review {
    private Learner learner;
    private int rating;

    public Review(Learner learner,int rating){
        this.learner = learner;
        this.rating = rating;
    }
    public Learner getLearner(){
        return learner;
    }
    public int getRating(){
        return  rating;
    }
}

package com.example.restaurantApp.bucket;

public enum  BucketName {

    PROFILE_IMAGE("kray-bucket");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}

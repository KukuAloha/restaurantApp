package com.example.restaurantApp.datastore;

import com.example.restaurantApp.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("7b997535-16ce-412a-bafb-e3a806bae031"), "andrew", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("29f2c65f-0753-42b2-af4e-2a4a4e5acece"), "antony", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}

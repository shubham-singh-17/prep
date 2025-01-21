package movie.booking.service;

import movie.booking.entity.User;

public class UserService {

    private final EntityService entityService;

    public UserService(EntityService entityService) {
        this.entityService = entityService;
    }

    public User createUser(String name, String mobileNumber) {
        User user = new User(name, mobileNumber);
        entityService.saveUser(user);

        return user;
    }
}

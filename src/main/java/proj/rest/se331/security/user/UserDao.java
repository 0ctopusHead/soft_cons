package proj.rest.se331.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}
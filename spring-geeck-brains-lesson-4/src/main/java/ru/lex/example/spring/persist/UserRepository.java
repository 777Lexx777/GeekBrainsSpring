package ru.lex.example.spring.persist;//package ru.geekbrains.persist;
//
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Repository
//public class UserRepository {
//
//    private Map<Long, User> userMap = new ConcurrentHashMap<>();
//
//    private AtomicLong identity = new AtomicLong(0);
//
//    @PostConstruct
//    public void init() {
//        this.insert(new User("user1"));
//        this.insert(new User("user2"));
//        this.insert(new User("user3"));
//    }
//
//    public List<User> findAll() {
//        return new ArrayList<>(userMap.values());
//    }
//
//    public User findById(long id) {
//        return userMap.get(id);
//    }
//
//    public void insert(User user) {
//        long id = identity.incrementAndGet();
//        System.out.println(id);
//        user.setId(id);
//        userMap.put(id, user);
//    }
//
//    public void update(User user) {
//        userMap.put(user.getId(), user);
//    }
//
//   // public void delete(long id) { userMap.remove(id); }
//
//    public void deleteUser(long id){ userMap.remove(userMap.remove(id)); }
//
//    public void saveUser(User user){ userMap.put(user.getId(), user); }
//}
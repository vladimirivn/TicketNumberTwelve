import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Vasya", 30);
        User user2 = new User("Kolya", 23);
        User user3 = new User("Vasya", 20);
        User user4 = new User("Kolya", 23);
        User user5 = new User("Kolya", 23);
        User user6 = new User("Kolya", 27);
        User user7 = new User("Olya", 30);

        List<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5, user6, user7));
//        List<User> userList = Stream.of(user1, user2, user3, user4, user5, user6, user7).collect(Collectors.toList());
        getFirstOldestUser(userList);
        getAllOldestUser(userList);

    }

    public static void getFirstOldestUser(List<User> users) {
        Set<User> userSet = new HashSet<>(users);
        List<User> userList = new ArrayList<>(userSet);
        userList.sort(Comparator.comparing(User::getAge).thenComparing(User::getName));
        System.out.println(userList.get(userList.size() - 1));
    }

    public static void getAllOldestUser(List<User> users) {
        Set<User> userSet = new HashSet<>(users);
        users.clear();
        users.addAll(userSet);
        users.sort(Comparator.comparing(User::getAge).thenComparing(User::getName));
//        Collections.sort(users, Comparator.comparing(User::getAge).thenComparing(User::getName));
        List<User> userList = new ArrayList<>();
        int oldestAge = users.get(users.size() - 1).getAge();
        for (User user : users) {
            if (user.getAge() == oldestAge) {
                userList.add(user);
            }
        }

        System.out.println(userList);
    }

}
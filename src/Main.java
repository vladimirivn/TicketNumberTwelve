import java.util.*;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Vasya", 30);
        User user2 = new User("Kolya", 23);
        User user3 = new User("Vasya", 20);
        User user4 = new User("Kolya", 23);
        User user5 = new User("Kolya", 23);
        User user6 = new User("Kolya", 27);
        User user7 = new User("Olya", 25);

        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
        System.out.println(getOldestUser(userList).toString());

    }

    public static User getOldestUser(List<User> users) {
        Set<User> uniqueUsers = new HashSet<>(users);
        List<User> userList = new ArrayList<>(uniqueUsers);
        userList.sort(Comparator.comparing(User::getAge).thenComparing(User::getName));
        return userList.get(userList.size() - 1);
    }

}
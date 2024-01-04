package kz.zhelezyaka.juja;

import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamSample {

    enum Role {
        ADMIN, USER, GUEST
    }

    @Getter
    static class User {
        private long id;
        private String name;
        private Role role;

        public User(long id, Role role, String name) {
            this.id = id;
            this.role = role;
            this.name = name;
        }

        @Override
        public String toString() {
            return "[" + id + "=" + name + "]";
        }
    }

    @Test
    void testSimpleStreamJava7() {
        Collection<User> users = getUsers();

        List<User> filtered = new LinkedList<>();
        for (User user : users) {
            if (user.getRole() == Role.USER) {
                filtered.add(user);
            }
        }

        Collections.sort(filtered, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Long.compare(o2.getId(), o1.getId());
            }
        });

        List<String> names = new LinkedList<>();
        for (User user : filtered) {
            names.add(user.getName());
        }

        assertEquals("[Oleg Smolnikov, Leonid Romanov, Danil Skryl, Vladimir Glinskikh]", names.toString());
    }

    @Test
    void testSimpleStreamJava8() {
        Collection<User> users = getUsers();
        List<String> names = users.stream()
                .filter(user -> user.getRole() == Role.USER)
                .sorted((o1, o2) -> Long.compare(o2.getId(), o1.getId()))
                .map(user -> user.getName())
                .collect(toList());
    }

    private static Collection<User> getUsers() {
        Collection<User> users = Arrays.asList(
                new User(1, Role.USER, "Vladimir Glinskikh"),
                new User(3, Role.USER, "Danil Skryl"),
                new User(4, Role.USER, "Leonid Romanov"),
                new User(2, Role.ADMIN, "Maxim Tsarikevich"),
                new User(6, Role.GUEST, "Aston Developer"),
                new User(9, Role.USER, "Oleg Smolnikov"),
                new User(11, Role.GUEST, "Danil Tokarev"),
                new User(11, Role.ADMIN, "Artem Kokotov")
        );
        return users;
    }
}

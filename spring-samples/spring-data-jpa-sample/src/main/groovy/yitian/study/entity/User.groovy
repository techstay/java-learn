package yitian.study.entity

import javax.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id
    @Column(unique = true, nullable = false)
    String username
    @Column(nullable = false)
    String nickname
    @Column
    String email
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Address address
    @Column
    LocalDate birthday
    @Column(nullable = false)
    LocalDateTime registerTime

    String toString() {
        "User(id:$id,username:$username,nickname:$nickname,email:$email,birthday:$birthday,registerTime:$registerTime)"
    }
}

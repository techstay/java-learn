package yitian.study.entity

import java.time.LocalDate
import java.time.LocalDateTime


interface UserWithoutAddress {
    int getId()

    String getUsername()

    String getNickname()

    LocalDate getBirthday()

    LocalDateTime getRegisterTime()

}

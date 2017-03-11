package yitian.study.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id
    @OneToOne
    User user
    @Column
    String country
    @Column
    String province
    @Column
    String city

    @Override
    String toString() {
        return "$country $province $city"
    }
}

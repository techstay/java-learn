package yitian.study.dao

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.QueryByExampleExecutor
import org.springframework.scheduling.annotation.Async
import yitian.study.entity.User
import yitian.study.entity.UserWithoutAddress

import java.util.concurrent.CompletableFuture

interface CommonUserRepository extends CrudRepository<User, Integer> {
    List<User> getByUsernameLike(String username)
}

interface PageableUserRepository extends PagingAndSortingRepository<User, Integer> {

    @Query
    List<User> findByNickname(String nickname)


    List<User> findTop3ByOrderByUsername()

    @Async
    CompletableFuture<List<User>> findTop5ByOrderByNickname()

    @Modifying
    @Query('update from User u set u.nickname=?1 where id=?2')
    int updateNickname(String nickname, int id)

    List<UserWithoutAddress> findBy()
}

interface ExampleRepository extends CrudRepository<User, Integer>, QueryByExampleExecutor<User> {

}
package yitian.study.test

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import yitian.study.dao.ArticleRepository
import yitian.study.dao.CommonUserRepository
import yitian.study.dao.ExampleRepository
import yitian.study.dao.PageableUserRepository
import yitian.study.entity.Address
import yitian.study.entity.Article
import yitian.study.entity.User
import yitian.study.entity.UserWithoutAddress

import java.time.LocalDateTime
import java.util.concurrent.CompletableFuture

import static org.assertj.core.api.Assertions.assertThat

@RunWith(SpringRunner)
@ContextConfiguration("classpath:data.xml")
class DaoTest {
    @Autowired
    CommonUserRepository commonUserRepository
    @Autowired
    PageableUserRepository pageableUserRepository
    @Autowired
    ExampleRepository exampleRepository
    @Autowired
    ArticleRepository articleRepository

    //向数据库添加数据时使用
    //@Test
    void addData() {
        (1..21).each {
            User user = new User(username: "user$it", nickname: "用户$it", email: "user$it@yitian.com", registerTime: LocalDateTime.now())
            Address address = new Address()
            address.country = '中国'
            address.province = '内蒙古自治区'
            address.city = "呼和浩特${it}号路"
            address.user = user
            user.address = address
            pageableUserRepository.save(user)
        }
    }

    @Test
    void testCrudRepository() {
        List<User> users = commonUserRepository.getByUsernameLike('%2')
        println(users)


    }

    @Test
    void testQueryMethods() {
        List<User> users = pageableUserRepository.findTop3ByOrderByUsername()
        println users
        assertThat(users.size()).isEqualTo(3)
    }

    @Test
    void testAsyncQueryMethods() {
        CompletableFuture<List<User>> future = pageableUserRepository.findTop5ByOrderByNickname()
        while (!future.done) {
        }
        List<User> users = future.get()
        assertThat(users.size()).isEqualTo(5)
    }

    @Test
    void testNamedQueries() {
        List<User> users = pageableUserRepository.findByNickname('用户2')
        println users
        assertThat(users.size()).isEqualTo(1)
    }

    @Test
    void testModifyingMethods() {
        int id = 3
        pageableUserRepository.updateNickname('3用户', id)
        User user = pageableUserRepository.findOne(id)
        println user

    }

    @Test
    void testProjection() {
        List<UserWithoutAddress> users = pageableUserRepository.findBy()
        users.each {
            println "id:$it.id,username:$it.username,nickname:$it.nickname,birthday:$it.birthday,registerTime:$it.registerTime"
        }
        assertThat(users).isNotNull()
    }

    @Test
    void testExamples() {
        User user = new User(nickname: '2')

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withIgnorePaths('id')
        Example<User> example = Example.of(user, matcher)
        Iterable<User> users = exampleRepository.findAll(example)
        users.each {
            println it
        }
    }

    @Test
    void testBasicAuditAnnotations() {
        Article article = new Article(title: '这是标题', content: '这是内容')
        article = articleRepository.save(article)
        println article
    }

    @Test
    void testPagingRepository() {
        int countPerPage = 5
        long totalCount = pageableUserRepository.count()
        int totalPage = totalCount % 5 == 0L ? totalCount / 5 : totalCount / 5 + 1
        (0..totalPage - 1).each {
            Page<User> users = pageableUserRepository.findAll(new PageRequest(it, countPerPage))
            println "第${it}页数据，共${users.totalPages}页"
            users.each {
                println it
            }
        }

    }
}

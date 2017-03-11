package yitian.study.dao

import org.springframework.data.repository.CrudRepository
import yitian.study.entity.Article


interface ArticleRepository extends CrudRepository<Article,Integer>{
}

package yitian.study.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener)
class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id
    @Column
    String title
    @Column
    String content
    @Column
    @CreatedDate
    LocalDateTime createdTime
    @Column
    @LastModifiedDate
    LocalDateTime lastModifiedTime

    @Override
    String toString() {
        final StringBuilder sb = new StringBuilder("Article{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", createdTime=").append(createdTime);
        sb.append(", lastModifiedTime=").append(lastModifiedTime);
        sb.append('}');
        return sb.toString();
    }
}

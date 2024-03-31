package inflern.study.userservice.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", updatable = false, nullable = false, unique = true)
    private String userId;

    @Column(name = "email", length = 50, updatable = false, nullable = false, unique = true)
    private String email;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "encrypted_pwd", nullable = false)
    private String encryptedPwd;

    @Column(name = "create_at", updatable = false, nullable = false)
    private LocalDateTime createAt;

    @Builder(access = AccessLevel.PRIVATE)
    private User(String userId, String email, String name, String encryptedPwd, LocalDateTime createAt) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.encryptedPwd = encryptedPwd;
        this.createAt = createAt;
    }

    public static User create(String email, String name, String encryptedPwd) {
        return User.builder()
                .userId(UUID.randomUUID().toString())
                .email(email)
                .name(name)
                .encryptedPwd(encryptedPwd)
                .createAt(LocalDateTime.now())
                .build();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User that = (User) o;
        return this.getId() != null
                && this.getUserId() != null
                && Objects.equals(this.getId(), that.getId())
                && Objects.equals(this.getUserId(), that.getUserId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

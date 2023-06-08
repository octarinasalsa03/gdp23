package id.amartek.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import id.amartek.app.model.User;

public interface UserManagementRepository extends JpaRepository<User, Integer> {
        @Query("""
                        SELECT u, e FROM User u
                        INNER JOIN u.employee e ON u.Id = e.Id
                        INNER JOIN  u.Role r
                        WHERE u.Email = ?1
                            """)
        public User Login(String email);

        @Query("""
                        SELECT e.Id FROM Employee e WHERE e.Numberphone = ?1
                        """)
        public Integer GetEmployeeId(String numberphone);

        @Query("""
                        SELECT r.Id FROM Role r WHERE r.Level = (SELECT MAX(s.Level) FROM Role s)
                        """)
        public Integer GetRoleId();

        @Transactional
        @Modifying
        @Query("""
                        UPDATE User u SET u.Password = ?1 WHERE u.Email = ?2
                        """)
        public Integer UpdateByEmail(String password, String email);

}

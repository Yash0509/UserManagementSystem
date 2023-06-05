package com.example.userManagement.repository;
import com.example.userManagement.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//public interface UserRepository extends JpaRepository<User,String> {
//}
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{userName:'?0'}")
    Optional<User> findItemByUserName(String teacherUserName);

    void deleteByUserName(String studentUserName);
}
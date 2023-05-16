package com.gtsrd.chainview.repository;

import com.gtsrd.chainview.model.Event;
import com.gtsrd.chainview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
}

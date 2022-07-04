package com.server.server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {


}
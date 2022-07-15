package com.server.server.Repository;

import com.server.server.Entity.Carriers;
import com.server.server.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository

public interface CarriersRepository extends JpaRepository<Carriers,Long> {
}

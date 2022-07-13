package com.server.server.Repository;

import com.server.server.Entity.Carriers;
import com.server.server.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarriersRepository extends JpaRepository<Carriers,Long> {
}

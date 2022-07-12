package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Tags;

@Repository
public interface TagsRepository extends JpaRepository<Tags,Long> {

}

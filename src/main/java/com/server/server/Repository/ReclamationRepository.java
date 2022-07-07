package com.server.server.Repository;


import com.server.server.Entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository  extends JpaRepository<Reclamation,Long> {

}

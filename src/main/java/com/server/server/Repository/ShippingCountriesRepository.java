package com.server.server.Repository;

import com.server.server.Entity.Category;
import com.server.server.Entity.ShippingCountries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingCountriesRepository extends JpaRepository<ShippingCountries,Long> {
}

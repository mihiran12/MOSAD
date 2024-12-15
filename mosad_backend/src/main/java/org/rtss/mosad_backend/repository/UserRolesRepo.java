package org.rtss.mosad_backend.repository;

import org.rtss.mosad_backend.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRolesRepo extends JpaRepository<UserRoles, Integer> {
}
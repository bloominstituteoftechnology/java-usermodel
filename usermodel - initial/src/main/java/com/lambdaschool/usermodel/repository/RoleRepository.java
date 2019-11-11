package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Role;
import com.lambdaschool.usermodel.views.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends CrudRepository<Role, Long>
{
    Role findByNameIgnoreCase(String name);

    @Transactional
    @Modifying
    @Query(value = "SELECT COUNT(*) as count FROM userroles WHERE userid = :userid AND roleid = :roleid",
            nativeQuery = true)
    JustTheCount checkUserRolesCombo(long userid,
                                     long roleid);

}

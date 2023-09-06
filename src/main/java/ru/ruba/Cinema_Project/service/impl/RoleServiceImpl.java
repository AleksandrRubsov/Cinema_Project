package ru.ruba.Cinema_Project.service.impl;

import ru.ruba.Cinema_Project.dao.RoleDao;
import ru.ruba.Cinema_Project.model.Role;
import ru.ruba.Cinema_Project.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleDao.getByName(roleName)
                .orElseThrow(()
                        -> new RuntimeException("Can't find role with this roleName" + roleName));
    }
}
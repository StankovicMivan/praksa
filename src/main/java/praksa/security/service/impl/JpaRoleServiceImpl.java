package praksa.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import praksa.security.model.Role;
import praksa.security.repository.RoleRepository;
import praksa.security.service.RoleService;
@Service
public class JpaRoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public Role save(Role role) {
	
		return roleRepository.save(role);
	}

}

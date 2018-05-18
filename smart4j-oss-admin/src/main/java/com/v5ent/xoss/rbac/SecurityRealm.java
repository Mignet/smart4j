package com.v5ent.xoss.rbac;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.v5ent.web.model.Permission;
import com.v5ent.web.model.Role;
import com.v5ent.web.model.User;
import com.v5ent.web.service.PermissionService;
import com.v5ent.web.service.RoleService;
import com.v5ent.web.service.UserService;

/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author Mignet
 * @since 2014年6月11日 上午11:35:28
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityRealm.class);
	
    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());
        final User user = userService.selectByUsername(username);
        //查询用户拥有的角色
        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getId());
        for (Role role : roleInfos) {
        	LOGGER.debug("用户{}拥有的role:{}",username,role);
            authorizationInfo.addRole(role.getRoleSign());
            //查询角色拥有的权限
            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
            for (Permission permission : permissions) {
            	LOGGER.debug("用户{}拥有的permission{}:",username,permission);
                authorizationInfo.addStringPermission(permission.getPermissionSign());
            }
        }
        return authorizationInfo;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        // 通过数据库进行验证
        final User authentication = userService.authentication(new User(username, password));
        if (authentication == null) {
            throw new AuthenticationException("用户名或密码错误.");
        }
        if (!"Y".equals(authentication.getState())) {
        	throw new AuthenticationException("当前用户无效.");
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }

}

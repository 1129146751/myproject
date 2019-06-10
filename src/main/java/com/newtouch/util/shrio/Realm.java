
package com.newtouch.util.shrio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Objects;
import com.newtouch.mapperDao.SysUserMapper;
import com.newtouch.model.SysUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;


/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/10
 * Time:13:02
 **/
public class Realm extends AuthorizingRealm {

    @Resource
    private SysUserMapper sysUserMapper;

    private SysUser user;
    private Logger logger = LoggerFactory.getLogger(Realm.class);

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "e10adc3949ba59abbe56e057f20f883e";
        Object salt = ByteSource.Util.bytes("user");
        Integer hashIterations = null;

        //Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt);
        System.out.println(result);
    }

    /**
     * 授权，在配有缓存的情况下，只加载一次。
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        //当前登录用户，账号
        String longinCode = principal.toString();
        System.out.println("当前登录用户doGetAuthorizationInfo:" + principal);
        //获取角色信息
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userLonginName", longinCode);
        List<SysUser> userList = sysUserMapper.selectByExample(example);
        Set<String> roles = new HashSet<String>();
        if (userList.size() > 0) {
            for (SysUser u : userList) {
                roles.add(String.valueOf(u.getUserSysName()));
            }
        } else {
            logger.info("当前用户没有角色！");
        }
        /* SysUser sysuser2=(SysUser)principal;*/
        //roles.add("admin");
        SimpleAuthorizationInfo info = null;
        logger.info("用户的角色！" + roles.toString());
        info = new SimpleAuthorizationInfo(roles);
        return info;
    }

    /**
     * 认证登录，查询数据库，如果该用户名正确，得到正确的数据，并返回正确的数据
     * AuthenticationInfo的实现类SimpleAuthenticationInfo保存正确的用户信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.将token转换为UsernamePasswordToken
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //2.获取token中的登录账户
        String longinCode = userToken.getUsername();
        //3.查询数据库，是否存在指定的用户名和密码的用户(主键/账户/密码/账户状态/盐)
        SysUser sysuser = new SysUser();
        sysuser.setUserLonginName(longinCode);
        List<SysUser> userList = sysUserMapper.select(sysuser);
        //4.1 如果没有查询到，抛出异常
        if (userList.size() == 0) {
            throw new UnknownAccountException("账户" + longinCode + "不存在！");
        }
        if (Objects.equal(userList.get(0).getUserLock(), 1)) {
            throw new LockedAccountException(longinCode + "被锁定！");
        }
        //4.2 如果查询到了，封装查询结果，
        Object principal = userList.get(0).getUserLonginName();
        Object credentials = userList.get(0).getUserPassword();
        String realmName = this.getName();
        String salt = userList.get(0).getUserSalt();
        //获取盐，用于对密码在加密算法(MD5)的基础上二次加密ֵ
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, byteSalt, realmName);
        SimpleAuthenticationInfo info2 = new SimpleAuthenticationInfo(principal, credentials, realmName);
        //5. 返回给调用login(token)方法
        return info2;
    }
}
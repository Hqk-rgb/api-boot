package top.whf.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.whf.common.constant.Constant;
import top.whf.common.utils.TreeUtils;
import top.whf.mybatis.service.impl.BaseServiceImpl;
import top.whf.rbac.convert.SysMenuConvert;
import top.whf.rbac.dao.SysMenuDao;
import top.whf.rbac.entity.SysMenuEntity;
import top.whf.rbac.enums.SuperAdminEnum;
import top.whf.rbac.service.SysMenuService;
import top.whf.rbac.vo.SysMenuVO;
import top.whf.security.user.UserDetail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @ClassName SysMenuServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:40
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService{
    @Override
    public List<SysMenuVO> getMenuList(Integer type) {
        List<SysMenuEntity> menuList = baseMapper.getMenuList(type);
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList), Constant.ROOT);
    }

    @Override
    public List<SysMenuVO> getUserMenuList(UserDetail user, Integer type) {
        List<SysMenuEntity> menuList;
        // 系统管理员，拥有最高权限
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
            menuList = baseMapper.getMenuList(type);
        } else {
            menuList = baseMapper.getUserMenuList(user.getId(), type);
        }
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList));
    }

    @Override
    public Set<String> getUserAuthority(UserDetail user) {
        List<String> authorityList;
        // 系统管理员
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
            // 赋予所有权限
            authorityList = baseMapper.getAuthorityList();
        } else {
            // 查询该用户的所有权限
            authorityList = baseMapper.getUserAuthorityList(user.getId());
        }

        // 根据，分割字符串，得到的list，去重去空，加入set
        Set<String> permsSet = new HashSet<>();
        for (String authority : authorityList) {
            if (StrUtil.isBlank(authority)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(authority.trim().split(",")));
        }
        return permsSet;
    }
}

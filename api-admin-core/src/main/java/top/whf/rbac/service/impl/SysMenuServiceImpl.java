package top.whf.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.whf.mybatis.service.impl.BaseServiceImpl;
import top.whf.rbac.dao.SysMenuDao;
import top.whf.rbac.entity.SysMenuEntity;
import top.whf.rbac.service.SysMenuService;
/**
 * @ClassName SysMenuServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:40
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService{
}

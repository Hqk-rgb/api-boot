package top.whf.rbac.service.impl;

import org.springframework.stereotype.Service;
import top.whf.mybatis.service.impl.BaseServiceImpl;
import top.whf.rbac.dao.SysLogLoginDao;
import top.whf.rbac.entity.SysLogLoginEntity;
import top.whf.rbac.service.SysLogLoginService;
/**
 * @ClassName SysLogLoginServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:42
 */
@Service
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService{
}

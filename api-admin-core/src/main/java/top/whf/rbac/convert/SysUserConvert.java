package top.whf.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.whf.rbac.entity.SysUserEntity;
import top.whf.rbac.vo.SysUserVO;
import top.whf.security.user.UserDetail;
/**
 * @ClassName SysUserConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:48
 */
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO convert(SysUserEntity entity);

    SysUserVO convert(UserDetail userDetail);

    UserDetail convertDetail(SysUserEntity entity);
}

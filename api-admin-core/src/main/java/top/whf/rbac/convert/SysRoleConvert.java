package top.whf.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.whf.rbac.entity.SysRoleEntity;
import top.whf.rbac.vo.SysRoleVO;

import java.util.List;

/**
 * @ClassName SysRoleConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/2 10:01
 */
@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRoleVO convert(SysRoleEntity entity);

    SysRoleEntity convert(SysRoleVO vo);

    List<SysRoleVO> convertList(List<SysRoleEntity> list);
}

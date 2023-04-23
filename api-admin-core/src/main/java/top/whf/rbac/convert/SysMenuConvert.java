package top.whf.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.whf.rbac.entity.SysMenuEntity;
import top.whf.rbac.vo.SysMenuVO;

import java.util.List;
/**
 * @ClassName SysMenuConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 20:46
 */
@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    SysMenuEntity convert(SysMenuVO vo);

    SysMenuVO convert(SysMenuEntity entity);

    List<SysMenuVO> convertList(List<SysMenuEntity> list);
}

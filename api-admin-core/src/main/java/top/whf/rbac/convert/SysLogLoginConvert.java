package top.whf.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.whf.rbac.entity.SysLogLoginEntity;
import top.whf.rbac.vo.SysLogLoginVO;

import java.util.List;
/**
 * @ClassName SysLogLoginConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 21:00
 */
@Mapper
public interface SysLogLoginConvert {
    SysLogLoginConvert INSTANCE = Mappers.getMapper(SysLogLoginConvert.class);

    SysLogLoginEntity convert(SysLogLoginVO vo);

    SysLogLoginVO convert(SysLogLoginEntity entity);

    List<SysLogLoginVO> converList(List<SysLogLoginEntity> list);
}

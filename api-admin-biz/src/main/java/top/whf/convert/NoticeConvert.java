package top.whf.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.whf.entity.NoticeEntity;
import top.whf.vo.NoticeVO;

import java.util.List;
/**
 * @ClassName NoticeConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 21:12
 */
@Mapper
public interface NoticeConvert {
    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    NoticeVO convert(NoticeEntity entity);

    NoticeEntity convert(NoticeVO vo);

    List<NoticeVO> convertList(List<NoticeEntity> list);
}

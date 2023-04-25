package top.whf.rbac.service;

import top.whf.rbac.vo.BarVO;
import top.whf.rbac.vo.LabelVO;
import top.whf.rbac.vo.PanelVO;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/25 13:47
 */
public interface IndexService {
    /**
     * 后台首页统计 1:项目主要数据统计面板
     * @return List<PanelVO>
     */
    List<PanelVO> statics1();

    /**
     * 后台首页统计 2:echarts 柱状图
     * @return BarVO
     */
    BarVO statics2();

    /**
     * 后台首页统计 3:分类统计标签
     * @return Map<String,List<LabelVO>>
     */
    Map<String,List<LabelVO>> statics3();
}

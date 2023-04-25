package top.whf.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.whf.rbac.service.IndexService;
import top.whf.rbac.vo.BarVO;
import top.whf.rbac.vo.LabelVO;
import top.whf.rbac.vo.PanelVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;

/**
 * @ClassName IndexServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/25 13:51
 */
@Service
@AllArgsConstructor
public class IndexServiceImpl implements IndexService {
    @Override
    public List<PanelVO> statics1() {
        PanelVO panel1 = PanelVO.builder().title("支付订单").value(499).unit("年").unitColor("success").subTitle("总支付订单").subValue(4999).subUnit("年").build();
        PanelVO panel2 = PanelVO.builder().title("订单量").value(567).unit("周").unitColor("danger").subTitle("总订单量").subValue(6666).subUnit("年").build();
        PanelVO panel3 = PanelVO.builder().title("销售额(万元)").value(365).unit("年").unitColor("primary").subTitle("总销售额(万元)").subValue(666).subUnit("年").build();
        PanelVO panel4 = PanelVO.builder().title("新增用户").value(78).unit("月").unitColor("warning").subTitle("总用户数").subValue(888).subUnit("年").build();
        return List.of(panel1, panel2, panel3, panel4);
    }

    @Override
    public BarVO statics2() {
        List<String> x = List.of("00", "23", "22", "21", "20", "19", "18", "16", "15", "14", "13", "12", "11", "10", "09", "08", "07", "06", "05", "04", "03", "02", "01");
        List<Integer> y = List.of(0,0,0,0,0,4,6,3,0,6,3,0,0,11,18,0,0,0,0,0,0,0,0);
        return BarVO.builder().x(x).y(y).build();
    }

    @Override
    public Map<String, List<LabelVO>> statics3() {
        List<LabelVO> goods = List.of(new LabelVO("审核中",5),new LabelVO("销售中",17),new LabelVO("已下架",8),new LabelVO("库存预警",2));
        List<LabelVO> orders = List.of(new LabelVO("待付款",24),new LabelVO("待发货",65),new LabelVO("已发货",89),new LabelVO("退款中",1));
        Map<String,List<LabelVO>> map = new HashMap<>();
        map.put("goods",goods);
        map.put("order", orders);
        return map;
    }
}

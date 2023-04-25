package top.whf.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.whf.common.utils.Result;
import top.whf.rbac.service.IndexService;
import top.whf.rbac.vo.BarVO;
import top.whf.rbac.vo.LabelVO;
import top.whf.rbac.vo.PanelVO;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/25 14:09
 */
@RestController
@RequestMapping("/sys/index")
@Tag(name = "首页统计")

@AllArgsConstructor
public class IndexController {
    private final IndexService indexService;

    @GetMapping("statics1")
    @Operation(summary = "统计组件1")
    public Result<List<PanelVO>> getStatics1(){
        List<PanelVO> list = indexService.statics1();
        return Result.ok(list);
    }
    @GetMapping("statics2")
    @Operation(summary = "统计组件2")
    public Result<BarVO> getStatics2(String type){
        BarVO barVO = indexService.statics2(type);
        return Result.ok(barVO);
    }
    @GetMapping("statics3")
    @Operation(summary = "统计组件3")
    public Result<Map<String,List<LabelVO>>> getStatics3(){
        Map<String,List<LabelVO>> map = indexService.statics3();
        return Result.ok(map);
    }
}

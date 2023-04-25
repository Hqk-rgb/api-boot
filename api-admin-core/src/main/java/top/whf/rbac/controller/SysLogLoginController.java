package top.whf.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.whf.common.utils.PageResult;
import top.whf.common.utils.Result;
import top.whf.rbac.query.SysLogLoginQuery;
import top.whf.rbac.service.SysLogLoginService;
import top.whf.rbac.vo.SysLogLoginVO;
/**
 * @ClassName SysLogLoginController
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 21:02
 */
@RestController
@RequestMapping("sys/log/login")
@Tag(name = "登录日志")
@AllArgsConstructor
public class SysLogLoginController {
    private final SysLogLoginService sysLogLoginService;

    @GetMapping("page")
    @Operation(summary = "登录日志分页")
    //@PreAuthorize("hasAuthority('sys:log:page')")
    public Result<PageResult<SysLogLoginVO>> page(@ParameterObject @Valid SysLogLoginQuery query) {
        PageResult<SysLogLoginVO> page = sysLogLoginService.page(query);
        return Result.ok(page);
    }

}

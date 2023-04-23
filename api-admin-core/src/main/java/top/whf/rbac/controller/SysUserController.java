package top.whf.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.whf.common.utils.Result;
import top.whf.rbac.convert.SysUserConvert;
import top.whf.rbac.service.SysMenuService;
import top.whf.rbac.vo.SysAuthVO;
import top.whf.rbac.vo.SysUserVO;
import top.whf.security.user.SecurityUser;
import top.whf.security.user.UserDetail;
/**
 * @ClassName SysUserController
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 20:48
 */
@RestController
@RequestMapping("sys/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class SysUserController {
    private final SysMenuService sysMenuService;

    @PostMapping("info")
    @Operation(summary = "获取登录用户信息")
    public Result<SysAuthVO> info() {
        SysAuthVO vo = new SysAuthVO();
        UserDetail userDetail = SecurityUser.getUser();
        //1 获得用户详细信息，转成 vo
        SysUserVO user = SysUserConvert.INSTANCE.convert(userDetail);
        vo.setSysUserVO(user);
        //2 获取用户导航菜单
        vo.setNav(sysMenuService.getUserMenuList(userDetail, 0));
        //3 获得用户授权信息
        vo.setAuthority(sysMenuService.getUserAuthority(userDetail));
        return Result.ok(vo);
    }
}
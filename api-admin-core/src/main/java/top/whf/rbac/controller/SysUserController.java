package top.whf.rbac.controller;

import cn.hutool.core.util.StrUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;
import top.whf.common.utils.PageResult;
import top.whf.common.utils.Result;
import top.whf.rbac.convert.SysUserConvert;
import top.whf.rbac.entity.SysUserEntity;
import top.whf.rbac.query.SysUserQuery;
import top.whf.rbac.service.SysMenuService;
import top.whf.rbac.service.SysUserRoleService;
import top.whf.rbac.service.SysUserService;
import top.whf.rbac.vo.SysAuthVO;
import top.whf.rbac.vo.SysUserPasswordVO;
import top.whf.rbac.vo.SysUserVO;
import top.whf.security.user.SecurityUser;
import top.whf.security.user.UserDetail;

import java.util.List;

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
    // 补充
    private final PasswordEncoder passwordEncoder;
    private final SysUserService sysUserService;
    private final SysUserRoleService sysUserRoleService;



    @PostMapping("password")
    @Operation(summary = "修改密码")
    public Result<String> password(@RequestBody @Valid SysUserPasswordVO vo) {
        // 原密码不正确
        UserDetail user = SecurityUser.getUser();
        if (!passwordEncoder.matches(vo.getOldPassword(), user.getPassword())) {
            return Result.error("原密码不正确");
        }
        // 修改密码
        sysUserService.updatePassword(user.getId(), passwordEncoder.encode(vo.getNewPassword()));
        return Result.ok();
    }

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
    
    @GetMapping("page")
    @Operation(summary = "用户数据分页")
    @PreAuthorize("hasAuthority('sys:user:page')")
    public Result<PageResult<SysUserVO>> page(@ParameterObject @Valid SysUserQuery query){
        PageResult<SysUserVO> page = sysUserService.page(query);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "获得指定用户信息")
    @PreAuthorize("hasAuthority('sys:user:info')")
    public Result<SysUserVO> get(@PathVariable("id") Long id) {
        SysUserEntity entity = sysUserService.getById(id);
        SysUserVO vo = SysUserConvert.INSTANCE.convert(entity);
        //用户角色列表
//        List<Long> roleIdList = sysUserRoleService.getRoleIdList(id);
//        vo.setRoleIdList(roleIdList);
        return Result.ok(vo);
    }
    @PostMapping
    @Operation(summary = "保存用户")
    @PreAuthorize("hasAuthority('sys:user:save')")
    public Result<String> save(@RequestBody @Valid SysUserVO vo) {
        //新增密码不能为空
        if (StrUtil.isBlank(vo.getPassword())) {
            Result.error("密码不能为空");
        }
        //密码加密
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        sysUserService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改用户")
    @PreAuthorize("hasAuthority('sys:user:update')")
    public Result<String> update(@RequestBody @Valid SysUserVO vo) {
        if (StrUtil.isBlank(vo.getPassword())) {
            vo.setPassword(null);
        } else {
            vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        }
        sysUserService.update(vo);
        return Result.ok();
    }
    @PostMapping("delete")
    @Operation(summary = "批量删除用户")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    public Result<String> delete(@RequestBody List<Long> ids){
        Long userId = SecurityUser.getUserId();
        if (ids.contains(userId)){
            return Result.error("不能删除当前登录用户");
        }
        sysUserService.delete(ids);
        return Result.ok();
    }
    @PostMapping("import")
    @Operation(summary = "导入用户")
    @PreAuthorize("hasAuthority('sys:user:import')")
    public Result<String> importExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()){
            return Result.error("请选择需要上传的文件");
        }
        //密码默认初始化为123456
        sysUserService.importByExcel(file,passwordEncoder.encode("123456"));
        return Result.ok();
    }

    @GetMapping("export")
    @Operation(summary = "导出用户")
    @PreAuthorize("hasAuthority('sys:user:export')")
    public void export(){
        sysUserService.export();
    }

    @PostMapping("status")
    @Operation(summary = "修改用户状态")
    @PreAuthorize("hasAuthority('sys:user:update')")
    public Result<String> updateStatus(@RequestParam Long id, @RequestParam("status") Integer status) {
        sysUserService.updateStatus(id,status);
        return Result.ok();
    }
}

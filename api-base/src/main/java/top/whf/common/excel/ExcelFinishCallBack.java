package top.whf.common.excel;

import java.util.List;

/**
 * @ClassName ExcelFinishCallBack
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 18:29
 */
public interface ExcelFinishCallBack<T> {
    /**
     * 导出后置处理数据
     *
     * @param result result
     */
    void doAfterAllAnalysed(List<T> result);

    /**
     * @param result result
     */
    default void doSaveBatch(List<T> result) {
    }
}

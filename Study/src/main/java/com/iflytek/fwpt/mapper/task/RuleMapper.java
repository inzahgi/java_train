package com.iflytek.fwpt.mapper.task;



import com.iflytek.fwpt.model.rule.vo.RuleVo;
import com.iflytek.fwpt.model.task.TaskEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RuleMapper
{

    public void save(RuleVo rule);

    public void update(RuleVo rule);

    // public void deleteByModeCodeAndTaskId(@Param(value = "modeCode") String modeCode,
    // @Param(value = "taskId") String taskId);

    public List<RuleVo> getRuleByTaskIdAndModeCode(@Param(value = "modeCode") String modeCode,
                                                   @Param(value = "taskId") String taskId);

    public List<RuleVo> getRuleByTaskId(@Param(value = "taskId") String taskId);

    public void updateRuleInfo(@Param(value = "ruleId") String ruleId,
                               @Param(value = "ruleInfo") String ruleInfo);

    public void deleteByTaskId(@Param(value = "taskId") String taskId);

    /**
     * 根据民警账号返回对应结果
     * 〈功能详细描述〉
     * @author xinguo@iflytek.com
     * @version 2018年6月4日
     */
    public List<RuleVo> getRuleIdByUserId(@Param(value = "userId") String userId);

    public List<RuleVo> getRunningRuleByModeCodes(List<String> modeCodes);

    public void deleteByTaskIdAndModeCode(@Param(value = "modeCode") String modeCode,
                                          @Param(value = "taskId") String taskId);

    /**
     * 预警结果返回保存查询taskId和创建民警信息
     * 〈功能详细描述〉
     * @author xinguo@iflytek.com
     * @version 2018年6月7日
     */
    public TaskEntity queryTaskIdAndUserByRuleId(@Param(value = "ruleId") String ruleId);

    public List<RuleVo> getPendingRuleByModeCodes(List<String> modeCodes);

    public List<String> getRuleIdByUserIdAndTaskName(@Param(value = "userId") String userId,
                                                     @Param(value = "taskName") String taskName);

}

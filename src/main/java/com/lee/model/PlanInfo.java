package com.lee.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 诊断计划
 * </p>
 *
 * @author lihuanmin
 * @since 2017-09-12
 */
@TableName("plan_info")
@ApiModel(value = "诊断计划", description = "诊断计划实体类")
public class PlanInfo extends Model<PlanInfo> {

    private static final long serialVersionUID=1L;

    public static String JOB_PARAM_KEY = "JOB_PARAM";

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;
    /**
     * 计划名称
     */
    @TableField("plan_name")
    @ApiModelProperty(value = "计划名称")
    @Length(min = 0, max =30)
    private String planName;
    /**
     * 优先级
     */
    @TableField("plan_priority")
    @ApiModelProperty(value = "优先级")
    private Integer planPriority;
    /**
     * 诊断场景ID
     */
    @TableField("plan_scenario")
    @ApiModelProperty(value = "诊断场景ID")
    private Long planScenario;
    /**
     * 计划状态
     */
    @TableField("plan_state")
    @ApiModelProperty(value = "计划状态")
    @Length(min = 0, max =30)
    private String planState;
    /**
     * 计划诊断类型（自定义诊断项、设备诊断项）
     */
    @TableField("plan_diagnostic")
    @ApiModelProperty(value = "计划诊断类型（自定义诊断项、设备诊断项）")
    private Integer planDiagnostic;
    /**
     * 计划类型（单次、重复）
     */
    @TableField("plan_type")
    @ApiModelProperty(value = "计划类型（单次、重复）")
    private Integer planType;
    /**
     * 开始日期时间
     */
    @TableField("start_date_time")
    @ApiModelProperty(value = "开始日期时间")
    private Date startDateTime;
    /**
     * 结束日期时间
     */
    @TableField("end_date_time")
    @ApiModelProperty(value = "结束日期时间")
    private Date endDateTime;
    /**
     * 开始时间
     */
    @TableField("diagnostic_start_time")
    @ApiModelProperty(value = "开始时间")
    @Length(min = 0, max =10)
    private String diagnosticStartTime;
    /**
     * 结束时间
     */
    @TableField("diagnostic_end_time")
    @ApiModelProperty(value = "结束时间")
    @Length(min = 0, max =10)
    private String diagnosticEndTime;
    /**
     * 重复周期类型
     */
    @TableField("cycle_type")
    @ApiModelProperty(value = "重复周期类型")
    @Length(min = 0, max =30)
    private String cycleType;
    /**
     * 重复周期值
     */
    @TableField("cycle_value")
    @ApiModelProperty(value = "重复周期值")
    @Length(min = 0, max =80)
    private String cycleValue;
    /**
     * 指定的周值
     */
    @TableField("cycle_week_value")
    @ApiModelProperty(value = "指定的周值")
    @Length(min = 0, max =80)
    private String cycleWeekValue;
    /**
     * 指定月值
     */
    @TableField("cycle_month_value")
    @ApiModelProperty(value = "指定月值")
    @Length(min = 0, max =80)
    private String cycleMonthValue;
    /**
     * 指定天值
     */
    @TableField("cycle_day_value")
    @ApiModelProperty(value = "指定天值")
    @Length(min = 0, max =80)
    private String cycleDayValue;
    /**
     * 重复任务间隔类型
     */
    @TableField("cycle_interval_type")
    @ApiModelProperty(value = "重复任务间隔类型")
    @Length(min = 0, max =30)
    private String cycleIntervalType;
    /**
     * 重复任务间隔值
     */
    @TableField("cycle_interval_value")
    @ApiModelProperty(value = "重复任务间隔值")
    private Integer cycleIntervalValue;
    /**
     * 等待执行时间类型
     */
    @TableField("wait_type")
    @ApiModelProperty(value = "等待执行时间类型")
    @Length(min = 0, max =30)
    private String waitType;
    /**
     * 等待执行时间值
     */
    @TableField("wait_value")
    @ApiModelProperty(value = "等待执行时间值")
    private Integer waitValue;
    /**
     * Cron表达式
     */
    @TableField("cron_value")
    @ApiModelProperty(value = "Cron表达式")
    @Length(min = 0, max =60)
    private String cronValue;
    /**
     * 任务描述
     */
    @TableField("plan_describe")
    @ApiModelProperty(value = "任务描述")
    @Length(min = 0, max =300)
    private String planDescribe;
    /**
     * 添加时间
     */
    @TableField("create_time")
    @ApiModelProperty(value = "添加时间")
    private Date createTime;


    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName(){
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getPlanPriority(){
        return planPriority;
    }

    public void setPlanPriority(Integer planPriority) {
        this.planPriority = planPriority;
    }

    public Long getPlanScenario(){
        return planScenario;
    }

    public void setPlanScenario(Long planScenario) {
        this.planScenario = planScenario;
    }

    public String getPlanState(){
        return planState;
    }

    public void setPlanState(String planState) {
        this.planState = planState;
    }

    public Integer getPlanDiagnostic(){
        return planDiagnostic;
    }

    public void setPlanDiagnostic(Integer planDiagnostic) {
        this.planDiagnostic = planDiagnostic;
    }

    public Integer getPlanType(){
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Date getStartDateTime(){
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime(){
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getDiagnosticStartTime(){
        return diagnosticStartTime;
    }

    public void setDiagnosticStartTime(String diagnosticStartTime) {
        this.diagnosticStartTime = diagnosticStartTime;
    }

    public String getDiagnosticEndTime(){
        return diagnosticEndTime;
    }

    public void setDiagnosticEndTime(String diagnosticEndTime) {
        this.diagnosticEndTime = diagnosticEndTime;
    }

    public String getCycleType(){
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public String getCycleValue(){
        return cycleValue;
    }

    public void setCycleValue(String cycleValue) {
        this.cycleValue = cycleValue;
    }

    public String getCycleWeekValue(){
        return cycleWeekValue;
    }

    public void setCycleWeekValue(String cycleWeekValue) {
        this.cycleWeekValue = cycleWeekValue;
    }

    public String getCycleMonthValue(){
        return cycleMonthValue;
    }

    public void setCycleMonthValue(String cycleMonthValue) {
        this.cycleMonthValue = cycleMonthValue;
    }

    public String getCycleDayValue(){
        return cycleDayValue;
    }

    public void setCycleDayValue(String cycleDayValue) {
        this.cycleDayValue = cycleDayValue;
    }

    public String getCycleIntervalType(){
        return cycleIntervalType;
    }

    public void setCycleIntervalType(String cycleIntervalType) {
        this.cycleIntervalType = cycleIntervalType;
    }

    public Integer getCycleIntervalValue(){
        return cycleIntervalValue;
    }

    public void setCycleIntervalValue(Integer cycleIntervalValue) {
        this.cycleIntervalValue = cycleIntervalValue;
    }

    public String getWaitType(){
        return waitType;
    }

    public void setWaitType(String waitType) {
        this.waitType = waitType;
    }

    public Integer getWaitValue(){
        return waitValue;
    }

    public void setWaitValue(Integer waitValue) {
        this.waitValue = waitValue;
    }

    public String getCronValue(){
        return cronValue;
    }

    public void setCronValue(String cronValue) {
        this.cronValue = cronValue;
    }

    public String getPlanDescribe(){
        return planDescribe;
    }

    public void setPlanDescribe(String planDescribe) {
        this.planDescribe = planDescribe;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

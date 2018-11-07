package com.iflytek.fwpt.model.dqjc;

import java.util.Date;

/**
 * t_credit_statistics
 * @author 
 */
public class CreditStatistics {
    private Integer id;

    /**
     * 派出所
     */
    private String policeSubStationName;

    /**
     * 公安分局区域
     */
    private String areaName;

    /**
     * 非关押数
     */
    private Integer noimprisoncnt;

    /**
     * 影性数
     */
    private Integer recessivecnt;

    /**
     * 极高数
     */
    private Integer highestcnt;

    /**
     * 较高数
     */
    private Integer highercnt;

    /**
     * 高个数
     */
    private Integer highcnt;

    /**
     * 中个数
     */
    private Integer midcnt;

    /**
     * 低个数
     */
    private Integer lowcnt;

    /**
     * 预警个数
     */
    private Integer warncnt;

    /**
     * 处置个数
     */
    private Integer handlecnt;

    /**
     * 推送个数
     */
    private Integer pushcnt;

    /**
     * 反馈个数
     */
    private Integer feedbackcnt;


    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoliceSubStationName() {
        return policeSubStationName;
    }

    public void setPoliceSubStationName(String policeSubStationName) {
        this.policeSubStationName = policeSubStationName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getNoimprisoncnt() {
        return noimprisoncnt;
    }

    public void setNoimprisoncnt(Integer noimprisoncnt) {
        this.noimprisoncnt = noimprisoncnt;
    }

    public Integer getRecessivecnt() {
        return recessivecnt;
    }

    public void setRecessivecnt(Integer recessivecnt) {
        this.recessivecnt = recessivecnt;
    }

    public Integer getHighestcnt() {
        return highestcnt;
    }

    public void setHighestcnt(Integer highestcnt) {
        this.highestcnt = highestcnt;
    }

    public Integer getHighercnt() {
        return highercnt;
    }

    public void setHighercnt(Integer highercnt) {
        this.highercnt = highercnt;
    }

    public Integer getHighcnt() {
        return highcnt;
    }

    public void setHighcnt(Integer highcnt) {
        this.highcnt = highcnt;
    }

    public Integer getMidcnt() {
        return midcnt;
    }

    public void setMidcnt(Integer midcnt) {
        this.midcnt = midcnt;
    }

    public Integer getLowcnt() {
        return lowcnt;
    }

    public void setLowcnt(Integer lowcnt) {
        this.lowcnt = lowcnt;
    }

    public Integer getWarncnt() {
        return warncnt;
    }

    public void setWarncnt(Integer warncnt) {
        this.warncnt = warncnt;
    }

    public Integer getHandlecnt() {
        return handlecnt;
    }

    public void setHandlecnt(Integer handlecnt) {
        this.handlecnt = handlecnt;
    }

    public Integer getPushcnt() {
        return pushcnt;
    }

    public void setPushcnt(Integer pushcnt) {
        this.pushcnt = pushcnt;
    }

    public Integer getFeedbackcnt() {
        return feedbackcnt;
    }

    public void setFeedbackcnt(Integer feedbackcnt) {
        this.feedbackcnt = feedbackcnt;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    public static final class CreditStatisticsBuilder {
        private CreditStatistics creditStatistics;

        private CreditStatisticsBuilder() {
            creditStatistics = new CreditStatistics();
        }

        public static CreditStatisticsBuilder aCreditStatistics() {
            return new CreditStatisticsBuilder();
        }

        public CreditStatisticsBuilder id(Integer id) {
            creditStatistics.setId(id);
            return this;
        }

        public CreditStatisticsBuilder policeSubStationName(String policeSubStationName) {
            creditStatistics.setPoliceSubStationName(policeSubStationName);
            return this;
        }

        public CreditStatisticsBuilder areaName(String areaName) {
            creditStatistics.setAreaName(areaName);
            return this;
        }

        public CreditStatisticsBuilder noimprisoncnt(Integer noimprisoncnt) {
            creditStatistics.setNoimprisoncnt(noimprisoncnt);
            return this;
        }

        public CreditStatisticsBuilder recessivecnt(Integer recessivecnt) {
            creditStatistics.setRecessivecnt(recessivecnt);
            return this;
        }

        public CreditStatisticsBuilder highestcnt(Integer highestcnt) {
            creditStatistics.setHighestcnt(highestcnt);
            return this;
        }

        public CreditStatisticsBuilder highercnt(Integer highercnt) {
            creditStatistics.setHighercnt(highercnt);
            return this;
        }

        public CreditStatisticsBuilder highcnt(Integer highcnt) {
            creditStatistics.setHighcnt(highcnt);
            return this;
        }

        public CreditStatisticsBuilder midcnt(Integer midcnt) {
            creditStatistics.setMidcnt(midcnt);
            return this;
        }

        public CreditStatisticsBuilder lowcnt(Integer lowcnt) {
            creditStatistics.setLowcnt(lowcnt);
            return this;
        }

        public CreditStatisticsBuilder warncnt(Integer warncnt) {
            creditStatistics.setWarncnt(warncnt);
            return this;
        }

        public CreditStatisticsBuilder handlecnt(Integer handlecnt) {
            creditStatistics.setHandlecnt(handlecnt);
            return this;
        }

        public CreditStatisticsBuilder pushcnt(Integer pushcnt) {
            creditStatistics.setPushcnt(pushcnt);
            return this;
        }

        public CreditStatisticsBuilder feedbackcnt(Integer feedbackcnt) {
            creditStatistics.setFeedbackcnt(feedbackcnt);
            return this;
        }

        public CreditStatisticsBuilder createtime(Date createtime) {
            creditStatistics.setCreatetime(createtime);
            return this;
        }

        public CreditStatistics build() {
            return creditStatistics;
        }
    }
}
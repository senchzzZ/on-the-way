package com.exp.zsq;

import java.math.BigDecimal;
import java.util.Date;

public class DxsDailyStatistics {
    /**
     * 主键
     */
    private Long id;

    /**
     * 应收合计
     */
    private BigDecimal needTotal = BigDecimal.ZERO;

    /**
     * 实收合计
     */
    private BigDecimal recieveTotal = BigDecimal.ZERO;

    /**
     * 挂账合计
     */
    private BigDecimal oncreditTotal = BigDecimal.ZERO;

    /**
     * 免单合计
     */
    private BigDecimal freeTotal = BigDecimal.ZERO;

    /**
     * 退菜合计
     */
    private BigDecimal backdishTotal = BigDecimal.ZERO;

    /**
     * 优惠合计
     */
    private BigDecimal preferentialTotal = BigDecimal.ZERO;

    /**
     * 服务费
     */
    private BigDecimal serviceFee = BigDecimal.ZERO;

    /**
     * 总单数
     */
    private Integer ordernumTotal = 0;

    /**
     * 总人数
     */
    private Integer customernumTotal = 0;

    /**
     * 翻台率
     */
    private BigDecimal tablereuseRate = BigDecimal.ZERO;

    /**
     * 现金
     */
    private BigDecimal cashMoney = BigDecimal.ZERO;

    /**
     * 银行卡
     */
    private BigDecimal cardMoney = BigDecimal.ZERO;

    /**
     * 会员卡
     */
    private BigDecimal membercardMoney = BigDecimal.ZERO;

    /**
     * 优惠券
     */
    private BigDecimal couponMoney = BigDecimal.ZERO;

    /**
     * 团购券
     */
    private BigDecimal grouponMoney = BigDecimal.ZERO;

    /**
     * 第三方支付
     */
    private BigDecimal otherpayMoney = BigDecimal.ZERO;

    private BigDecimal lotteryMoney = BigDecimal.ZERO;

    private BigDecimal wechatMoney = BigDecimal.ZERO;

    private BigDecimal alipayMoney = BigDecimal.ZERO;

    /**
     * 折扣
     */
    private BigDecimal discountMoney = BigDecimal.ZERO;

    /**
     * 赠送
     */
    private BigDecimal giftMoney = BigDecimal.ZERO;

    /**
     * 系统抹零
     */
    private BigDecimal syswipeMoney = BigDecimal.ZERO;

    /**
     * 手动抹零
     */
    private BigDecimal manualwipeMoney = BigDecimal.ZERO;

    /**
     * 团购券结余
     */
    private BigDecimal overGroupon = BigDecimal.ZERO;

    /**
     * 会员充值
     */
    private BigDecimal memberCharge = BigDecimal.ZERO;

    /**
     * 会员退款
     */
    private BigDecimal memberRefund = BigDecimal.ZERO;

    /**
     * 挂账预收
     */
    private BigDecimal advances = BigDecimal.ZERO;

    /**
     * 减免金额
     */
    private BigDecimal reduction = BigDecimal.ZERO;

    /**
     * 饭店编号
     */
    private Long hotelId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 时间粒度
     */
    private Short timeLevel;

    /**
     * 统计时间
     */
    private Date statTime;

    /**
     * 最大值
     */
    private BigDecimal maxValue = BigDecimal.ZERO;

    /**
     * 平均值
     */
    private BigDecimal avgValue = BigDecimal.ZERO;

    /**
     * 会员充值赠送金额
     */
    private BigDecimal memberGift = BigDecimal.ZERO;

    /**
     * 会员充值赠送积分
     */
    private BigDecimal memberCount = BigDecimal.ZERO;

    /**
     * 会员充值笔数
     */
    private Integer chargeNum = 0;

    /**
     * 优惠券优免金额
     */
    private BigDecimal preferentialFree = BigDecimal.ZERO;

    /**
     * 团购券优免金额
     */
    private BigDecimal grouponFree = BigDecimal.ZERO;

    /**
     * 会员积分抵现
     */
    private BigDecimal membercount2money = BigDecimal.ZERO;

    /**
     * 会员赠送账户消费
     */
    private BigDecimal membergiftMoney = BigDecimal.ZERO;

    public DxsDailyStatistics(Long id, BigDecimal needTotal, BigDecimal recieveTotal, BigDecimal oncreditTotal, BigDecimal freeTotal, BigDecimal backdishTotal, BigDecimal preferentialTotal, BigDecimal serviceFee, Integer ordernumTotal, Integer customernumTotal, BigDecimal tablereuseRate, BigDecimal cashMoney, BigDecimal cardMoney, BigDecimal membercardMoney, BigDecimal couponMoney, BigDecimal grouponMoney, BigDecimal otherpayMoney, BigDecimal lotteryMoney, BigDecimal wechatMoney, BigDecimal alipayMoney, BigDecimal discountMoney, BigDecimal giftMoney, BigDecimal syswipeMoney, BigDecimal manualwipeMoney, BigDecimal overGroupon, BigDecimal memberCharge, BigDecimal memberRefund, BigDecimal advances, BigDecimal reduction, Long hotelId, Date createTime, Short timeLevel, Date statTime, BigDecimal maxValue, BigDecimal avgValue, BigDecimal memberGift, BigDecimal memberCount, Integer chargeNum, BigDecimal preferentialFree, BigDecimal grouponFree, BigDecimal membercount2money, BigDecimal membergiftMoney) {
        this.id = id;
        this.needTotal = needTotal;
        this.recieveTotal = recieveTotal;
        this.oncreditTotal = oncreditTotal;
        this.freeTotal = freeTotal;
        this.backdishTotal = backdishTotal;
        this.preferentialTotal = preferentialTotal;
        this.serviceFee = serviceFee;
        this.ordernumTotal = ordernumTotal;
        this.customernumTotal = customernumTotal;
        this.tablereuseRate = tablereuseRate;
        this.cashMoney = cashMoney;
        this.cardMoney = cardMoney;
        this.membercardMoney = membercardMoney;
        this.couponMoney = couponMoney;
        this.grouponMoney = grouponMoney;
        this.otherpayMoney = otherpayMoney;
        this.lotteryMoney = lotteryMoney;
        this.wechatMoney = wechatMoney;
        this.alipayMoney = alipayMoney;
        this.discountMoney = discountMoney;
        this.giftMoney = giftMoney;
        this.syswipeMoney = syswipeMoney;
        this.manualwipeMoney = manualwipeMoney;
        this.overGroupon = overGroupon;
        this.memberCharge = memberCharge;
        this.memberRefund = memberRefund;
        this.advances = advances;
        this.reduction = reduction;
        this.hotelId = hotelId;
        this.createTime = createTime;
        this.timeLevel = timeLevel;
        this.statTime = statTime;
        this.maxValue = maxValue;
        this.avgValue = avgValue;
        this.memberGift = memberGift;
        this.memberCount = memberCount;
        this.chargeNum = chargeNum;
        this.preferentialFree = preferentialFree;
        this.grouponFree = grouponFree;
        this.membercount2money = membercount2money;
        this.membergiftMoney = membergiftMoney;
    }

    public DxsDailyStatistics() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNeedTotal() {
        return needTotal;
    }

    public void setNeedTotal(BigDecimal needTotal) {
        this.needTotal = needTotal;
    }

    public BigDecimal getRecieveTotal() {
        return recieveTotal;
    }

    public void setRecieveTotal(BigDecimal recieveTotal) {
        this.recieveTotal = recieveTotal;
    }

    public BigDecimal getOncreditTotal() {
        return oncreditTotal;
    }

    public void setOncreditTotal(BigDecimal oncreditTotal) {
        this.oncreditTotal = oncreditTotal;
    }

    public BigDecimal getFreeTotal() {
        return freeTotal;
    }

    public void setFreeTotal(BigDecimal freeTotal) {
        this.freeTotal = freeTotal;
    }

    public BigDecimal getBackdishTotal() {
        return backdishTotal;
    }

    public void setBackdishTotal(BigDecimal backdishTotal) {
        this.backdishTotal = backdishTotal;
    }

    public BigDecimal getPreferentialTotal() {
        return preferentialTotal;
    }

    public void setPreferentialTotal(BigDecimal preferentialTotal) {
        this.preferentialTotal = preferentialTotal;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getOrdernumTotal() {
        return ordernumTotal;
    }

    public void setOrdernumTotal(Integer ordernumTotal) {
        this.ordernumTotal = ordernumTotal;
    }

    public Integer getCustomernumTotal() {
        return customernumTotal;
    }

    public void setCustomernumTotal(Integer customernumTotal) {
        this.customernumTotal = customernumTotal;
    }

    public BigDecimal getTablereuseRate() {
        return tablereuseRate;
    }

    public void setTablereuseRate(BigDecimal tablereuseRate) {
        this.tablereuseRate = tablereuseRate;
    }

    public BigDecimal getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(BigDecimal cashMoney) {
        this.cashMoney = cashMoney;
    }

    public BigDecimal getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(BigDecimal cardMoney) {
        this.cardMoney = cardMoney;
    }

    public BigDecimal getMembercardMoney() {
        return membercardMoney;
    }

    public void setMembercardMoney(BigDecimal membercardMoney) {
        this.membercardMoney = membercardMoney;
    }

    public BigDecimal getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }

    public BigDecimal getGrouponMoney() {
        return grouponMoney;
    }

    public void setGrouponMoney(BigDecimal grouponMoney) {
        this.grouponMoney = grouponMoney;
    }

    public BigDecimal getOtherpayMoney() {
        return otherpayMoney;
    }

    public void setOtherpayMoney(BigDecimal otherpayMoney) {
        this.otherpayMoney = otherpayMoney;
    }

    public BigDecimal getLotteryMoney() {
        return lotteryMoney;
    }

    public void setLotteryMoney(BigDecimal lotteryMoney) {
        this.lotteryMoney = lotteryMoney;
    }

    public BigDecimal getWechatMoney() {
        return wechatMoney;
    }

    public void setWechatMoney(BigDecimal wechatMoney) {
        this.wechatMoney = wechatMoney;
    }

    public BigDecimal getAlipayMoney() {
        return alipayMoney;
    }

    public void setAlipayMoney(BigDecimal alipayMoney) {
        this.alipayMoney = alipayMoney;
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public BigDecimal getGiftMoney() {
        return giftMoney;
    }

    public void setGiftMoney(BigDecimal giftMoney) {
        this.giftMoney = giftMoney;
    }

    public BigDecimal getSyswipeMoney() {
        return syswipeMoney;
    }

    public void setSyswipeMoney(BigDecimal syswipeMoney) {
        this.syswipeMoney = syswipeMoney;
    }

    public BigDecimal getManualwipeMoney() {
        return manualwipeMoney;
    }

    public void setManualwipeMoney(BigDecimal manualwipeMoney) {
        this.manualwipeMoney = manualwipeMoney;
    }

    public BigDecimal getOverGroupon() {
        return overGroupon;
    }

    public void setOverGroupon(BigDecimal overGroupon) {
        this.overGroupon = overGroupon;
    }

    public BigDecimal getMemberCharge() {
        return memberCharge;
    }

    public void setMemberCharge(BigDecimal memberCharge) {
        this.memberCharge = memberCharge;
    }

    public BigDecimal getMemberRefund() {
        return memberRefund;
    }

    public void setMemberRefund(BigDecimal memberRefund) {
        this.memberRefund = memberRefund;
    }

    public BigDecimal getAdvances() {
        return advances;
    }

    public void setAdvances(BigDecimal advances) {
        this.advances = advances;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public void setReduction(BigDecimal reduction) {
        this.reduction = reduction;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getTimeLevel() {
        return timeLevel;
    }

    public void setTimeLevel(Short timeLevel) {
        this.timeLevel = timeLevel;
    }

    public Date getStatTime() {
        return statTime;
    }

    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public BigDecimal getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(BigDecimal avgValue) {
        this.avgValue = avgValue;
    }

    public BigDecimal getMemberGift() {
        return memberGift;
    }

    public void setMemberGift(BigDecimal memberGift) {
        this.memberGift = memberGift;
    }

    public BigDecimal getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(BigDecimal memberCount) {
        this.memberCount = memberCount;
    }

    public Integer getChargeNum() {
        return chargeNum;
    }

    public void setChargeNum(Integer chargeNum) {
        this.chargeNum = chargeNum;
    }

    public BigDecimal getPreferentialFree() {
        return preferentialFree;
    }

    public void setPreferentialFree(BigDecimal preferentialFree) {
        this.preferentialFree = preferentialFree;
    }

    public BigDecimal getGrouponFree() {
        return grouponFree;
    }

    public void setGrouponFree(BigDecimal grouponFree) {
        this.grouponFree = grouponFree;
    }

    public BigDecimal getMembercount2money() {
        return membercount2money;
    }

    public void setMembercount2money(BigDecimal membercount2money) {
        this.membercount2money = membercount2money;
    }

    public BigDecimal getMembergiftMoney() {
        return membergiftMoney;
    }

    public void setMembergiftMoney(BigDecimal membergiftMoney) {
        this.membergiftMoney = membergiftMoney;
    }

    @Override
    public String toString() {
        return "DxsDailyStatistics{" +
                "id=" + id +
                ", needTotal=" + needTotal +
                ", recieveTotal=" + recieveTotal +
                ", oncreditTotal=" + oncreditTotal +
                ", freeTotal=" + freeTotal +
                ", backdishTotal=" + backdishTotal +
                ", preferentialTotal=" + preferentialTotal +
                ", serviceFee=" + serviceFee +
                ", ordernumTotal=" + ordernumTotal +
                ", customernumTotal=" + customernumTotal +
                ", tablereuseRate=" + tablereuseRate +
                ", cashMoney=" + cashMoney +
                ", cardMoney=" + cardMoney +
                ", membercardMoney=" + membercardMoney +
                ", couponMoney=" + couponMoney +
                ", grouponMoney=" + grouponMoney +
                ", otherpayMoney=" + otherpayMoney +
                ", lotteryMoney=" + lotteryMoney +
                ", wechatMoney=" + wechatMoney +
                ", alipayMoney=" + alipayMoney +
                ", discountMoney=" + discountMoney +
                ", giftMoney=" + giftMoney +
                ", syswipeMoney=" + syswipeMoney +
                ", manualwipeMoney=" + manualwipeMoney +
                ", overGroupon=" + overGroupon +
                ", memberCharge=" + memberCharge +
                ", memberRefund=" + memberRefund +
                ", advances=" + advances +
                ", reduction=" + reduction +
                ", hotelId=" + hotelId +
                ", createTime=" + createTime +
                ", timeLevel=" + timeLevel +
                ", statTime=" + statTime +
                ", maxValue=" + maxValue +
                ", avgValue=" + avgValue +
                ", memberGift=" + memberGift +
                ", memberCount=" + memberCount +
                ", chargeNum=" + chargeNum +
                ", preferentialFree=" + preferentialFree +
                ", grouponFree=" + grouponFree +
                ", membercount2money=" + membercount2money +
                ", membergiftMoney=" + membergiftMoney +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DxsDailyStatistics that = (DxsDailyStatistics) o;

        //if (!id.equals(that.id)) return false;
        //if (!needTotal.equals(that.needTotal)) return false;
        //if (!recieveTotal.equals(that.recieveTotal)) return false;
        if (needTotal.compareTo(that.needTotal)!=0) return false;
        if (recieveTotal.compareTo(that.recieveTotal)!=0) return false;

        if (!oncreditTotal.equals(that.oncreditTotal)) return false;
        if (!freeTotal.equals(that.freeTotal)) return false;
        if (!backdishTotal.equals(that.backdishTotal)) return false;
        //if (!preferentialTotal.equals(that.preferentialTotal)) return false;
        if (preferentialTotal.compareTo(that.preferentialTotal)!=0) return false;

        if (!serviceFee.equals(that.serviceFee)) return false;
        if (!ordernumTotal.equals(that.ordernumTotal)) return false;
        if (!customernumTotal.equals(that.customernumTotal)) return false;
        if (!tablereuseRate.equals(that.tablereuseRate)) return false;
        if (!cashMoney.equals(that.cashMoney)) return false;
        if (!cardMoney.equals(that.cardMoney)) return false;
        if (!membercardMoney.equals(that.membercardMoney)) return false;
        if (!couponMoney.equals(that.couponMoney)) return false;
        if (!grouponMoney.equals(that.grouponMoney)) return false;
        if (!otherpayMoney.equals(that.otherpayMoney)) return false;
        if (!lotteryMoney.equals(that.lotteryMoney)) return false;
        if (!wechatMoney.equals(that.wechatMoney)) return false;
        if (!alipayMoney.equals(that.alipayMoney)) return false;
        if (!discountMoney.equals(that.discountMoney)) return false;
        if (!giftMoney.equals(that.giftMoney)) return false;
        if (!syswipeMoney.equals(that.syswipeMoney)) return false;
        if (!manualwipeMoney.equals(that.manualwipeMoney)) return false;
        if (!overGroupon.equals(that.overGroupon)) return false;
        if (!memberCharge.equals(that.memberCharge)) return false;
        if (!memberRefund.equals(that.memberRefund)) return false;
        if (!advances.equals(that.advances)) return false;
        if (!reduction.equals(that.reduction)) return false;
        //if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        //if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        //if (timeLevel != null ? !timeLevel.equals(that.timeLevel) : that.timeLevel != null) return false;
        //if (statTime != null ? !statTime.equals(that.statTime) : that.statTime != null) return false;
        if (!maxValue.equals(that.maxValue)) return false;
        if (!avgValue.equals(that.avgValue)) return false;
        if (!memberGift.equals(that.memberGift)) return false;
        if (!memberCount.equals(that.memberCount)) return false;
        if (!chargeNum.equals(that.chargeNum)) return false;
        //if (!preferentialFree.equals(that.preferentialFree)) return false;
        //if (!grouponFree.equals(that.grouponFree)) return false;
        if (preferentialFree.compareTo(that.preferentialFree)!=0) return false;
        if (grouponFree.compareTo(that.grouponFree)!=0) return false;

        if (!membercount2money.equals(that.membercount2money)) return false;
        return membergiftMoney.equals(that.membergiftMoney);
    }

}
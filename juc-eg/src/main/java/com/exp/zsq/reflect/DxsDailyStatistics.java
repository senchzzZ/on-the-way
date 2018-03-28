package com.exp.zsq.reflect;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
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
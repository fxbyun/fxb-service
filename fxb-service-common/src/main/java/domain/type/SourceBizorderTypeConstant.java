package domain.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SourceBizorderTypeConstant {

	/**
	 * 充值订单
	 */
	public static int UsrChargeLog = 20;

	/**
	 * 投注订单tzOrder
	 */
	public static int tzOrder = 30;
	/**
	 * 追号彩期tzHoldonIssue
	 */
	public static int tzHoldonIssue = 31;
	
	/**
	 * 批量派奖
	 */
	public static int batchPrize = 40;

	/**
	 * 跟投分成派奖
	 */
	public static int gtFollowPlan = 41;
	/**
	 * 代理派奖
	 */
	public static int transferAward = 42;

	/**
	 * 提款
	 */
	public static int UsrWithDraw = 56;
	
	/**
	 * 损益资金划转
	 */
	public static int lossProfitMoneyTransfer = 67;
	
	/**
	 * 借款还款
	 */
	public static int moneyPlatConsumer = 70;
	

	/**
	 * 第三方业务单
	 */
	public static int usrThirdBusiness = 71;
	/**
	 * 部分出票
	 */
	public static int tzTicketPart = 72;
	private Integer index;
	private String desc;

	public SourceBizorderTypeConstant(Integer index, String desc) {
		super();
		this.index = index;
		this.desc = desc;
	}

	public static List<SourceBizorderTypeConstant> getSourceBizorderTypeConstantList() {
		List<SourceBizorderTypeConstant> list = new ArrayList<>();
		// list.add(new SourceBizorderTypeConstant(
		// SourceBizorderTypeConstant.betAbnormalCause, "非正常投注"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.UsrChargeLog, "充值订单"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.tzOrder, "投注订单"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.tzHoldonIssue, "追号彩期单"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.batchPrize, "批量派奖"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.UsrWithDraw, "提款"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.lossProfitMoneyTransfer, "损益资金划转"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.moneyPlatConsumer, "借款还款"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.gtFollowPlan, "赢家分成"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.transferAward, "代理交易"));
		list.add(new SourceBizorderTypeConstant(
				SourceBizorderTypeConstant.usrThirdBusiness, "第三方业务"));
		return list;
	}

	public static SourceBizorderTypeConstant getSourceBizorderTypeConstant(
			int index) {
		List<SourceBizorderTypeConstant> list = getSourceBizorderTypeConstantList();
		for (SourceBizorderTypeConstant b : list) {
			if (index == b.getIndex().intValue()) {

				return b;
			}
		}

		return null;
	}

	static private Map<Integer, Integer> payItemSourceBizOrderType2ScheduleSourceBizorderTypeMap = new HashMap<Integer, Integer>();
	static {
		payItemSourceBizOrderType2ScheduleSourceBizorderTypeMap.put(
				PayItemSourceBizOrderTypeConstant.betOrder,
				SourceBizorderTypeConstant.tzOrder);
	}

	static public int toSourceBizorderTypeConstant(int payItemSourceBizOrderType) {
		return payItemSourceBizOrderType2ScheduleSourceBizorderTypeMap
				.get(payItemSourceBizOrderType);
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
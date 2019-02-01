package domain.type;

import java.util.List;

public class TransferAwardOrderType extends BaseType {
	private static final long serialVersionUID = -52538912576267625L;

	protected TransferAwardOrderType(Integer index, String description) {
		super(index, description);
	}

	public static final TransferAwardOrderType AWARD_ORDER = new TransferAwardOrderType(1, "中奖订单");
	public static final TransferAwardOrderType PART_TICKET = new TransferAwardOrderType(2, "部分出票退款");
	public static final TransferAwardOrderType ADDITIONAL_PRIZE = new TransferAwardOrderType(3, "门店补派奖");
	
	public static final TransferAwardOrderType ADD_HD_GIFT_AMOUNT = new TransferAwardOrderType(4, "活动赠送彩金");
	
	public static List<TransferAwardOrderType> getAllList() {
		return getAll(TransferAwardOrderType.class);
	}

	public static TransferAwardOrderType valueOf(Integer index) {
		return valueOf(TransferAwardOrderType.class, index);
	}
}
